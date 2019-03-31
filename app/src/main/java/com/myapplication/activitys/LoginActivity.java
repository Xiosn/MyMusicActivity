package com.myapplication.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.myapplication.R;
import com.myapplication.utils.UserUtils;
import com.myapplication.views.InputView;

//NavigationBar 顶部导航
public class LoginActivity extends BaseActivity {


    private InputView mInputPhone,mInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);

        initView();
    }


    /**
     *初始化View
     */
    private void initView(){
        initNavBar(false,"登录",false);

        mInputPhone=findViewById(R.id.input_phone);
        mInputPassword=findViewById(R.id.input_password);
    }


    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick(View v){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录
     */
    public void onCommitClick(View v){

        String phone=mInputPhone.getInputStr();
        String password=mInputPassword.getInputStr();

        //验证用户输入是否合法
//        if (!UserUtils.validateLogin(this,phone,password)){
//            return;
//        }

        //跳转到应用主页
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
