package am2.fbueno.project.pokemonbattle.view;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by FBueno on 11/18/2016.
 */

public abstract class StatusDetailPartialView extends Fragment {
    private UserDetailView userDetailView;

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof UserDetailView) {
            userDetailView = (UserDetailView) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        userDetailView = null;
    }

    public UserDetailView getUserDetailView() {
        return userDetailView;
    }

}
