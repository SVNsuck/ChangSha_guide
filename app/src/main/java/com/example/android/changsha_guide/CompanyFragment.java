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
public class CompanyFragment extends Fragment {


    public static final String 湖南省长沙市经济技术开发区开元路_172_号 = "湖南省长沙市经济技术开发区开元路172号";
    public static final String 长沙开元仪器有限公司 = "长沙开元仪器有限公司";
    public static final String 麓谷大道_599_号附近 = "麓谷大道599号附近";
    public static final String 申大科技 = "申大科技";
    public static final String 中意三路_8_号 = "中意三路8号";
    public static final String 长沙正大有限公司 = "长沙正大有限公司";
    public static final String 湖南省长沙市芙蓉区晚报大道_267_号 = "湖南省长沙市芙蓉区晚报大道267号";
    public static final String 长沙晚报 = "长沙晚报";
    public static final String 湖南省长沙市浏阳市浏阳工业园康宁路 = "湖南省长沙市浏阳市浏阳工业园康宁路";
    public static final String 蓝思科技股份有限公司 = "蓝思科技股份有限公司";
    public static final String 青山路_100_号 = "青山路100号";
    public static final String 湖南科创信息技术有限公司 = "湖南科创信息技术有限公司";

    public CompanyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        final List<GuideInfo> guideInfos = new ArrayList<>();
        guideInfos.add(new GuideInfo(湖南科创信息技术有限公司, 青山路_100_号,"(0731)83630259"));
        guideInfos.add(new GuideInfo(蓝思科技股份有限公司, 湖南省长沙市浏阳市浏阳工业园康宁路,"0731-83859999"));
        guideInfos.add(new GuideInfo(长沙晚报, 湖南省长沙市芙蓉区晚报大道_267_号,"(0731)82205017"));
        guideInfos.add(new GuideInfo(长沙正大有限公司, 中意三路_8_号,"(0731)86902211"));
        guideInfos.add(new GuideInfo(申大科技, 麓谷大道_599_号附近,"(0731)83630895"));
        guideInfos.add(new GuideInfo(长沙开元仪器有限公司, 湖南省长沙市经济技术开发区开元路_172_号,"(0731)84013443"));

        //初始化GuideAdapter
        GuideInfoAdapter guideInfoAdapter = new GuideInfoAdapter(getActivity(),guideInfos,R.color.category_restaurant,4);

        //初始化ListView
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(guideInfoAdapter);


        return rootView;
    }

}
