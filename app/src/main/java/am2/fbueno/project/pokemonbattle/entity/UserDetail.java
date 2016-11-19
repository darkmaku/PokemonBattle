package am2.fbueno.project.pokemonbattle.entity;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UserDetail {
    private int victories;
    private int level;
    private int loses;
    private int battles;

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }
}
