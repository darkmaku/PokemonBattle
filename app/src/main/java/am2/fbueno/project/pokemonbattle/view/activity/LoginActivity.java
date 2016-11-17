package am2.fbueno.project.pokemonbattle.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.LoginPresenter;
import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView  {

    private EditText txtLogin;
    private EditText txtPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeComponents();
    }

    @Override
    public void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void gotoMain(User user) {
        saveSession(user);
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void initializeComponents(){
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginPresenter = LoginPresenter.MakePresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = txtLogin.getText().toString();
                String password = txtPassword.getText().toString();
                loginPresenter.login(login, password);
            }
        });
    }

    private void saveSession(User user) {
        SecuritySession.signIn(this, user);
    }
}
