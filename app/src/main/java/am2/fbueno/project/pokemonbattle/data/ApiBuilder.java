package am2.fbueno.project.pokemonbattle.data;

import am2.fbueno.project.pokemonbattle.data.service.SecurityService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by FBueno on 11/11/2016.
 */

public class ApiBuilder {
    private static final String API_BASE_URL = "http://api.backendless.com";
    private static SecurityService securityApi;
    private static OkHttpClient.Builder httpClient;

    public static SecurityService getSecurityClient() {
        if (securityApi == null) {

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            securityApi = retrofit.create(SecurityService.class);
        }
        return securityApi;
    }

    private static HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
