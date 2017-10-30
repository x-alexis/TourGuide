package com.trottdevelopment.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Albert on 06.10.2017.
 * Defines titles, assignes fragments to viewPager
 */

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    public CategoryPagerAdapter (Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentFragment();
        } else if (position == 1){
            return new TheaterFragment();
        } else if (position == 2){
            return new ParklandFragment();
        } else {
            return new MuseumFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_monuments);
        } else if (position == 1) {
            return mContext.getString(R.string.category_theaters);
        } else if (position == 2) {
            return mContext.getString(R.string.category_parklands);
        } else {
            return mContext.getString(R.string.category_museums);
        }
    }
}
