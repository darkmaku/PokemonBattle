package am2.fbueno.project.pokemonbattle.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by FBueno on 11/11/2016.
 */

public abstract class View extends AppCompatActivity {
    public void showMessage(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
    }

    public Context getContext(){
        return this;
    }
}
