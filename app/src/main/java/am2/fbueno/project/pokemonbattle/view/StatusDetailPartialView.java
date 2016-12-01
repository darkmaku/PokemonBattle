package am2.fbueno.project.pokemonbattle.view;

import am2.fbueno.project.pokemonbattle.view.base.PartialView;

/**
 * Created by FBueno on 11/18/2016.
 */

public abstract class StatusDetailPartialView extends PartialView<UserDetailView> {
    public abstract void setVictories(int value);
    public abstract void setLoses(int value);
    public abstract void setBattles(int value);

}
