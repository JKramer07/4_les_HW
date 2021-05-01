package com.geek.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initBottomNavigationView();
    }


    public void initBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager mn =getSupportFragmentManager();
                switch (item.getItemId()){
                    case R.id.navigation_first:
                        viewPager.setCurrentItem(0);
//                        mn.beginTransaction().replace(R.id.container_main, FirstFragment.newInstance("val 1", "val 2")).commit();
                        break;
                    case R.id.navigation_second:
                        viewPager.setCurrentItem(1);
//                        mn.beginTransaction().replace(R.id.container_main, SecondFragment.newInstance("val 1", "val 2")).commit();
                        break;
                    case  R.id. navigation_profile:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        viewPager.setCurrentItem(0);
                }
                return true;
            }
        });
    }

    public void initViewPager(){
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_first).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_second).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}