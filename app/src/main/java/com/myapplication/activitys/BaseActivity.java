package com.myapplication.activitys;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

//所有Activity的父类
public class BaseActivity extends Activity {


    private ImageView mIvBack,mIvMe;
    private TextView mTvTitle;
    /**
     * 界面设置状态栏字体颜色
     */
    public void changeStatusBarTextImgColor(boolean isBlack) {
        if (isBlack) {
            //设置状态栏黑色字体
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            //恢复状态栏白色字体
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

//    protected <T extends View> T fd(@IdRes int id){
//        return findViewById(id);
//    }
    /**
     * 初始化NavigationBar(顶部导航)
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack,String title,Boolean isShowMe){

        mIvBack=findViewById(R.id.iv_back);
        mTvTitle=findViewById(R.id.tv_title);
        mIvMe=findViewById(R.id.iv_me);
        mIvBack.setVisibility(isShowBack ? View.VISIBLE:View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE:View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();//后退操作
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaseActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
    }
}
