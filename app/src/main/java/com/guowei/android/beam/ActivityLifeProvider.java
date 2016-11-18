package com.guowei.android.beam;

import android.app.Activity;

/**
 * Created by zhoug on 2016/7/29.
 */
public interface ActivityLifeProvider {
    ActivityLifeDelegate createActivityLife(Activity activity);
}
