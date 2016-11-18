package com.guowei.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.guowei.android.R;
import com.guowei.android.base.BaseAppFragment;
import com.guowei.android.presenter.RequiresPresenter;
import com.guowei.android.presenter.fragmentpresenter.AndroidPresenter;
import com.guowei.android.presenter.fragmentpresenter.StylePresenter;
import com.guowei.android.widght.reflesh.FunGameRefreshView;

/**
 * Created by zhoug on 2016/8/4.
 */

/**
 * Created by zhoug on 2016/8/4.
 */
@RequiresPresenter(StylePresenter.class)
public class StyleFragment extends BaseAppFragment<StylePresenter> {

    public RecyclerView recyclerView;
    public FunGameRefreshView funGameRefreshView;
    public RelativeLayout loadingrelativeLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_android_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerView);
        funGameRefreshView = (FunGameRefreshView) view.findViewById(R.id.refresh_fun_game);
        loadingrelativeLayout = (RelativeLayout) view.findViewById(R.id.rl_loading);
        return view;
    }
}
