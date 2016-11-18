package com.guowei.android.presenter.activityPresenter;


import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.guowei.android.model.CommitBean;

import com.guowei.android.model.bmob.BmobRecommend;
import com.guowei.android.presenter.Presenter;
import com.guowei.android.view.activity.CommitActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/19.
 */
public class CommitPresenter extends Presenter<CommitActivity> {
    @Override
    public void onCreateView(CommitActivity view) {
        super.onCreateView(view);

        getView().getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (checkWhole()) {
                    if (getView().tv_choose.getText().equals("android")) {
                        saveCommitBeanData("android");

                    } else if (getView().tv_choose.getText().equals("java")) {
                        saveCommitBeanData("java");

                    } else if (getView().tv_choose.getText().equals("设计模式")) {
                       saveCommitBeanData("设计模式");
                    } else {
                       saveCommitBeanData("algorithmBean");
                    }
                }
                return true;
            }
        });



    }

    private void saveCommitBeanData(String type) {
        CommitBean commitBean = new CommitBean();
        commitBean.setArticle_url(getView().et_adress.getText().toString());
        commitBean.setArticle_name(getView().et_name.getText().toString());
        commitBean.setArticle_author(getView().et_author.getText().toString());
        commitBean.setArticle_time(getCurrentTime());
        BmobRecommend.saveCommitBeanData(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(getView(), "提交成功", Toast.LENGTH_LONG).show();
                getView().finish();

            }
        }, commitBean);
    }

    private boolean checkWhole() {
        if (getView().et_name.getText() == null) {
            Toast.makeText(getView(), "填写标题哦", Toast.LENGTH_LONG).show();
            return false;
        }
        if (getView().et_adress.getText() == null) {
            Toast.makeText(getView(), "填写地址哦", Toast.LENGTH_LONG).show();
            return false;
        }
        if (getView().et_author.getText() == null) {
            Toast.makeText(getView(), "填写作者哦", Toast.LENGTH_LONG).show();
            return false;
        }
        if (getView().tv_choose.getText() == null) {
            Toast.makeText(getView(), "一定选择类型哦", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public String getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日",
                Locale.getDefault());
        String time1 = sdf.format(currentTime);
        return time1;
    }
}
