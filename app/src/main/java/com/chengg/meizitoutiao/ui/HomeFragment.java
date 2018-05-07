package com.chengg.meizitoutiao.ui;

import com.chengg.meizitoutiao.R;
import com.chengg.meizitoutiao.entity.Channel;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChayChan
 * @date 2017/6/23  11:22
 */
public class HomeFragment extends Fragment {
    public static final String CONTENT = "content";
    private String[] mTitles;
    private List<Channel> mSelectedChannels = new ArrayList<>();
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.home_tab);
        mTitles = getResources().getStringArray(R.array.channel);
        for (String title : mTitles) {
            TabFragment tabFragment = new TabFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString(HomeFragment.CONTENT, title);
            tabFragment.setArguments(bundle1);
            mFragmentList.add(tabFragment);
        }
        mSlidingTabLayout.setViewPager(mViewPager, mTitles, getActivity(), mFragmentList);
//        initData();
//        initView();
//        initListener();
        return view;
    }

    private void initData() {
        String[] channels = getResources().getStringArray(R.array.channel);
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        for (int i = 0; i < channelCodes.length; i++) {
            String title = channels[i];
            String code = channelCodes[i];
            mSelectedChannels.add(new Channel(title, code));
        }
    }

    private void initView() {
    }

    private void initListener() {
        mSlidingTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSlidingTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
    }

}
