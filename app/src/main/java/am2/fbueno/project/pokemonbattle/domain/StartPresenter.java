package am2.fbueno.project.pokemonbattle.domain;

import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

import am2.fbueno.project.pokemonbattle.utility.SecuritySession;
import am2.fbueno.project.pokemonbattle.view.View;
import am2.fbueno.project.pokemonbattle.view.activity.LoginActivity;
import am2.fbueno.project.pokemonbattle.view.activity.MainActivity;
import am2.fbueno.project.pokemonbattle.view.activity.StartActivity;

/**
 * Created by FBueno on 11/16/2016.
 */

public class StartPresenter {
    private View startActivity;
    private Class<?> loginActivity;
    private Class<?> mainActivity;

    private StartPresenter(View startActivity, Class<?> loginActivity, Class<?> mainActivity) {
        this.startActivity = startActivity;
        this.loginActivity = loginActivity;
        this.mainActivity = mainActivity;
    }

    public static StartPresenter make(View startActivity, Class<?> loginActivity, Class<?> mainActivity){
        return new StartPresenter(startActivity, loginActivity, mainActivity);
    }

    public void startSession(long screenDelay)
    {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                boolean signed = SecuritySession.hasLogged(startActivity);
                Class<?> activity = switchActivity(signed);
                Intent intent = new Intent(startActivity, activity);
                startActivity.startActivity(intent);
                startActivity.finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, screenDelay);
    }
    private Class<?> switchActivity(boolean validator) {
        return validator ? mainActivity : loginActivity;
    }
}
