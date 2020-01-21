package com.example.movieproject2.listmovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject2.R;
import com.example.movieproject2.detailproject.DetailProject;
import com.example.movieproject2.listproject.ListProject;
import com.example.movieproject2.listproject.ListWatchAdapter;

public class ListMoviesFragment extends Fragment {

    private ListMoviesViewModel mViewModeProject;
    private ListWatchAdapter madapter;

    public static ListMoviesFragment newsInstance() { return new ListMoviesFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_projects_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModeProject = ViewModelProviders.of(this).get(ListMoviesViewModel.class);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_aladdin), getResources().getString(R.string.overview_aladdin), R.drawable.poster_aladdin);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_joker), getResources().getString(R.string.overview_joker), R.drawable.poster_joker);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_zombieland), getResources().getString(R.string.overview_zombieland), R.drawable.poster_zombieland);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_doctor), getResources().getString(R.string.overview_doctor), R.drawable.poster_doctor);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_spiderman), getResources().getString(R.string.overview_spiderman), R.drawable.poster_spiderman);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_fast), getResources().getString(R.string.overview_fast), R.drawable.poster_fast);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_theking), getResources().getString(R.string.overview_theking), R.drawable.poster_theking);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_thelion), getResources().getString(R.string.thelion), R.drawable.poster_thelion);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_onepiece), getResources().getString(R.string.overview_onepiece), R.drawable.poster_onepiece);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_dora), getResources().getString(R.string.overview_dora), R.drawable.poster_dora);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_goodboy), getResources().getString(R.string.overview_goodboy), R.drawable.poster_goodboy);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_it), getResources().getString(R.string.overview_it), R.drawable.poster_it);
        mViewModeProject.addMovieModel(getResources().getString(R.string.title_john), getResources().getString(R.string.overview_john), R.drawable.poster_john);

        madapter = new ListWatchAdapter(view.getContext(),mViewModeProject.getModelList());
        recyclerView.setAdapter(madapter);
        recyclerView.setHasFixedSize(true);

        madapter.SetOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent gotodetailmovie = new Intent(view.getContext(), DetailProject.class);
                gotodetailmovie.putExtra(ListProject.SELECTED_PROJECT,model);
                startActivity(gotodetailmovie);
            }
        });

    }
}
