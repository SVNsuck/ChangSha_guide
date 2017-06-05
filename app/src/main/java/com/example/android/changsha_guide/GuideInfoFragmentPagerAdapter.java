package com.example.android.changsha_guide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by PWT on 2017/6/1.
 */

public class GuideInfoFragmentPagerAdapter extends FragmentPagerAdapter {

    public static final String 公司 = "公司";
    public static final String 景点 = "景点";
    public static final String 酒店 = "酒店";
    public static final String 餐馆 = "餐馆";
    private Context mContext;
    private Fragment[] pages = new Fragment[]{
            new RestaurantFragment(),
            new HotelFragment(),
            new AttractionsFragment(),
            new CompanyFragment()
    };
    private String[] titles = new String[]{
            餐馆, 酒店, 景点, 公司
    };

    public GuideInfoFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return pages[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return pages.length;
    }
}
