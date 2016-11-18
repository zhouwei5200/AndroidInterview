package com.guowei.android.presenter.fragmentpresenter;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.guowei.android.base.BaseRecyclerViewAdapter;
import com.guowei.android.model.AlgorithmBean;
import com.guowei.android.model.AndroidBean;
import com.guowei.android.model.bmob.BmobRecommend;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.adapter.AndroidAdapter;
import com.guowei.android.presenter.adapter.ArithmeticAdapter;
import com.guowei.android.view.activity.WebActivity;
import com.guowei.android.view.fragment.AndroidFragment;
import com.guowei.android.view.fragment.ArithmeticFragment;
import com.guowei.android.widght.reflesh.FunGameRefreshView;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/21.
 */
public class ArithmeticPresenter extends Presenter<ArithmeticFragment> implements BaseRecyclerViewAdapter.OnItemClickListener<AlgorithmBean> {

    private ArithmeticAdapter arithmeticAdapter;


    @Override
    public void onCreateView(ArithmeticFragment view) {
        super.onCreateView(view);
        arithmeticAdapter =   new ArithmeticAdapter();
        arithmeticAdapter.setOnItemClickListener(this);
        getView().recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getView().recyclerView.setAdapter(arithmeticAdapter);
        getView().funGameRefreshView.setOnRefreshListener(new FunGameRefreshView.FunGameRefreshListener() {
            @Override
            public void onRefreshing() {
               refleshAlgorithmData();
            }
        });
        getView().loadingrelativeLayout.setVisibility(View.VISIBLE);
        refleshAlgorithmData();

    }

    private void refleshAlgorithmData() {
        BmobRecommend.getArithmeticRecommendData(new Subscriber<ArrayList<AlgorithmBean>>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
            }
            @Override
            public void onNext(ArrayList<AlgorithmBean> androidBeen) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
                if(androidBeen != null) {
                    arithmeticAdapter.removeAll();
                    arithmeticAdapter.addAll(androidBeen);
                }
            }
        });

    }

    @Override
    public void onItemClick(View view, int position, AlgorithmBean info) {
        Intent intent = new Intent(getView().getActivity(), WebActivity.class);
        getView().getActivity().startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position, AlgorithmBean info) {

    }
}
