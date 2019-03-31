package com.myapplication.activitys;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myapplication.R;
import com.myapplication.adapters.MusicGridAdapter;
import com.myapplication.adapters.MusicListAdapter;
import com.myapplication.views.GridSpaceitemDecoration;

public class MainActivity extends BaseActivity {

    //项目 Project
    //模块 module
    //状态栏 statusBar

    private RecyclerView mRvGrid,mRvlist;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置手机应用内部状态栏字体图标为黑色
        changeStatusBarTextImgColor(true);


        initView();
    }

    private void initView(){
        initNavBar(false,"音乐屋",true);

        //推荐歌单RecyclerView
        mRvGrid=findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this,3));
        //定义分割线
        mRvGrid.addItemDecoration(new GridSpaceitemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize),mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        mGridAdapter=new MusicGridAdapter(this);
        mRvGrid.setAdapter(mGridAdapter);

        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
         */
        //最热歌曲RecyclerView
        mRvlist=findViewById(R.id.rv_list);
        mRvlist.setLayoutManager(new LinearLayoutManager(this));
        //mRvlist.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRvlist.setNestedScrollingEnabled(false);
        mListAdapter=new MusicListAdapter(this,mRvlist);
        mRvlist.setAdapter(mListAdapter);
    }

}
