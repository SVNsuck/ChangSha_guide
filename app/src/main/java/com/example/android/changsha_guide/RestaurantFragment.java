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
        guideInfos.add(new GuideInfo(getString(R.string.rest_xhl_openTime),getString(R.string.res_xhl_phoneNum),getString(R.string.rest_xhl_name),getString(R.string.rest_xhl_addr)));
        guideInfos.add(new GuideInfo(getString(R.string.rest_llx_openTime),getString(R.string.rest_llx_phoneNum),getString(R.string.rest_llx_name),getString(R.string.rest_llx_addr)));
        guideInfos.add(new GuideInfo(getString(R.string.rest_qhsf_openTime),getString(R.string.rest_qhsf_phoneNum),getString(R.string.rest_qhsf_name),getString(R.string.rest_qhsf_addr)));
        guideInfos.add(new GuideInfo(getString(R.string.rest_ydl_openTime),getString(R.string.rest_ydl_phoneNum),getString(R.string.rest_ydl_name),getString(R.string.rest_yld_addr)));
        guideInfos.add(new GuideInfo(getString(R.string.rest_xjhx_openTime),getString(R.string.rest_xjhx_phoneNum),getString(R.string.rest_xjhx_name),getString(R.string.rest_xjhx_addr)));
        guideInfos.add(new GuideInfo(getString(R.string.rest_whdt_openTime),getString(R.string.rest_whdt_phoneNum),getString(R.string.rest_whdt_name),getString(R.string.rest_whdt_addr)));

        //初始化GuideAdapter
        GuideInfoAdapter guideInfoAdapter = new GuideInfoAdapter(getActivity(),guideInfos,R.color.category_restaurant,1);

        //初始化ListView
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(guideInfoAdapter);


        return rootView;
    }

}
