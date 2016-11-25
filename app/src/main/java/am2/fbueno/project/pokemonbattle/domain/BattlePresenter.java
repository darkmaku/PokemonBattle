package am2.fbueno.project.pokemonbattle.domain;

import java.util.List;
import java.util.Random;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.response.UserListResponse;
import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import am2.fbueno.project.pokemonbattle.entity.Player;
import am2.fbueno.project.pokemonbattle.view.BattleView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by FBueno on 11/25/2016.
 */

public class BattlePresenter {
    private SecurityService securityService;
    private BattleView battleView;

    private BattlePresenter(BattleView battleView){
        this.battleView = battleView;
        this.securityService = ApiBuilder.getSecurityClient();
    }

    public void startBattle(){

    }

    public void findOpponent(){
        Call<UserListResponse> responseCall = securityService.getUsers();
        responseCall.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                UserListResponse listResponse = response.body();
                List<Player> players = listResponse.getData();
                Random random = new Random();
                int result = random.nextInt(players.size());
                Player player = players.get(result);
                battleView.setOpponentId(player.getObjectId());
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {

            }
        });
    }
}
