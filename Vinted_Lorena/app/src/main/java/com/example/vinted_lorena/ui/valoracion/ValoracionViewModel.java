package com.example.vinted_lorena.ui.valoracion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ValoracionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ValoracionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}