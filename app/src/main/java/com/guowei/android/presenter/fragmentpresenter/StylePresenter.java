package com.guowei.android.presenter.fragmentpresenter;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.guowei.android.base.BaseRecyclerViewAdapter;
import com.guowei.android.model.DesignBean;
import com.guowei.android.model.bmob.BmobRecommend;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.adapter.StyleAdapter;
import com.guowei.android.view.fragment.StyleFragment;
import com.guowei.android.widght.reflesh.FunGameRefreshView;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/21.
 */
public class StylePresenter extends Presenter<StyleFragment> implements BaseRecyclerViewAdapter.OnItemClickListener<DesignBean>  {

    private StyleAdapter styleAdapter;

    @Override
    public void onCreateView(StyleFragment view) {
        super.onCreateView(view);
        styleAdapter =   new StyleAdapter();
        styleAdapter.setOnItemClickListener(this);
        getView().recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getView().recyclerView.setAdapter(styleAdapter);
        getView().funGameRefreshView.setOnRefreshListener(new FunGameRefreshView.FunGameRefreshListener() {
            @Override
            public void onRefreshing() {
              refleshDesignData();
            }
        });
        getView().loadingrelativeLayout.setVisibility(View.VISIBLE);

        refleshDesignData();
    }

    private void refleshDesignData() {
        BmobRecommend.getStyleRecommendData(new Subscriber<ArrayList<DesignBean>>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
            }
            @Override
            public void onNext(ArrayList<DesignBean> androidBeen) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
                if(androidBeen != null) {
                    styleAdapter.removeAll();
                    styleAdapter.addAll(androidBeen);
                }
            }
        });
    }



    @Override
    public void onItemClick(View view, int position, DesignBean info) {

    }

    @Override
    public void onItemLongClick(View view, int position, DesignBean info) {

    }
}
