package com.guowei.android.presenter.fragmentpresenter;
import com.guowei.android.base.BaseRecyclerViewAdapter;
import com.guowei.android.model.AlgorithmBean;
import com.guowei.android.model.AndroidBean;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.guowei.android.model.DesignBean;
import com.guowei.android.model.JavaBean;
import com.guowei.android.model.bmob.BmobRecommend;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.adapter.AndroidAdapter;
import com.guowei.android.view.activity.WebActivity;
import com.guowei.android.view.fragment.AndroidFragment;
import com.guowei.android.widght.reflesh.FunGameRefreshView;
import java.util.ArrayList;

import cn.bmob.v3.BmobObject;
import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/17.
 */
public class AndroidPresenter extends Presenter<AndroidFragment> implements BaseRecyclerViewAdapter.OnItemClickListener<AndroidBean> {

    private AndroidAdapter androidAdapter;
    @Override
    public void onCreateView(AndroidFragment view) {
        super.onCreateView(view);
        androidAdapter =   new AndroidAdapter();
        androidAdapter.setOnItemClickListener(this);
        getView().recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getView().recyclerView.setAdapter(androidAdapter);
        getView().funGameRefreshView.setOnRefreshListener(new FunGameRefreshView.FunGameRefreshListener() {
            @Override
            public void onRefreshing() {
            refleshData();
            }
        });
        getView().loadingrelativeLayout.setVisibility(View.VISIBLE);
        refleshData();

    }

    private void refleshData() {
       BmobRecommend.getRecommendData(new Subscriber<ArrayList<AndroidBean>>() {
            @Override
            public void onCompleted() {

            }
           @Override
           public void onError(Throwable e) {
               getView().loadingrelativeLayout.setVisibility(View.GONE);
            }
           @Override
           public void onNext(ArrayList<AndroidBean> androidBeen) {
               getView().loadingrelativeLayout.setVisibility(View.GONE);
               if(androidBeen != null) {
                   androidAdapter.removeAll();
                   androidAdapter.addAll(androidBeen);
               }
           }
       });
    }


    @Override
    public void onItemClick(View view, int position, AndroidBean info) {
        Intent intent = new Intent(getView().getActivity(), WebActivity.class);
        getView().getActivity().startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position, AndroidBean info) {

    }
}
