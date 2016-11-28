package am2.fbueno.project.pokemonbattle.view;

import am2.fbueno.project.pokemonbattle.domain.BattlePresenter;

/**
 * Created by FBueno on 11/25/2016.
 */

public abstract class BattleView extends View {

    private BattlePresenter battlePresenter;

    public void setBattlePresenter(BattlePresenter battlePresenter) {
        this.battlePresenter = battlePresenter;
    }

    public BattlePresenter getBattlePresenter() {
        return battlePresenter;
    }

    public abstract void setOpponentId(String opponentId);

    public abstract String getOpponentId();

    public abstract void setResultBattle(String winner, int winnerScore, String looser, int looserScore);
}
