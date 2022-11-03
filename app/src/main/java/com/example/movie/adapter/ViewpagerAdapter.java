package com.example.movie.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.movie.fragment.AboutFragment;
import com.example.movie.fragment.MovieFavouriteFragment;
import com.example.movie.fragment.MovieListFragment;
import com.example.movie.fragment.SettingFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {


    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 1:
                fragment = new MovieFavouriteFragment();
                break;
            case 2:
                fragment = new SettingFragment();
                break;
            case 3:
                fragment = new AboutFragment();
                break;
            default:
                fragment = new MovieListFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
