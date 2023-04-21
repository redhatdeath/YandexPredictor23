package ru.shanin.yandexpredictor23.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.shanin.yandexpredictor23.R;
import ru.shanin.yandexpredictor23.ui.predictor.PredictorFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PredictorFragment.newInstance())
                    .commitNow();
        }
    }
}