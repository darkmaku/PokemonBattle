package am2.fbueno.project.pokemonbattle.view.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by FBueno on 11/30/2016.
 */

public abstract class PartialView<T extends View> extends Fragment {
    private T view;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        view = (T)activity;
    }

    public T getAttachedView(){
        return  view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        view = null;
    }
}
