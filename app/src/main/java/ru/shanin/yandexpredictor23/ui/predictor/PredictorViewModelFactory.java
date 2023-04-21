package ru.shanin.yandexpredictor23.ui.predictor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PredictorViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;


    public PredictorViewModelFactory(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PredictorViewModel(context);
    }
}