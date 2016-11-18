package com.guowei.android.beam;

import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.guowei.android.R;
import com.guowei.android.base.MyBaseAppActivity;

/**
 *  作者：zhouguowei
 *  电话：17090417151
 *  邮箱：17090417151@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：
 **/
public class MyDefaultViewExpansionDelegate extends  ViewExpansionDelegate {
    private ViewConfig mConfig;
    private ProgressDialog mProgressDialog;
    private OnRetryListener mRetryListener;
    private View mProgressView;
    private View mErrorView;
    public MyDefaultViewExpansionDelegate(MyBaseAppActivity activity) {
        super(activity);
        mConfig = getConfig();
    }


    public MyDefaultViewExpansionDelegate(MyBaseAppActivity activity, ViewConfig mConfig) {
        super(activity);
        this.mConfig = mConfig;
    }

    public ViewConfig getConfig(){
        return ViewConfig.Default.clone();
    }

    @Override
    public void showProgressDialog(String title) {
        if(mProgressDialog!=null&&mProgressDialog.isShowing())mProgressDialog.dismiss();
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(mConfig.mProgressTitle);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog!=null)
            mProgressDialog.dismiss();
    }

    @Override
    public View showProgressPage() {
        if (mProgressView ==null){
            if (mConfig.mProgressView!=null) mProgressView = mConfig.mProgressView;
            else mProgressView = getActivity().getLayoutInflater().inflate(mConfig.mProgressRes,getContainer(),false);
        }
        if (mProgressView.getParent()==null)getContainer().addView(mProgressView);
        setToolbar(mProgressView);
        return mProgressView;
    }

    @Override
    public void dismissProgressPage() {
        if (mProgressView !=null){
            getContainer().removeView(mProgressView);
        }
    }

    @Override
    public View showErrorPage() {
        if (mErrorView ==null){
            if (mConfig.mErrorView!=null) mErrorView = mConfig.mErrorView;
            else mErrorView = getActivity().getLayoutInflater().inflate(mConfig.mErrorRes, getContainer(), false);
        }
        if (mErrorView.getParent()==null)getContainer().addView(mErrorView);
        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRetryListener != null) mRetryListener.onRetry();
            }
        });
        setToolbar(mErrorView);
        return mErrorView;
    }

    public void setToolbar(View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar!=null){
            getActivity().setSupportActionBar(toolbar);
            getActivity().onSetToolbar(toolbar);
        }
    }

    @Override
    public void setErrorRetryListener(OnRetryListener listener) {
        mRetryListener = listener;
    }

    @Override
    public void dismissErrorPage() {
        if (mErrorView!=null){
            getContainer().removeView(mErrorView);
        }
    }

    @Override
    public void addCustomOverlayView(View view){
        getContainer().addView(view);
    }

    @Override
    public void removeCustomOverlayView(View view){
        getContainer().removeView(view);
    }
    
    
}
