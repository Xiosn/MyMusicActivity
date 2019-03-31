package com.myapplication.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myapplication.R;
import com.myapplication.adapters.MusicListAdapter;

public class AlbumListActivity extends BaseActivity {


    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);

        initView();
    }

    public void initView(){
        initNavBar(true,"专辑列表",false);

        mRvList=findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new MusicListAdapter(this,null);
        mRvList.setAdapter(mAdapter);
    }
}
