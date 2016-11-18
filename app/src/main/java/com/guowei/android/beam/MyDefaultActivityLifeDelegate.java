package com.guowei.android.beam;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by zhoug on 2016/7/30.
 */
public class MyDefaultActivityLifeDelegate extends  ActivityLifeDelegate {
    public MyDefaultActivityLifeDelegate(Activity act) {
        super(act);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
