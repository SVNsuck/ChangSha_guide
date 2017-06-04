package com.example.android.changsha_guide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by PWT on 2017/5/31.
 */

public class GuideInfoAdapter extends ArrayAdapter<GuideInfo> {

    //每个fragment的背景颜色Id
    private int mColorResourceId;

    //每个fragment中的所展示的项目类型,1-餐馆,2-酒店,3-景点,4-公司
    private int mItemTextType;

    public GuideInfoAdapter(@NonNull Activity context, List<GuideInfo> guideInfos, int colorResourceId, int itemTextType) {
        super(context, 0, guideInfos);
        this.mColorResourceId = colorResourceId;
        this.mItemTextType = itemTextType;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //查看存在的view是否被重用,没有则inflate list_item的layout
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
        }

        //得到当前位于position位置的GuideInfo对象
        GuideInfo currentGuideInfo = getItem(position);

        //获得文字展示区的LinearLayout
        RelativeLayout mainContainer = (RelativeLayout)listItemView.findViewById(R.id.main_container);

        //获得每一行的LinearLayout
        View nameLayout = listItemView.findViewById(R.id.name_layout);
        View addrLayout = listItemView.findViewById(R.id.addr_layout);
        View telLayout = listItemView.findViewById(R.id.tel_layout);
        View openTimeLayout = listItemView.findViewById(R.id.openTime_layout);
        //获得每行的斜体字
        TextView nameView = (TextView)listItemView.findViewById(R.id.item_name);
        TextView addrView = (TextView)listItemView.findViewById(R.id.item_addr);
        TextView telView = (TextView)listItemView.findViewById(R.id.item_tel);
        TextView openTimeView = (TextView)listItemView.findViewById(R.id.item_openTime);
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.img);

        //根据item类型不同设置不同的信息展示行
        switch (mItemTextType){
            case 1:{//餐馆
                imageView.setVisibility(View.GONE);
                openTimeLayout.setVisibility(View.VISIBLE);
                telLayout.setVisibility(View.VISIBLE);
                nameView.setText("餐馆名称");
                addrView.setText("地址");
                telView.setText("联系电话");
                openTimeView.setText("营业时间");
                break;
            }
            case 2:{//酒店
                imageView.setVisibility(View.GONE);
                openTimeLayout.setVisibility(View.GONE);
                telLayout.setVisibility(View.VISIBLE);
                nameView.setText("酒店名称");
                addrView.setText("地址");
                telView.setText("联系电话");
                break;
            }
            case 3:{//景点
                imageView.setVisibility(View.VISIBLE);
                openTimeLayout.setVisibility(View.VISIBLE);
                telLayout.setVisibility(View.GONE);
                imageView.setImageResource(currentGuideInfo.getmImageResuourceId());
                nameView.setText("景点名称");
                addrView.setText("地址");
                openTimeView.setText("开放时间");
                //设置container高度
                //在代码里面设置的高度height是px，如果想用dp单位设置，需要获取屏幕的密度，然后转换。
                final float scale = parent.getResources().getDisplayMetrics().density;
                int height = (int) (100 * scale + 0.5f);//100dp
                mainContainer.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,height));
                break;
            }
            case 4:{//公司
                imageView.setVisibility(View.GONE);
                openTimeLayout.setVisibility(View.GONE);
                telLayout.setVisibility(View.VISIBLE);
                nameView.setText("公司名称");
                addrView.setText("地址");
                telView.setText("联系电话");
                break;
            }
        }

        //获得每行的斜体字
        TextView nameViewText = (TextView)listItemView.findViewById(R.id.item_name_text);
        TextView addrViewText = (TextView)listItemView.findViewById(R.id.item_addr_text);
        TextView telViewText = (TextView)listItemView.findViewById(R.id.item_tel_text);
        TextView openTimeViewText = (TextView)listItemView.findViewById(R.id.item_openTime_text);

        nameViewText.setText(currentGuideInfo.getmName());
        addrViewText.setText(currentGuideInfo.getmAdress());
        telViewText.setText(currentGuideInfo.getmPhoneNumber());
        openTimeViewText.setText(currentGuideInfo.getmBusinessHour());

        //为每个页面设置主体颜色
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
