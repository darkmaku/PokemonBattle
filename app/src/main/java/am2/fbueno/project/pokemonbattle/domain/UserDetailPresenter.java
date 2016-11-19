package am2.fbueno.project.pokemonbattle.domain;

import android.widget.TextView;

import java.util.List;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.response.UserDetailResponse;
import am2.fbueno.project.pokemonbattle.data.service.DataService;
import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.entity.UserDetail;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.utility.UrlFormater;
import am2.fbueno.project.pokemonbattle.view.UserDetailView;
import am2.fbueno.project.pokemonbattle.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UserDetailPresenter {
    private UserDetailView userDetailView;
    private SecurityService securityService;
    private DataService dataService;
    private User loggedUser;

    private int currentVictories;
    private int currentBattles;
    private int currentLoses;

    private UserDetailPresenter(UserDetailView userDetailView) {
        this.securityService = ApiBuilder.getSecurityClient();
        this.dataService = ApiBuilder.getDataClient();
        this.userDetailView = userDetailView;
        this.loggedUser = SecuritySession.getUserSession(userDetailView);
        String url = UrlFormater.UrlStringFormat(loggedUser.getId());
        Call<UserDetailResponse> responseCall = this.securityService.getUserDetails(url);
        responseCall.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                UserDetailResponse userDetailResponse = response.body();
                List<UserDetail> details = userDetailResponse.getData();
                for (UserDetail userDetail : details) {
                    currentVictories = userDetail.getVictories();
                    currentLoses = userDetail.getLoses();
                    currentBattles = userDetail.getBattles();
                }
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {

            }
        });
    }



    public int getVictoriesCount() {
        return currentVictories;
    }

    public int getBattlesCount() {
        return currentBattles;
    }

    public int getLosesCount() {
        return currentLoses;
    }
}
