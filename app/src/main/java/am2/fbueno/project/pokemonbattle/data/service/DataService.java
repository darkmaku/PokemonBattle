package am2.fbueno.project.pokemonbattle.data.service;

import am2.fbueno.project.pokemonbattle.entity.BattleDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by FBueno on 11/18/2016.
 */

public interface DataService {
    @Headers({
            "content-type: application/json",
            "application-id: 36ADC0BF-BC45-AF00-FFBB-9F2C409F7200",
            "secret-key: 65E0A253-9DAE-3F98-FF8C-F02429CA7B00",
            "application-type: REST"
    })
    @GET("/v1/data/UserBattle?where=winner%3D")
    Call<BattleDetail> getWins(String url);

    @Headers({
            "content-type: application/json",
            "application-id: 36ADC0BF-BC45-AF00-FFBB-9F2C409F7200",
            "secret-key: 65E0A253-9DAE-3F98-FF8C-F02429CA7B00",
            "application-type: REST"
    })
    @GET("/v1/data/UserDetail?where=looser%3D")
    Call<BattleDetail> getLoses(String url);

    @Headers({
            "content-type: application/json",
            "application-id: 36ADC0BF-BC45-AF00-FFBB-9F2C409F7200",
            "secret-key: 65E0A253-9DAE-3F98-FF8C-F02429CA7B00",
            "application-type: REST"
    })
    @GET("/v1/data/UserDetail?where=")
    Call<BattleDetail> getBattles(String url);
}
