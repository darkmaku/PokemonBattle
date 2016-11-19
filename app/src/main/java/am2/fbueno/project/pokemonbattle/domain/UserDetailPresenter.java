package am2.fbueno.project.pokemonbattle.domain;

import android.widget.TextView;

import java.util.List;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.response.UserDetailResponse;
import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.entity.UserDetail;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
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

    private UserDetailPresenter(UserDetailView userDetailView, final TextView victories, final TextView loses, final TextView battles){
        this.securityService = ApiBuilder.getSecurityClient();
        User loggedUser = SecuritySession.getUserSession(userDetailView);
        String url = "%27"+loggedUser.getId()+"%27";
        Call<UserDetailResponse> responseCall = this.securityService.getUserDetails(url);
        responseCall.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                UserDetailResponse userDetailResponse = response.body();
                List<UserDetail> details = userDetailResponse.getData();
                for (UserDetail userDetail : details) {
                    victories.setText(userDetail.getVictories());
                    loses.setText(userDetail.getLoses());
                    battles.setText(userDetail.getBattles());
                }
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {

            }
        });
    }
}
