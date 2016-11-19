package am2.fbueno.project.pokemonbattle.domain;

import am2.fbueno.project.pokemonbattle.data.ApiBuilder;
import am2.fbueno.project.pokemonbattle.data.request.LoginRequest;
import am2.fbueno.project.pokemonbattle.data.response.LoginResponse;
import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.utility.Mapper;
import am2.fbueno.project.pokemonbattle.view.LoginView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by FBueno on 11/11/2016.
 */

public class LoginPresenter {
    private SecurityService securityService;
    private LoginView loginView;

    private LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        this.securityService = ApiBuilder.getSecurityClient();
    }

    public static LoginPresenter MakePresenter(LoginView loginView) {
        return new LoginPresenter(loginView);
    }

    public void login(String login, String password) {
        LoginRequest request = new LoginRequest(login, password);
        Call<LoginResponse> responseCall = securityService.login(request);
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse responseLogin = response.body();
                    User user = Mapper.ParseLoginResponse(responseLogin);
                    loginView.gotoMain(user);
                } else {
                    loginView.showMessage("Error al ingresar al sistema!");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginView.showMessage(new StringBuffer().append(t.getMessage()).toString());
            }
        });
    }
}
