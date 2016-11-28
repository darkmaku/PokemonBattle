package am2.fbueno.project.pokemonbattle.domain;

import android.util.Log;

import java.util.List;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.response.BattleDetailResponse;
import am2.fbueno.project.pokemonbattle.data.response.UserDetailResponse;
import am2.fbueno.project.pokemonbattle.data.service.DataService;
import am2.fbueno.project.pokemonbattle.data.service.UserService;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.entity.UserDetail;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.utility.UrlFormater;
import am2.fbueno.project.pokemonbattle.view.UserDetailView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UserDetailPresenter {
    private static final String URL_USER_DETAIL = "/v1/data/UserDetail";
    private static final String URL_BATTLE_WINNER = "/v1/data/UserBattle?where=winner%3D";
    private static final String URL_BATTLE_LOOSER ="/v1/data/UserDetail?where=looser%3D";
    private static final String URL_BATTLES ="/v1/data/UserDetail?where=";

    private UserDetailView userDetailView;

    private UserService userService;
    private DataService dataService;

    private User loggedUser;

    public void showLooses(){
        showBattles(buildLooserBattlesUrl());
    }

    public void showVictories() {
        showBattles(buildWinnerBattlesUrl());
    }

    private String buildLooserBattlesUrl(){
        String urlParameter = UrlFormater.UrlStringFormat(loggedUser.getId());
        return UrlFormater.UrlConcat(URL_BATTLE_LOOSER, urlParameter);
    }

    private String buildWinnerBattlesUrl(){
        String urlParameter = UrlFormater.UrlStringFormat(loggedUser.getId());
        return UrlFormater.UrlConcat(URL_BATTLE_WINNER, urlParameter);
    }

    private void showBattles(String url){
        Call<BattleDetailResponse> responseCall = dataService.getBattles(url);
        responseCall.enqueue(new Callback<BattleDetailResponse>() {
            @Override
            public void onResponse(Call<BattleDetailResponse> call, Response<BattleDetailResponse> response) {
                BattleDetailResponse detailResponse = response.body();
                userDetailView.showBattlesDetail(detailResponse.getData());
            }

            @Override
            public void onFailure(Call<BattleDetailResponse> call, Throwable t) {
                userDetailView.showMessage("Error en la infomación que se muestra");
            }
        });
    }

    public static UserDetailPresenter Make(UserDetailView userDetailView)
    {
        return new UserDetailPresenter(userDetailView);
    }

    private UserDetailPresenter(UserDetailView userDetailView) {
        this.userDetailView = userDetailView;
        buildFields();
        initializeDefaultValues();
    }

    private void buildFields() {
        dataService = ApiBuilder.getDataClient();
        userService = ApiBuilder.getUserClient();
        loggedUser = SecuritySession.getUserSession(userDetailView);
    }

    private void initializeDefaultValues(){
        String url = buildUserDetailUrl();
        Log.v("url", url);
        Call<UserDetailResponse> responseCall = userService.getUserDetails(url);
        responseCall.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                UserDetailResponse userDetailResponse = response.body();
                List<UserDetail> details = userDetailResponse.getData();
                if (details.size() > 1) {
                    userDetailView.showMessage("Error en la infomación que se muestra");
                    return;
                }
                UserDetail userDetail = details.get(0);
                userDetailView.showVictoriesCount(userDetail.getVictories());
                userDetailView.showLossesCount(userDetail.getLoses());
                userDetailView.showBattlesCount(userDetail.getBattles());
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                userDetailView.showMessage("Error en la infomación que se muestra");
            }
        });
    }

    private String buildUserDetailUrl(){
        String urlParameter = UrlFormater.UrlStringFormat(loggedUser.getId());
        return UrlFormater.UrlConcat(URL_USER_DETAIL, "?where=ownerId%3D", urlParameter);
    }
}
