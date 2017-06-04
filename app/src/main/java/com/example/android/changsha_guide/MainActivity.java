package com.example.android.changsha_guide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置activity的内容为activity_main.xml
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        GuideInfoFragmentPagerAdapter guideInfoFragmentPagerAdapter =
                new GuideInfoFragmentPagerAdapter(getSupportFragmentManager(),MainActivity.this);

        viewPager.setAdapter(guideInfoFragmentPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
