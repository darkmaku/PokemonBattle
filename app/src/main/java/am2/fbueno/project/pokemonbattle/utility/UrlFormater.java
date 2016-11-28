package am2.fbueno.project.pokemonbattle.utility;

import android.util.Log;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UrlFormater {
    public static String UrlStringFormat(String value){
        return "%27"+value+"%27";
    }

    public static String UrlConcat(String url, String... values){
        StringBuilder builder = new StringBuilder(url);
        for (String value : values) {
            builder.append(value);
        }
        return builder.toString();
    }
}
