package am2.fbueno.project.pokemonbattle.data.response;

import java.util.List;

import am2.fbueno.project.pokemonbattle.entity.Player;

/**
 * Created by FBueno on 11/25/2016.
 */

public class UserListResponse {
    private List<Player> data;
    private int totalObjects;

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public void setTotalObjects(int totalObjects) {
        this.totalObjects = totalObjects;
    }
}
