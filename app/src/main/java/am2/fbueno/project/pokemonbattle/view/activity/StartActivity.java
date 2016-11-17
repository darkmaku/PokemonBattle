package am2.fbueno.project.pokemonbattle.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import am2.fbueno.project.pokemonbattle.R;
import am2.fbueno.project.pokemonbattle.domain.StartPresenter;
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.view.View;

public class StartActivity extends View {
    private static final long SPLASH_SCREEN_DELAY = 2000;
    private StartPresenter startPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startPresenter = StartPresenter.make(this, LoginActivity.class, MainActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPresenter.startSession(SPLASH_SCREEN_DELAY);
    }
}
