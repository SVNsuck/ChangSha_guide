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
public class AttractionsFragment extends Fragment {


    public static final String 长沙市宁乡县 = "长沙市宁乡县";
    public static final String 沩山风景名胜区 = "沩山风景名胜区";
    public static final String 长沙宁乡县金洲镇关山旅游社区 = "长沙宁乡县金洲镇关山旅游社区";
    public static final String 关山古镇 = "关山古镇";
    public static final String 长沙市雨花区植物园路_111_号 = "长沙市雨花区植物园路111号";
    public static final String 湖南省森林植物园 = "湖南省森林植物园";
    public static final String 长沙市浏阳市大围山国家森林公园东南_950_米 = "长沙市浏阳市大围山国家森林公园东南950米";
    public static final String 大围山国家森林公园 = "大围山国家森林公园";
    public static final String 长沙市三一大道_485_号 = "长沙市三一大道485号";
    public static final String 世界之窗 = "世界之窗";
    public static final String 全天开放 = "全天开放";
    public static final String 登高路_58_号 = "登高路58号";
    public static final String 岳麓山风景名胜区 = "岳麓山风景名胜区";

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        final List<GuideInfo> guideInfos = new ArrayList<>();
        guideInfos.add(new GuideInfo(R.drawable.ylfengjingqu_icon, 岳麓山风景名胜区, 登高路_58_号, 全天开放));
        guideInfos.add(new GuideInfo(R.drawable.shijiezc_icon, 世界之窗, 长沙市三一大道_485_号," 09:00-22:30"));
        guideInfos.add(new GuideInfo(R.drawable.dws_icon, 大围山国家森林公园, 长沙市浏阳市大围山国家森林公园东南_950_米,"00:00-24:00"));
        guideInfos.add(new GuideInfo(R.drawable.zwy_icon, 湖南省森林植物园, 长沙市雨花区植物园路_111_号,"07:00-18:00"));
        guideInfos.add(new GuideInfo(R.drawable.gsgz_icon, 关山古镇, 长沙宁乡县金洲镇关山旅游社区,"09:30-17:30"));
        guideInfos.add(new GuideInfo(R.drawable.ws_icon, 沩山风景名胜区, 长沙市宁乡县,"08:00-17:00"));

        //初始化GuideAdapter
        GuideInfoAdapter guideInfoAdapter = new GuideInfoAdapter(getActivity(),
                guideInfos,R.color.category_attractions,3);

        //初始化ListView
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(guideInfoAdapter);


        return rootView;
    }

}
