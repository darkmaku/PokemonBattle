package am2.fbueno.project.pokemonbattle.implementation;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.UserDetailPresenter;
import am2.fbueno.project.pokemonbattle.view.UserDetailView;

public class UserDetailImplementation extends UserDetailView {

    public UserDetailImplementation() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        FragmentManager fragmentManager = getSupportFragmentManager();
        StatusDetailImplementation statusImplementation = (StatusDetailImplementation)fragmentManager.findFragmentById(R.id.frgStatus);
        ShowDetailImplementation showImplementation =(ShowDetailImplementation)fragmentManager.findFragmentById(R.id.frgDetail);
        attachViews(statusImplementation, showImplementation);
        setUserDetailPresenter(UserDetailPresenter.Make(this));
    }
}
