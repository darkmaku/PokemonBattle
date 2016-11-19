package am2.fbueno.project.pokemonbattle.implementation;

import android.os.Bundle;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.StartPresenter;
import am2.fbueno.project.pokemonbattle.view.View;

public class StartImplementation extends View {
    private static final long SPLASH_SCREEN_DELAY = 2000;
    private StartPresenter startPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startPresenter = StartPresenter.make(this, LoginImplementation.class, MainImplementation.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPresenter.startSession(SPLASH_SCREEN_DELAY);
    }
}
