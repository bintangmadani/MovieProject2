package com.example.movieproject2.ui.project;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieproject2.R;
import com.example.movieproject2.listmovies.ListMoviesFragment;
import com.example.movieproject2.listtvshowproject.ListTvProjectFragmentProject;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TABS_TITLES = new int[]{R.string.tabs_text_1, R.string.tabs_text_2};
    private final Context mcontext;
    private ListMoviesFragment moviesFragment;
    private ListTvProjectFragmentProject tvShowFragment;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mcontext = context;
        moviesFragment = new ListMoviesFragment();
        tvShowFragment = new ListTvProjectFragmentProject();
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0 :
               return new ListMoviesFragment();
           case 1 :
               return new ListTvProjectFragmentProject();
               default:
                   return null;
       }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mcontext.getResources().getString(TABS_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
