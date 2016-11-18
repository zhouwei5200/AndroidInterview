package com.guowei.android.app;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.guowei.android.beam.ActivityLifeDelegate;
import com.guowei.android.beam.ActivityLifeProvider;
import com.guowei.android.beam.MyDefaultActivityLifeDelegate;
import com.guowei.android.beam.Beam;
import com.guowei.android.config.ShareConfig;

import cn.bmob.v3.Bmob;

/**
 * Created by zhoug on 2016/7/19.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,ShareConfig.bmobID);
        Fresco.initialize(this);
        Beam.setmActivityLIfeProvider(new ActivityLifeProvider() {
            @Override
            public ActivityLifeDelegate createActivityLife(Activity activity) {
                return new MyDefaultActivityLifeDelegate(activity);
            }
        });


    }
}
