package com.ihewro.focus.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.ALog;
import com.ihewro.focus.bean.FeedItem;
import com.ihewro.focus.fragemnt.PostDetailFragment;
import com.ihewro.focus.view.PostDetailView;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : hewro
 *     e-mail : ihewro@163.com
 *     time   : 2019/08/25
 *     desc   : 文章viewpager
 *     version: 1.0
 * </pre>
 */
public class PostDetailListPagerAdapter extends FragmentStatePagerAdapter {


    private PostDetailFragment mCurrentFragment;

    private List<Fragment> list = new ArrayList<>();
    private List<FeedItem> data = new ArrayList<>();
    private Activity activity;
    private int count;

    public PostDetailListPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }



    @Override
    public int getCount() {
        return count;
    }


    public void setData(@Nullable List<FeedItem> data){
        list.clear();
        this.data.addAll(data);
        count = this.data.size();
    }

    @Override
    public Fragment getItem(int i) {
        return PostDetailFragment.newInstance(data.get(i));
//        return list.get(i);
    }


    public void notifyItemChanged(int i){
        //刷新fragment的布局
        if (mCurrentFragment!=null){
            mCurrentFragment.refreshUI();
        }
    }

    public View getViewByPosition(int i,int id){
        if (mCurrentFragment!=null){
            return mCurrentFragment.findViewById(id);
        }else {
            return null;
        }
    }


    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentFragment = (PostDetailFragment) object;
    }


    public PostDetailFragment getCurrentFragment() {
        return mCurrentFragment;
    }

}
