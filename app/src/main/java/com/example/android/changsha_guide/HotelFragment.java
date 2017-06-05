package com.example.android.changsha_guide;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public static final String 长沙市开福区芙蓉中路一段_191_号 = "长沙市开福区芙蓉中路一段191号";
    public static final String 好来登酒店 = "好来登酒店";
    public static final String 长沙远大一路_88_号 = "长沙远大一路88号";
    public static final String 紫东阁华天大酒店 = "紫东阁华天大酒店";
    public static final String 开福区福城路_98_号 = "开福区福城路98号";
    public static final String 顺天黄金海岸大酒店 = "顺天黄金海岸大酒店";
    public static final String 岳麓区岳华路_268_号 = "岳麓区岳华路268号";
    public static final String 美雅斯国际酒店 = "美雅斯国际酒店";
    public static final String 长沙市芙蓉中路_2_段_279_号 = "长沙市芙蓉中路2段279号";
    public static final String 金源阳光酒店 = "金源阳光酒店";
    public static final String 长沙市雨花区万家丽中路二段_81_号 = "长沙市雨花区万家丽中路二段81号";
    public static final String 长沙华雅国际大酒店 = "长沙华雅国际大酒店";

    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        final List<GuideInfo> guideInfos = new ArrayList<>();
        guideInfos.add(new GuideInfo(getString(R.string.aaa), 长沙华雅国际大酒店, 长沙市雨花区万家丽中路二段_81_号));
        guideInfos.add(new GuideInfo("(0731)85558888", 金源阳光酒店, 长沙市芙蓉中路_2_段_279_号));
        guideInfos.add(new GuideInfo("(0731)81808888", 美雅斯国际酒店, 岳麓区岳华路_268_号));
        guideInfos.add(new GuideInfo("(0731)82883333", 顺天黄金海岸大酒店, 开福区福城路_98_号));
        guideInfos.add(new GuideInfo("13786177536", 紫东阁华天大酒店, 长沙远大一路_88_号));
        guideInfos.add(new GuideInfo("(0731)82166666", 好来登酒店, 长沙市开福区芙蓉中路一段_191_号));

        //初始化GuideAdapter
        GuideInfoAdapter guideInfoAdapter = new GuideInfoAdapter(getActivity(),guideInfos,R.color.category_hotel,2);

        //初始化ListView
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(guideInfoAdapter);


        return rootView;
    }

}
