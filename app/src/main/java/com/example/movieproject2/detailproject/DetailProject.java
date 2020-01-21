package com.example.movieproject2.detailproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movieproject2.R;
import com.example.movieproject2.listproject.ListProject;
import com.example.movieproject2.listmovies.WatchModel;

public class DetailProject extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvOverview = findViewById(R.id.tv_text_overview);

        ImageView imageView = findViewById(R.id.imageposter);
        WatchModel wacthModel = getIntent().getParcelableExtra(ListProject.SELECTED_PROJECT);
        tvTitle.setText(wacthModel.getTitle());
        tvOverview.setText(wacthModel.getOverview());
        imageView.setImageResource(wacthModel.getPoster());
        setTitle(wacthModel.getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
