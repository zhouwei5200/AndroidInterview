package com.guowei.android.beam;

import android.view.View;

import com.guowei.android.base.MyBaseAppActivity;

/**
 * Created by zhoug on 2016/8/2.
 */
public abstract class ViewExpansionDelegateProvider {
    public  abstract ViewExpansionDelegate createViewExpansionDelegate(MyBaseAppActivity appActivity);
    public  static  ViewExpansionDelegateProvider DEFAULT = new ViewExpansionDelegateProvider() {
        @Override
        public ViewExpansionDelegate createViewExpansionDelegate(MyBaseAppActivity appActivity) {
            return new MyDefaultViewExpansionDelegate(appActivity);
        }
    };
}
