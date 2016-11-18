package com.guowei.android.presenter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.guowei.android.R;
import com.guowei.android.view.activity.MainActivity;
import com.guowei.android.view.fragment.AndroidFragment;
import com.guowei.android.view.fragment.ArithmeticFragment;
import com.guowei.android.view.fragment.JavaFragment;
import com.guowei.android.view.fragment.SourceFragment;
import com.guowei.android.view.fragment.StyleFragment;

import java.util.HashMap;

/**
 * Created by zhoug on 2016/8/4.
 */
public class MainAdapter extends FragmentPagerAdapter {
    private Context context;
    private HashMap<Integer, Fragment> fragmentMap = new HashMap<>();
    private String[] tabs;

    public MainAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        tabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new AndroidFragment();
                break;

            case 1:
                fragment = new JavaFragment();
                break;
            case 2:
                fragment = new StyleFragment();
                break;
            default:
                fragment = new ArithmeticFragment();
                break;

        }
        fragmentMap.put(position,fragment);

        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragmentMap.remove(position);

    }
    public Fragment getFragment(int position){
        return fragmentMap.get(position+"");
    }


}
