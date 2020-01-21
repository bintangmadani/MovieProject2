package com.example.movieproject2.ui.project;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewProject extends ViewModel {

    private MutableLiveData<Integer> mindex = new MutableLiveData<>();
    private LiveData<String> mtext = Transformations.map(mindex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello World From Section; " + input;
        }
    });

    public void setIndex(int index) { mindex.setValue(index); }

    public LiveData<String> gettext() { return mtext; }
}
