package com.guowei.android.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guowei.android.R;
import com.guowei.android.base.MyBaseAppActivity;
import com.guowei.android.presenter.RequiresPresenter;
import com.guowei.android.presenter.activityPresenter.CommitPresenter;
import com.guowei.android.widght.popupwindow.SlideFromBottomPopup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 作者：zhouguowei
 * 电话：17090417151
 * 邮箱：17090417151@163.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 修改时间：
 **/
@RequiresPresenter(CommitPresenter.class)
public class CommitActivity extends MyBaseAppActivity<CommitPresenter> {
    //tv_choose
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_choose)
    public TextView tv_choose;
    @Bind(R.id.et_name)
    public EditText et_name;
    @Bind(R.id.et_adress)
    public EditText et_adress;
    @Bind(R.id.et_author)
    public EditText et_author;
    @Bind(R.id.tv_commit)
    public TextView tv_commit;
    private SlideFromBottomPopup slideFromBottomPopup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit);
        ButterKnife.bind(this);
        //    toolbar = (Toolbar) findViewById(R.id.toolbar);//关键下面两句话，设置了回退按钮，及点击事件的效果
        getToolbar().inflateMenu(R.menu.menu_post);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initToolbar();
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void initToolbar() {
        toolbar.setTitle("提交你的作品");
    }
    @OnClick(R.id.rl_item1)
    public void chooseOnclick() {
        et_author.clearFocus();
        et_adress.clearFocus();
        et_name.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_author.getWindowToken(),0);
        imm.hideSoftInputFromWindow(et_adress.getWindowToken(),0);
        imm.hideSoftInputFromWindow(et_name.getWindowToken(),0);
        if (slideFromBottomPopup == null) {
            slideFromBottomPopup = new SlideFromBottomPopup(this);
        }
        slideFromBottomPopup.showPopupWindow();
    }
    @OnClick(R.id.tv_commit)
    public void commitOnclick() {

    }


}
