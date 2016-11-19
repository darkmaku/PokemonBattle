package am2.fbueno.project.pokemonbattle.data.response;

import java.util.List;

import am2.fbueno.project.pokemonbattle.entity.UserDetail;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UserDetailResponse {
    private List<UserDetail> data;
    private int totalObjects;

    public List<UserDetail> getData() {
        return data;
    }

    public void setData(List<UserDetail> data) {
        this.data = data;
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public void setTotalObjects(int totalObjects) {
        this.totalObjects = totalObjects;
    }
}
