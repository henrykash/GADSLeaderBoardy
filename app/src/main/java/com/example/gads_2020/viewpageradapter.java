package com.example.gads_2020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewpageradapter extends FragmentPagerAdapter {
    public viewpageradapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public viewpageradapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new learning_leaders();
            case 1:
                return new SkillIQ();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Learning Leaders";
            case 1:
                return "Skill IQ Leaders";
        } return super.getPageTitle(position);
    }
}

