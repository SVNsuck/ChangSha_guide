package com.example.android.changsha_guide;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by PWT on 2017/6/5.
 */

public class ViewHolder {

    //获得文字展示区的LinearLayout
    public RelativeLayout mainContainer;

    //获得每一行的LinearLayout
    public View telLayout;
    public View openTimeLayout;
    //获得每行的斜体字
    public TextView nameView;
    public TextView addrView;
    public TextView telView;
    public TextView openTimeView;
    public ImageView imageView;

    //获得每行的斜体字
    public TextView nameViewText;
    public TextView addrViewText;
    public TextView telViewText;
    public TextView openTimeViewText;

    public View textContainer;
}
