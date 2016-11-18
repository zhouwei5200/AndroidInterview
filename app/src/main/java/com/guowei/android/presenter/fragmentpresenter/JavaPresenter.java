package com.guowei.android.presenter.fragmentpresenter;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.guowei.android.base.BaseRecyclerViewAdapter;
import com.guowei.android.model.AlgorithmBean;
import com.guowei.android.model.AndroidBean;
import com.guowei.android.model.DesignBean;
import com.guowei.android.model.JavaBean;
import com.guowei.android.model.bmob.BmobRecommend;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.adapter.AndroidAdapter;
import com.guowei.android.presenter.adapter.JavaAdapter;
import com.guowei.android.view.fragment.AndroidFragment;
import com.guowei.android.view.fragment.JavaFragment;
import com.guowei.android.widght.reflesh.FunGameRefreshView;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/21.
 */
public class JavaPresenter  extends Presenter<JavaFragment> implements BaseRecyclerViewAdapter.OnItemClickListener<JavaBean>  {

    private JavaAdapter javaAdapter;

    @Override
    public void onCreateView(JavaFragment view) {
        super.onCreateView(view);
        javaAdapter =   new JavaAdapter();
        javaAdapter.setOnItemClickListener(this);
        getView().recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getView().recyclerView.setAdapter(javaAdapter);
        getView().funGameRefreshView.setOnRefreshListener(new FunGameRefreshView.FunGameRefreshListener() {
            @Override
            public void onRefreshing() {
                refleshJavaData();
            }
        });
        getView().loadingrelativeLayout.setVisibility(View.VISIBLE);
        refleshJavaData();

    }

 /*   private void refleshData() {
        BmobRecommend.getRecommendData(new Subscriber<ArrayList<AndroidBean>>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(ArrayList<JavaBean> javaBeen) {
                if(javaBeen != null) {
                    javaAdapter.removeAll();
                    javaAdapter.addAll(javaBeen);
                }
            }
        });
    }*/

private void refleshJavaData() {
        BmobRecommend.getJavaRecommendData(new Subscriber<ArrayList<JavaBean>>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
            }
            @Override
            public void onNext(ArrayList<JavaBean> javaBeen) {
                getView().loadingrelativeLayout.setVisibility(View.GONE);
                if(javaBeen != null) {
                    javaAdapter.removeAll();
                    javaAdapter.addAll(javaBeen);
                }
            }
        });

    }



    @Override
    public void onItemClick(View view, int position, JavaBean info) {

    }

    @Override
    public void onItemLongClick(View view, int position, JavaBean info) {

    }
}
