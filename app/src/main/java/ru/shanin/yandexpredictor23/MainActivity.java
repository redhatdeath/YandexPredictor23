package ru.shanin.yandexpredictor23;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.shanin.yandexpredictor23.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}