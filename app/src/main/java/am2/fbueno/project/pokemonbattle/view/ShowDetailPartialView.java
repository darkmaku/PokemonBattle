package am2.fbueno.project.pokemonbattle.view;

import java.util.List;

import am2.fbueno.project.pokemonbattle.entity.BattleDetail;
import am2.fbueno.project.pokemonbattle.view.base.PartialView;

/**
 * Created by FBueno on 11/18/2016.
 */

public abstract class ShowDetailPartialView extends PartialView<UserDetailView> {
    public abstract void setBattlesDetail(List<BattleDetail> battles);
}
