package com.myapplication.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.myapplication.R;
import com.myapplication.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);

        initView();
    }

    private void initView(){
        initNavBar(true,"个人中心",false);
    }



    /**
     * 修改密码点击事件
     */
    public void onChangeClick(View v){
        startActivity(new Intent(MeActivity.this,ChangePasswordActivity.class));
    }


    /**
     * 退出登录
     */
    public void onLogoutClick(View v){
        UserUtils.logout(this);
    }
}
