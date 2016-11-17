package am2.fbueno.project.pokemonbattle.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import am2.fbueno.project.pokemonbattle.entity.User;

/**
 * Created by FBueno on 11/11/2016.
 */

public class SecuritySession {
    private static final String SECURITY_SESSION = "securitySession";
    private static final String USER_KEY = SECURITY_SESSION + ".userValue";

    private SecuritySession() {
    }

    public static void signOut(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(USER_KEY);
        editor.apply();
    }

    public static void signIn(Context context, User user)
    {
        SharedPreferences.Editor editor = getEditor(context);
        Gson jsonParser = new Gson();
        String userJson = jsonParser.toJson(user);
        editor.putString(USER_KEY, userJson);
        editor.apply();
    }

    public static User getUserSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        Gson jsonParser = new Gson();
        String userJson = sharedPreferences.getString(USER_KEY,null);
        return jsonParser.fromJson(userJson, User.class);
    }

    public static boolean hasLogged(Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(USER_KEY);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SECURITY_SESSION, Context.MODE_PRIVATE);
    }
}
