package com.guowei.android.beam;

import android.app.Activity;

import com.guowei.android.base.MyBaseAppActivity;

/**
 * Created by zhoug on 2016/7/29.
 */
public final class Beam {
    private static ActivityLifeProvider mActivityLIfeProvider;
    private static ViewExpansionDelegateProvider mViewExpansionDelegateProvider;
    public  static ActivityLifeDelegate createActivityLifeDelegate(Activity activity){
        if(mActivityLIfeProvider != null){
            return  mActivityLIfeProvider.createActivityLife(activity);
        }
        return  null;
    }
    public  static void  setmActivityLIfeProvider(ActivityLifeProvider activityLIfeProvider){
        mActivityLIfeProvider = activityLIfeProvider;
    }
    public  static  ViewExpansionDelegate createViewExpansionDelggate(MyBaseAppActivity activity){
      if(mViewExpansionDelegateProvider == null){
          return  mViewExpansionDelegateProvider.DEFAULT.createViewExpansionDelegate(activity);
      }else {
          return  mViewExpansionDelegateProvider.createViewExpansionDelegate(activity);
      }
    }
    public static void setViewExpansionDelegateProvider(ViewExpansionDelegateProvider viewExpansionDelegateProvider) {
        mViewExpansionDelegateProvider = viewExpansionDelegateProvider;
    }


}
