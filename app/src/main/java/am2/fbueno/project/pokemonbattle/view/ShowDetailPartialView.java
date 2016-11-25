package am2.fbueno.project.pokemonbattle.view;

import android.support.v4.app.Fragment;

import java.util.List;

import am2.fbueno.project.pokemonbattle.entity.BattleDetail;

/**
 * Created by FBueno on 11/18/2016.
 */

public abstract class ShowDetailPartialView extends Fragment{
    public abstract void setBattlesDetail(List<BattleDetail> battles);
}
