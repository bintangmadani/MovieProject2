package com.example.movieproject2.listproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject2.R;
import com.example.movieproject2.detailproject.DetailProject;
import com.example.movieproject2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListProject extends AppCompatActivity {
    private RecyclerView recycler_View;
    private ListWatchAdapter madapter;

    private ArrayList<WatchModel> movieModelsProject = new ArrayList<>();
    public static final String SELECTED_PROJECT = "selected_movie";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recycler_View = findViewById(R.id.recycler_view);
    }


    private void setAdapter() {

        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_aladdin), getString(R.string.overview_aladdin), R.drawable.poster_aladdin));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_joker), getString(R.string.overview_joker), R.drawable.poster_joker));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_zombieland), getString(R.string.overview_zombieland), R.drawable.poster_zombieland));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_doctor), getString(R.string.overview_doctor), R.drawable.poster_doctor));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_spiderman), getString(R.string.overview_spiderman), R.drawable.poster_spiderman));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_fast), getString(R.string.overview_fast), R.drawable.poster_fast));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_theking), getString(R.string.overview_theking), R.drawable.poster_theking));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_thelion), getString(R.string.thelion), R.drawable.poster_thelion));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_onepiece), getString(R.string.overview_onepiece), R.drawable.poster_onepiece));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_dora), getString(R.string.overview_dora), R.drawable.poster_dora));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_goodboy), getString(R.string.overview_goodboy), R.drawable.poster_goodboy));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_it), getString(R.string.overview_it), R.drawable.poster_it));
        movieModelsProject.add(new WatchModel(getResources().getString(R.string.title_john), getString(R.string.overview_john), R.drawable.poster_john));


        madapter = new ListWatchAdapter(ListProject.this, movieModelsProject);

        recycler_View.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recycler_View.setLayoutManager(layoutManager);
        recycler_View.setAdapter(madapter);

        madapter.SetOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(ListProject.this, DetailProject.class);
                goToDetailMovie.putExtra(ListProject.SELECTED_PROJECT, model);
                startActivity(goToDetailMovie);
            }
        });
    }

}
