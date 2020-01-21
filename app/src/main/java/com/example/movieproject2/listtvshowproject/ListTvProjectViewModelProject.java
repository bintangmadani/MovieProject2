package com.example.movieproject2.listtvshowproject;

import androidx.lifecycle.ViewModel;

import com.example.movieproject2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListTvProjectViewModelProject extends ViewModel {
    private ArrayList<WatchModel> modelList =new ArrayList<>();

    public void addTvShowModel(String title, String overview, Integer poster) {
        this.modelList.add(new WatchModel(title,overview,poster));
    }

    public ArrayList<WatchModel> getTvShowList() { return modelList; }
}
