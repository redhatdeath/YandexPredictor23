package ru.shanin.yandexpredictor23.api.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.shanin.yandexpredictor23.data.ResponseData;

public interface APIServiceYandexPredictor {
    @GET("api/v1/predict.json/complete")
    Call<ResponseData> predict(
            @Query("key") String key,
            @Query("q") String q,
            @Query("lang") String lang
    );
}
