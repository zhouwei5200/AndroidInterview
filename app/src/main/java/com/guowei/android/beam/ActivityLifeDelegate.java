package com.guowei.android.beam;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by zhoug on 2016/7/29.
 */
public class ActivityLifeDelegate {
    private Activity act;

    public ActivityLifeDelegate(Activity act) {
        this.act = act;
    }

    public Activity getActivity() {
        return act;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    public void onPostCreate(Bundle savedInstanceState) {
    }

    public void onStart() {
    }

    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onPostResume() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    }

    public void onPause() {
    }

    public void onUserLeaveHint() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int level) {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onBackPressed() {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onContentChanged() {

    }

    public void onResumeFragments() {

    }

}
