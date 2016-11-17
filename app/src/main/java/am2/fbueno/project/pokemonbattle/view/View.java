package am2.fbueno.project.pokemonbattle.view;

import android.content.Context;

/**
 * Created by FBueno on 11/11/2016.
 */

public interface View {
    void showMessage(Context context, String message);
    Context getContext();
}
