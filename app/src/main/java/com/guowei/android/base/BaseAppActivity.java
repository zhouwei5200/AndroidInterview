package com.guowei.android.base;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.guowei.android.beam.ActivityLifeDelegate;
import com.guowei.android.beam.ViewControlViewHelper;
import com.guowei.android.beam.Beam;
import com.guowei.android.presenter.Presenter;
/**
 *  作者：zhouguowei
 *  电话：17090417151
 *  邮箱：17090417151@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：
 **/
public abstract  class BaseAppActivity<PresenterType extends Presenter> extends AppCompatActivity {
    ActivityLifeDelegate mActivityLifeDelegate;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preCreateOPresenter();
        if(mActivityLifeDelegate!= null){
            mActivityLifeDelegate.onCreate(savedInstanceState);
        }
        helper.onCreate(savedInstanceState);
    }
    public void preCreateOPresenter() {
        if(Beam.createActivityLifeDelegate(this)!= null){
            mActivityLifeDelegate = Beam.createActivityLifeDelegate(this);
        }
    }
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onPostCreate(savedInstanceState);
        helper.onPostCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onDestroy();
        helper.onDestroyView();
        if (isFinishing())
            helper.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onSaveInstanceState(outState);
        helper.onSave(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onResume();
        helper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onPause();
        helper.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onActivityResult(requestCode, resultCode, data);
        helper.onResult(requestCode, resultCode,data);
    }


    public PresenterType getPresenter() {
        return helper.getPresenter();
    }

    private ViewControlViewHelper<PresenterType> helper = new ViewControlViewHelper<>(this);


    @Override
    public void onContentChanged() {
        super.onContentChanged();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onContentChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onRestart();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onUserLeaveHint();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onNewIntent(intent);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onTrimMemory(level);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onAttachFragment(fragment);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onResumeFragments();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onPostResume();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mActivityLifeDelegate!=null)mActivityLifeDelegate.onConfigurationChanged(newConfig);
    }

}
