package am2.fbueno.project.pokemonbattle.data.response;

import java.util.List;

import am2.fbueno.project.pokemonbattle.entity.BattleDetail;

/**
 * Created by FBueno on 11/23/2016.
 */

public class BattleDetailResponse {
    private List<BattleDetail> data;
    private int totalObjects;

    public List<BattleDetail> getData() {
        return data;
    }

    public void setData(List<BattleDetail> data) {
        this.data = data;
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public void setTotalObjects(int totalObjects) {
        this.totalObjects = totalObjects;
    }
}
