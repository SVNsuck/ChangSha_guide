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

    public static final String 联系电话 = "联系电话";
    public static final String 地址 = "地址";
    public static final String 公司名称 = "公司名称";
    public static final String 开放时间 = "开放时间";
    public static final String 景点名称 = "景点名称";
    public static final String 酒店名称 = "酒店名称";
    public static final String 营业时间 = "营业时间";
    public static final String 餐馆名称 = "餐馆名称";
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
        ViewHolder viewHolder = null;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
            viewHolder = new ViewHolder();
            //获得文字展示区的LinearLayout
            viewHolder.mainContainer = (RelativeLayout)listItemView.findViewById(R.id.main_container);

            //获得每一行的LinearLayout
            viewHolder.telLayout = listItemView.findViewById(R.id.tel_layout);
            viewHolder.openTimeLayout = listItemView.findViewById(R.id.openTime_layout);
            //获得每行的斜体字
            viewHolder.nameView = (TextView)listItemView.findViewById(R.id.item_name);
            viewHolder.addrView = (TextView)listItemView.findViewById(R.id.item_addr);
            viewHolder.telView = (TextView)listItemView.findViewById(R.id.item_tel);
            viewHolder.openTimeView = (TextView)listItemView.findViewById(R.id.item_openTime);
            viewHolder.imageView = (ImageView)listItemView.findViewById(R.id.img);
            //获得每行的斜体字
            viewHolder.nameViewText = (TextView)listItemView.findViewById(R.id.item_name_text);
            viewHolder.addrViewText = (TextView)listItemView.findViewById(R.id.item_addr_text);
            viewHolder.telViewText = (TextView)listItemView.findViewById(R.id.item_tel_text);
            viewHolder.openTimeViewText = (TextView)listItemView.findViewById(R.id.item_openTime_text);
            viewHolder.textContainer = listItemView.findViewById(R.id.text_container);
            //
            listItemView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)listItemView.getTag();
        }

        //得到当前位于position位置的GuideInfo对象
        GuideInfo currentGuideInfo = getItem(position);

        //根据item类型不同设置不同的信息展示行
        switch (mItemTextType){
            case 1:{//餐馆
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.openTimeLayout.setVisibility(View.VISIBLE);
                viewHolder.telLayout.setVisibility(View.VISIBLE);
                viewHolder.nameView.setText(餐馆名称);
                viewHolder.addrView.setText(地址);
                viewHolder.telView.setText(联系电话);
                viewHolder.openTimeView.setText(营业时间);
                break;
            }
            case 2:{//酒店
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.openTimeLayout.setVisibility(View.GONE);
                viewHolder.telLayout.setVisibility(View.VISIBLE);
                viewHolder.nameView.setText(酒店名称);
                viewHolder.addrView.setText(地址);
                viewHolder.telView.setText(联系电话);
                break;
            }
            case 3:{//景点
                viewHolder.imageView.setVisibility(View.VISIBLE);
                viewHolder.openTimeLayout.setVisibility(View.VISIBLE);
                viewHolder.telLayout.setVisibility(View.GONE);
                viewHolder.imageView.setImageResource(currentGuideInfo.getmImageResuourceId());
                viewHolder.nameView.setText(景点名称);
                viewHolder.addrView.setText(地址);
                viewHolder.openTimeView.setText(开放时间);
                //设置container高度
                //在代码里面设置的高度height是px，如果想用dp单位设置，需要获取屏幕的密度，然后转换。
                final float scale = parent.getResources().getDisplayMetrics().density;
                int height = (int) (100 * scale + 0.5f);//100dp
                viewHolder.mainContainer.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,height));
                break;
            }
            case 4:{//公司
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.openTimeLayout.setVisibility(View.GONE);
                viewHolder.telLayout.setVisibility(View.VISIBLE);
                viewHolder.nameView.setText(公司名称);
                viewHolder.addrView.setText(地址);
                viewHolder.telView.setText(联系电话);
                break;
            }
        }

        viewHolder.nameViewText.setText(currentGuideInfo.getmName());
        viewHolder.addrViewText.setText(currentGuideInfo.getmAdress());
        viewHolder.telViewText.setText(currentGuideInfo.getmPhoneNumber());
        viewHolder.openTimeViewText.setText(currentGuideInfo.getmBusinessHour());

        //为每个页面设置主体颜色

        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        viewHolder.textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
