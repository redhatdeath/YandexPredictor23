package ru.shanin.yandexpredictor23.ui.main;

import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.shanin.yandexpredictor23.api.config.APIConfigYandexPredictor;
import ru.shanin.yandexpredictor23.app.AppStart;
import ru.shanin.yandexpredictor23.data.ResponseData;

public class MainViewModel extends ViewModel {

    public void getReport(String inputText) {

        Call<ResponseData> call = AppStart
                .getService()
                .predict(
                        APIConfigYandexPredictor.KEY,
                        inputText,
                        "ru"
                );
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                StringBuilder textWord = new StringBuilder();
                try {
                    for (String s : response.body().getText())
                        textWord.append("\t").append(s).append("\n");
                    MainFragment.updateText("Предиктор : \n" + textWord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });
    }


}