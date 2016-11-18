package com.guowei.android.base;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.guowei.android.R;
import com.guowei.android.beam.Beam;
import com.guowei.android.beam.ViewExpansionDelegate;
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
public class MyBaseAppActivity<PresenterType extends Presenter> extends  BaseAppActivity<PresenterType> {
    private Toolbar toolbar;
    private FrameLayout mContentParent;
    private FrameLayout mContent;
    @Override
    public void preCreateOPresenter() {
        super.preCreateOPresenter();
        initViewTree();
    }
    private void initViewTree() {
        mContentParent = (FrameLayout) findViewById(android.R.id.content);
        mContent = new FrameLayout(this);
        super.setContentView(mContent);
    }
    public  FrameLayout getParentView(){
        return  mContentParent;
    }

    @Override
    public void setContentView(int layoutResID) {
        this.setContentView(getLayoutInflater().inflate(layoutResID, mContent, false));
    }
    @Override
    public void setContentView(View view) {
        this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContent.addView(view, params);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar!=null)
            onSetToolbar(toolbar);
    }
    public Toolbar getToolbar(){
        return toolbar;
    }

    public void onSetToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ViewExpansionDelegate mDelegate;

    public ViewExpansionDelegate createViewExpansionDelegate() {
        return Beam.createViewExpansionDelggate(this);
    }

    public final ViewExpansionDelegate getExpansion() {
        if (mDelegate==null)mDelegate = createViewExpansionDelegate();
        return mDelegate;
    }

    protected final <E extends View> E $(View view,@IdRes int id){
        return (E)view.findViewById(id);
    }
    protected final <E extends View> E $(@IdRes int id){
        return (E)findViewById(id);
    }

}
