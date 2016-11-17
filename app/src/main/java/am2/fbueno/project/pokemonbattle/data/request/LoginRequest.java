package am2.fbueno.project.pokemonbattle.data.request;

/**
 * Created by Alumno-J on 09/11/2016.
 */
public class LoginRequest {
    private String login;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
