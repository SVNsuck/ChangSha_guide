package com.example.android.changsha_guide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        final List<GuideInfo> guideInfos = new ArrayList<>();
        guideInfos.add(new GuideInfo("9:00-21:00","(0731)84258180","西湖楼酒家","长沙市开福区马栏山西湖楼酒家(省广电中心斜对面)"));
        guideInfos.add(new GuideInfo("17:00-3:00","(0731)84258186","老长沙龙虾馆","湘江中路2段72号"));
        guideInfos.add(new GuideInfo("11:00-21:00","4007508999","秦皇食府(市政府店)","岳麓大道158号"));
        guideInfos.add(new GuideInfo("11:00-2:00","(0731)82777988","玉楼东(五一路店)","五一大道125号铁建精品酒店东隔壁"));
        guideInfos.add(new GuideInfo("11:30-23:00","(0731)84467299","徐记海鲜(湘江店)","开福区湘江中路二段208号欧陆经典1楼"));
        guideInfos.add(new GuideInfo("11:30-21:00","(0731)85120688","伍厚德堂","长沙市天心区坡子街148号"));

        //初始化GuideAdapter
        GuideInfoAdapter guideInfoAdapter = new GuideInfoAdapter(getActivity(),guideInfos,R.color.category_restaurant,1);

        //初始化ListView
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(guideInfoAdapter);


        return rootView;
    }

}
