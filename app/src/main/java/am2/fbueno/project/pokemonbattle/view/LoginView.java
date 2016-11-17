package am2.fbueno.project.pokemonbattle.view;

import android.content.Context;

import am2.fbueno.project.pokemonbattle.entity.User;

/**
 * Created by FBueno on 11/11/2016.
 */

public interface LoginView extends View{
    void gotoMain(User user);
}
