package ru.shanin.yandexpredictor23.ui.predictor;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.shanin.yandexpredictor23.R;
import ru.shanin.yandexpredictor23.databinding.FragmentMainBinding;

public class PredictorFragment extends Fragment {

    private PredictorViewModel mViewModel;
    private FragmentMainBinding binding;

    public static PredictorFragment newInstance() {
        return new PredictorFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initView();
    }


    private void initView() {
        binding.et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0)
                    mViewModel.getReport(s.toString());
                else
                    binding.tv.setText(getResources().getString(R.string.empty));
            }
        });
    }

    private void initViewModel() {

        mViewModel = new ViewModelProvider(
                this,
                new PredictorViewModelFactory(getContext()))
                .get(PredictorViewModel.class);
        mViewModel.getPredictorLiveData().observe(
                getViewLifecycleOwner(),
                s -> binding.tv.setText(s)
        );
    }
}