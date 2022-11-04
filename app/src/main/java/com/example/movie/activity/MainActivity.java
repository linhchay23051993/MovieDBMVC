package com.example.movie.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.movie.R;
import com.example.movie.adapter.ViewpagerAdapter;
import com.example.movie.api.ApiClient;
import com.example.movie.entity.MovieListDto;
import com.example.movie.entity.MovieResultsDto;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;

    private ViewpagerAdapter mViewpagerAdapter;

    private final String[] mTitleList = new String[]{"Home", "Favourite", "Setting", "About"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        mViewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(mViewpagerAdapter);
        mViewPager.setOffscreenPageLimit(3);

        ApiClient.getClient().getListMovie().enqueue(new Callback<MovieResultsDto>() {
            @Override
            public void onResponse(Call<MovieResultsDto> call, Response<MovieResultsDto> response) {
                Log.d("Linhchay", response.body().getResultsDtoList().get(0).getOverview());
            }

            @Override
            public void onFailure(Call<MovieResultsDto> call, Throwable t) {

            }
        });

        setSupportActionBar(mToolbar);

        new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            tab.setText(mTitleList[position]);
        }).attach();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar_movie);
        mViewPager = findViewById(R.id.viewpager_movie);
        mTabLayout = findViewById(R.id.tablayout_movie);
    }
}