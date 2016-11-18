package com.guowei.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guowei.android.R;
import com.guowei.android.base.BaseAppFragment;

/**
 * Created by zhoug on 2016/8/4.
 */
public class SourceFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.testfragment2,container,false);
    }
}
