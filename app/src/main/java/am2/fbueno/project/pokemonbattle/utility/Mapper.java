package am2.fbueno.project.pokemonbattle.utility;

import am2.fbueno.project.pokemonbattle.data.response.LoginResponse;
import am2.fbueno.project.pokemonbattle.entity.User;

/**
 * Created by FBueno on 11/11/2016.
 */

public class Mapper {
    public static User ParseLoginResponse(LoginResponse response){
        User user = new User();
        user.setId(response.getId());
        user.setName(response.getName());
        return user;
    }
}
