package com.example.android.changsha_guide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by PWT on 2017/6/1.
 */

public class GuideInfoFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private Context mContext;

    public GuideInfoFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantFragment();
        } else if (position == 1) {
            return new HotelFragment();
        } else if (position == 2) {
            return new AttractionsFragment();
        } else {
            return new CompanyFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_restaurant);
        } else if (position == 1) {
            return mContext.getString(R.string.category_hotel);
        } else if (position == 2) {
            return mContext.getString(R.string.category_attractions);
        } else {
            return mContext.getString(R.string.category_company);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
