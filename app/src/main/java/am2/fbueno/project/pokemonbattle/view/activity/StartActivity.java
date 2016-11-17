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
import am2.fbueno.project.pokemonbattle.utility.SecuritySession;

public class StartActivity extends ActionBarActivity {
    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TimerTask task = new TimerTask()
        {
            @Override
            public void run() {
                Intent intent;
                boolean signed= SecuritySession.hasLogged(StartActivity.this);
                if(signed)
                {
                    intent=new Intent(StartActivity.this, MainActivity.class);
                }else {
                    intent = new Intent(StartActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private Class<?> switchActivity(boolean validator){
        return validator ? MainActivity.class : LoginActivity.class;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

}
