package com.guowei.android.view.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.guowei.android.R;

/**
 * Created by zhoug on 2016/8/8.
 */
public class WebActivity extends Activity {

    private RelativeLayout relativeLayout;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weblayout);
        //设置WebView属性，能够执行Javascript脚本
        webView = (WebView) findViewById(R.id.wv_item);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_loading);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        //加载需要显示的网页
        webView.loadUrl("http://blog.csdn.net/zhou12314/article/details/51003995");
        //设置Web视图
        webView.setWebViewClient(new HelloWebViewClient());
     // webView.setWebViewClient();
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
        }
    }
}
