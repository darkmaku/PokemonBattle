package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.view.ShowDetailPartialView;
import am2.fbueno.project.pokemonbattle.view.StatusDetailPartialView;
import am2.fbueno.project.pokemonbattle.view.UserDetailView;

public class UserDetailImplementation extends UserDetailView {

    public UserDetailImplementation() {
        super(new StatusDetailImplementation(), new ShowDetailImplementation());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
    }
}
