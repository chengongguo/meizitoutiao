package com.chengg.meizitoutiao.ui;

import com.chengg.meizitoutiao.R;
import com.chengg.meizitoutiao.entity.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class FragmentManagerActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private CommonTabLayout mCommonTabLayout;

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
        R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
        R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
        R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
        R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        initData();
        initView();
        initListener();
    }

    private void initView() {

        mCommonTabLayout = (CommonTabLayout) findViewById(R.id.flyco_tablayout);
    }

    private void initData() {
        for (int i = 0; i < mTitles.length; i++) {
            if(i==0){
                HomeFragment homeFragment = new HomeFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString(HomeFragment.CONTENT, mTitles[i]);
                homeFragment.setArguments(bundle1);
                mFragmentList.add(homeFragment);
            }else{
                TabFragment tabFragment = new TabFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString(HomeFragment.CONTENT, mTitles[i]);
                tabFragment.setArguments(bundle1);
                mFragmentList.add(tabFragment);
            }

        }
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

    }

    private void initListener() {
        mCommonTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragmentList);

    }

}
