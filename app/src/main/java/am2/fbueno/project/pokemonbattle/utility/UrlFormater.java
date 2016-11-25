package am2.fbueno.project.pokemonbattle.utility;

/**
 * Created by FBueno on 11/18/2016.
 */

public class UrlFormater {
    public static String UrlStringFormat(String value){
        return String.format("%27%s%27", value);
    }

    public static String UrlConcat(String url, String... values){
        StringBuilder builder = new StringBuilder(url);
        for (String value : values) {
            builder.append(value);
        }
        return builder.toString();
    }
}
