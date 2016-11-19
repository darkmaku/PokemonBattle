package am2.fbueno.project.pokemonbattle.entity;

/**
 * Created by FBueno on 11/18/2016.
 */

public class BattleDetail {
    private String winner;
    private String looser;
    private int winnerScore;
    private int looserScore;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLooser() {
        return looser;
    }

    public void setLooser(String looser) {
        this.looser = looser;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getLooserScore() {
        return looserScore;
    }

    public void setLooserScore(int looserScore) {
        this.looserScore = looserScore;
    }
}
