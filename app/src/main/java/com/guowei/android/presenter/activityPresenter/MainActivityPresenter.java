package com.guowei.android.presenter.activityPresenter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.guowei.android.R;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.adapter.MainAdapter;
import com.guowei.android.view.activity.MainActivity;

/**
 * Created by zhoug on 2016/8/3.
 */
public class MainActivityPresenter extends Presenter<MainActivity> {
    private FragmentManager fragmentManager;
    private ViewPager viewPager;
    private MainAdapter mainAdapter;
    @Override
    public void onCreateView(MainActivity view) {
        super.onCreateView(view);
        view.getTabLayout().setSelectedTabIndicatorColor(view.getResources().getColor(R.color.abc_white));
        viewPager =  view.getViewPager();
        //viewPager.setOffscreenPageLimit(3);
       fragmentManager = view.getSupportFragmentManager();
        changeFragment(0);
    }
    private void changeFragment(int i) {
        if(mainAdapter == null) {
            mainAdapter = new MainAdapter(getView(), fragmentManager);
        }
        viewPager.setAdapter(mainAdapter);
        getView().getTabLayout().setupWithViewPager(getView().getViewPager());
    }
}
