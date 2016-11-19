package am2.fbueno.project.pokemonbattle.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import am2.fbueno.project.pokemonbattle.entity.User;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;

/**
 * Created by FBueno on 11/11/2016.
 */

public abstract class LoginView extends View {
    protected Class<?> mainClass;

    public LoginView(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public void gotoMain(User user) {
        saveSession(user);
        Intent intent = new Intent(this, mainClass);
        startActivity(intent);
    }

    private void saveSession(User user) {
        SecuritySession.signIn(this, user);
    }
}
