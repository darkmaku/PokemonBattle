package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.LoginPresenter;
import am2.fbueno.project.pokemonbattle.view.LoginView;

public class LoginImplementation extends LoginView  {

    private EditText txtLogin;
    private EditText txtPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    public LoginImplementation(){
        super(MainImplementation.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeComponents();
    }

    private void initializeComponents(){
        loginPresenter = LoginPresenter.MakePresenter(this);
        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = txtLogin.getText().toString();
                String password = txtPassword.getText().toString();
                loginPresenter.login(login, password);
            }
        });
    }
}
