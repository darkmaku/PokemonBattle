package am2.fbueno.project.pokemonbattle.domain;

import android.util.Log;

import java.util.List;
import java.util.Random;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.request.AddBattleRequest;
import am2.fbueno.project.pokemonbattle.data.response.AddBattleResponse;
import am2.fbueno.project.pokemonbattle.data.response.UserListResponse;
import am2.fbueno.project.pokemonbattle.data.service.BattleService;
import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import am2.fbueno.project.pokemonbattle.entity.Player;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.view.BattleView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by FBueno on 11/25/2016.
 */

public class BattlePresenter {
    private SecurityService securityService;
    private BattleService battleService;

    private User loggedUser;

    private BattleView battleView;

    public static BattlePresenter Make(BattleView view){
        return new BattlePresenter(view);
    }

    private BattlePresenter(BattleView battleView){
        this.battleView = battleView;
        this.securityService = ApiBuilder.getSecurityClient();
        this.battleService = ApiBuilder.getBattleClient();
        loggedUser = SecuritySession.getUserSession(battleView);
    }

    public void startBattle(){
        AddBattleRequest addBattleRequest = new AddBattleRequest();
        addBattleRequest.setWinner(loggedUser.getId());
        addBattleRequest.setLooser(battleView.getOpponentId());
        addBattleRequest.setWinnerScore(10);
        addBattleRequest.setLooserScore(5);
        Call<AddBattleResponse> detailCall = battleService.addBattle(addBattleRequest);
        detailCall.enqueue(new Callback<AddBattleResponse>() {
            @Override
            public void onResponse(Call<AddBattleResponse> call, Response<AddBattleResponse> response) {
                AddBattleResponse battleResponse = response.body();
                battleView.setResultBattle(battleResponse.getWinner(), battleResponse.getWinnerScore(), battleResponse.getLooser(), battleResponse.getLooserScore());
            }

            @Override
            public void onFailure(Call<AddBattleResponse> call, Throwable t) {

            }
        });
    }

    public void findOpponent(){
        Call<UserListResponse> responseCall = securityService.getUsers();
        responseCall.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                UserListResponse listResponse = response.body();
                List<Player> players = listResponse.getData();
                Log.v("players", players.size()+"");
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
