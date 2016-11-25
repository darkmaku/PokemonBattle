package am2.fbueno.project.pokemonbattle.view;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by FBueno on 11/18/2016.
 */

public abstract class StatusDetailPartialView extends Fragment {

    private UserDetailView userDetailView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        userDetailView = (UserDetailView)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        userDetailView = null;
    }

    public UserDetailView getUserDetailView(){
        return userDetailView;
    }

    public abstract void setVictories(int value);

    public abstract void setLoses(int value);

    public abstract void setBattles(int value);

}
