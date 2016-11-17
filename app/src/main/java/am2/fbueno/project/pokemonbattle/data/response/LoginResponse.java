package am2.fbueno.project.pokemonbattle.data.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alumno-J on 09/11/2016.
 */
public class LoginResponse {
    @SerializedName("ownerId")
    private String id;
    private String name;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
