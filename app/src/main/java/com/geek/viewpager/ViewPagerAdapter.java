package com.geek.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FirstFragment.newInstance("val 1", "val 2");
            case 1:
                return SecondFragment.newInstance("val 1", "val 2");
            case 2:
                return ProfileFragment.newInstance("val 1", "val 2");
            default:
                return FirstFragment.newInstance("val 1", "val 2");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
