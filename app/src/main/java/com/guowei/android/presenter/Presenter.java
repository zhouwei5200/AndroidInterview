package com.guowei.android.presenter;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zhoug on 2016/7/28.
 */
public class Presenter<ViewType> {
    /**
     *   avtivity  第一次create直到主动退出Activity之前都不会调用
     */
    public   void  onCreate(ViewType view,Bundle savedState){

    }
    /**
     * presenter销毁时的回调。代表着activity正式退出
     */
    public void onDestroy() {
    }
    /**
     * activity$OnCreate的回调,但执行延迟到OnCreate之后。
     */
    public void onCreateView(ViewType view) {
        this.view = view;
    }
    /**
     * activity$OnDestory的回调
     */
    public void onDestroyView() {
    }
    public void onResume() {
    }
    public void onPause() {
    }
    public void onSave(Bundle state) {
    }
    public void onResult(int requestCode, int resultCode, Intent data) {
    }
    public  String id;
    ViewType view;
    public final ViewType getView() {
        return view;
    }

    void create(ViewType view,Bundle savedState){
        this.view = view;
        onCreate(view,savedState);
    }
}
