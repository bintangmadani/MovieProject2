package com.example.movieproject2.listtvshowproject;

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
import com.example.movieproject2.listmovies.WatchModel;

public class ListTvProjectFragmentProject extends Fragment {

    private ListTvProjectViewModelProject mviewmodel;
    private ListWatchAdapter madapter;

    public static ListTvProjectFragmentProject newInstance() { return new ListTvProjectFragmentProject(); }

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
        mviewmodel = ViewModelProviders.of(this).get(ListTvProjectViewModelProject.class);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_theflash), getString(R.string.overview_theflash), R.drawable.poster_theflash);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_family), getString(R.string.overview_family), R.drawable.poster_family);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_naruto), getString(R.string.overview_naruto), R.drawable.poster_naruto);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_legacies), getString(R.string.overview_legacies), R.drawable.poster_legacies);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_stranger), getString(R.string.overview_stranger), R.drawable.poster_stranger);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_dragon), getString(R.string.overview_dragon), R.drawable.poster_dragon);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_robot), getString(R.string.overview_robot), R.drawable.poster_robot);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_pokemon), getString(R.string.overview_pokemon), R.drawable.poster_pokemon);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_tom), getString(R.string.overview_tom), R.drawable.poster_tom);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_punchman), getString(R.string.overview_punchman), R.drawable.poster_punchman);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_batman), getString(R.string.overview_batman) , R.drawable.poster_batman);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_gumball), getString(R.string.overview_gumball), R.drawable.poster_gumbal);
        mviewmodel.addTvShowModel(getResources().getString(R.string.title_boruto), getString(R.string.overview_boruto), R.drawable.poster_boruto);

        madapter = new ListWatchAdapter(view.getContext(),mviewmodel.getTvShowList());
        recyclerView.setAdapter(madapter);
        recyclerView.setHasFixedSize(true);

        madapter.SetOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent gotodetailMovie = new Intent(view.getContext(), DetailProject.class);
                gotodetailMovie.putExtra(ListProject.SELECTED_PROJECT,model);
                startActivity(gotodetailMovie);

            }
        });
    }
}
