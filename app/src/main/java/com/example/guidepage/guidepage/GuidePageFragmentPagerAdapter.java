package com.example.guidepage.guidepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/12/14.
 */
public class GuidePageFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] arrayFragment;

    public GuidePageFragmentPagerAdapter(FragmentManager fragmentManager, Fragment[] arrayFragment) {
        super(fragmentManager);
        this.arrayFragment = arrayFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragment[position];
    }

    @Override
    public int getCount() {
        return arrayFragment.length;
    }
}
