package ru.shanin.yandexpredictor23.app;

import android.app.Application;

import ru.shanin.yandexpredictor23.api.APIServiceConstructor;
import ru.shanin.yandexpredictor23.api.config.APIConfigYandexPredictor;
import ru.shanin.yandexpredictor23.api.config.APIServiceYandexPredictor;

public class AppStart extends Application {
    private static APIServiceYandexPredictor service;

    @Override
    public void onCreate() {
        super.onCreate();
        createService();
    }

    private void createService() {
        service = APIServiceConstructor.CreateService(
                APIServiceYandexPredictor.class,
                APIConfigYandexPredictor.HOST_URL);
    }

    public static APIServiceYandexPredictor getService() {
        return service;
    }
}
