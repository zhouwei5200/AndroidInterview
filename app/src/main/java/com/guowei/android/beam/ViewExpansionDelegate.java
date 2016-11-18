package com.guowei.android.beam;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import com.guowei.android.base.MyBaseAppActivity;

/**
 * Created by zhoug on 2016/8/2.
 */
public class ViewExpansionDelegate {
    private MyBaseAppActivity activity;
    private FrameLayout container;
    public ViewExpansionDelegate(MyBaseAppActivity activity) {
        this.activity = activity;
        this.container = activity.getParentView();
    }
    public final MyBaseAppActivity getActivity() {
        return activity;
    }
    public final FrameLayout getContainer() {
        return container;
    }
    public void showProgressDialog(String title){}
    public void dismissProgressDialog(){}
    public View showProgressPage(){return  null;}
    public void dismissProgressPage(){}
    public View showErrorPage(){return  null;}
    public void dismissErrorPage(){}
    public void setErrorRetryListener(OnRetryListener listener){}
    public interface OnRetryListener{
        void onRetry();
    }
    public void addCustomOverlayView(View view){}
    public void removeCustomOverlayView(View view){}



}
