package com.guowei.android.widght.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.guowei.android.widght.LoadingDrawable;
import com.guowei.android.widght.loadingview.LoadingRenderer;
import com.guowei.android.widght.loadingview.SwapLoadingRenderer;

/**
 * Created by zhoug on 2016/8/27.
 */
public class LoadingView extends ImageView {

    private LoadingDrawable loadingDrawable;

    public LoadingView(Context context) {
        super(context);
    }
    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initAttrs(Context context, AttributeSet attrs) {
        LoadingRenderer loadingRenderer = new SwapLoadingRenderer(context);
        loadingDrawable = new LoadingDrawable(loadingRenderer);
        setImageDrawable(loadingDrawable);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }
    private void startAnimation() {
        if (loadingDrawable != null) {
            loadingDrawable.start();
        }
    }

    private void stopAnimation() {
        if (loadingDrawable != null) {
            loadingDrawable.stop();
        }
    }
}
