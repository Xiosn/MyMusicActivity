package com.myapplication.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.myapplication.R;

/**
 * input_icon:输入框前面的图标
 * input_hint:输入框的提示内容
 * is_password:输入内容是否以密文展示
 */
public class InputView extends FrameLayout {

    private int  inputIcon;
    private String inputHint;
    private boolean isPassword;

    private View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;

    public InputView(Context context) {
        super(context);
        init(context,null);
    }

    public InputView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public InputView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    /**
     * 初始化方法
     *
     * AttributeSet attrs  是自定义属性的存储变量
     */
    private void init(Context context,AttributeSet attrs){
        if (attrs==null){
            return;
        }
        //获取自定义属性
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.inputView);
        inputIcon=typedArray.getResourceId(R.styleable.inputView_input_icon,R.mipmap.phone);
        inputHint=typedArray.getString(R.styleable.inputView_input_hint);
        isPassword=typedArray.getBoolean(R.styleable.inputView_is_password,false);
        typedArray.recycle();//释放资源

        //绑定Layout布局
       mView = LayoutInflater.from(context).inflate(R.layout.input_view,this,false);
       mIvIcon=mView.findViewById(R.id.iv_icon);
       mEtInput=mView.findViewById(R.id.et_input);

       //布局关联属性
        mIvIcon.setImageResource(inputIcon);
        mEtInput.setHint(inputHint);
        mEtInput.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD:InputType.TYPE_CLASS_PHONE);
       addView(mView);
    }


    /**
     * 返回输入的内容
     * @return
     */
    public String getInputStr(){
        return mEtInput.getText().toString().trim();
    }
}
