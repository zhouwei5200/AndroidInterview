package com.guowei.android.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.guowei.android.beam.ViewControlViewHelper;
import com.guowei.android.presenter.Presenter;

/**
 * Created by zhoug on 2016/8/1.
 */
public class BaseAppFragment<PresenterType extends Presenter> extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper.obtainPresenter(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper.onPostCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        helper.onDestroyView();
        if (getActivity().isFinishing())
            helper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSave(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        helper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        helper.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        helper.onResult(requestCode, resultCode,data);
    }


    public PresenterType getPresenter() {
        return helper.getPresenter();
    }

    private ViewControlViewHelper<PresenterType> helper = new ViewControlViewHelper<>(this);
}
