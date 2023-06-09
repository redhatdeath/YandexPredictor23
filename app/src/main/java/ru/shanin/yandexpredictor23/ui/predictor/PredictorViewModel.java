package ru.shanin.yandexpredictor23.ui.predictor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.shanin.yandexpredictor23.R;
import ru.shanin.yandexpredictor23.api.config.APIConfigYandexPredictor;
import ru.shanin.yandexpredictor23.app.AppStart;
import ru.shanin.yandexpredictor23.data.ResponseData;

public class PredictorViewModel extends ViewModel {
    private final MutableLiveData<String> predictorLiveData;

    public PredictorViewModel(Context context) {
        predictorLiveData = new MutableLiveData<>();
        predictorLiveData.setValue(
                context.getResources().getString(R.string.empty));
    }

    public MutableLiveData<String> getPredictorLiveData() {
        return predictorLiveData;
    }

    public void getReport(String inputText) {

        Call<ResponseData> call = AppStart
                .getService()
                .predict(APIConfigYandexPredictor.KEY, inputText, "ru", 5);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(
                    @NonNull Call<ResponseData> call,
                    @NonNull Response<ResponseData> response
            ) {
                StringBuilder textWord = new StringBuilder();
                try {
                    assert response.body() != null;
                    for (String s : response.body().getText())
                        textWord.append("\t").append(s).append("\n");
                    predictorLiveData.setValue("Предиктор : \n" + textWord);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(
                    @NonNull Call<ResponseData> call,
                    @NonNull Throwable t
            ) {
            }
        });
    }
}