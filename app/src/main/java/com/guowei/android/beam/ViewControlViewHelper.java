package com.guowei.android.beam;

import android.content.Intent;
import android.os.Bundle;

import com.guowei.android.base.BaseAppActivity;
import com.guowei.android.base.BaseAppFragment;
import com.guowei.android.presenter.Manager.PresenterManager;
import com.guowei.android.presenter.Presenter;

/**
 *  作者：zhouguowei
 *  电话：17090417151
 *  邮箱：17090417151@163.com
 *  版本号：1.0
 *  类描述： 该类的作用主要是用于view的生命周期控制presenter的生命周期
 *  备注消息：
 *  修改时间：
 **/
public class ViewControlViewHelper<PresenterType extends Presenter>{
    public static final String PRESENTER_ID = "presenter_id";
    boolean hasPresenter;
    Object view;
    PresenterType presenter;
    public PresenterType getPresenter() {
        return presenter;
    }
    public  ViewControlViewHelper(Object view){
        this.view = view;
    }
    public  void  onCreate(Bundle savedInstanceState){
        String id ;
        //根据id从内存中得到presenter  ,如果没有，通过反射得到
        if(savedInstanceState == null || (id = savedInstanceState.getString(PRESENTER_ID)) == null){
                obtainPresenter(savedInstanceState);
        }else {
            presenter = PresenterManager.getInstance().getPresenter(id);
            if(presenter == null){
                obtainPresenter(savedInstanceState);
            }
        }
    }
    public void obtainPresenter(Bundle savedInstanceState) {
        presenter = PresenterManager.getInstance().createPresenter(view);
        hasPresenter = presenter != null;
        if(hasPresenter){
            presenter.onCreate(view,savedInstanceState);
        }
    }
    public boolean ensurePresenterInstance(){
        if(presenter==null){
            if (hasPresenter){
                //能执行到这里就是见鬼了。表示View所对应的Presenter莫名其妙消失了。单独的View存在是很容易空指针的，所以直接重建最好。
                if (view instanceof BaseAppActivity){
                    ((BaseAppActivity) view).recreate();
                }else if (view instanceof BaseAppFragment){
                    ((BaseAppFragment) view).getActivity().recreate();
                }
            }
            return false;
        }else {
            return true;
        }
    }
    public  void onPostCreate(){
        if (ensurePresenterInstance())
            presenter.onCreateView(view);
    }
    public  void onDestroyView(){
        if (ensurePresenterInstance())
            presenter.onDestroyView();
    }

    public  void onDestroy(){
        if (ensurePresenterInstance()){
            PresenterManager.getInstance().destory(presenter.id);
            presenter.onDestroy();
        }
    }

    public void onSave(Bundle state) {
        if (ensurePresenterInstance()){
            state.putString(PRESENTER_ID, presenter.id);
            presenter.onSave(state);
        }
    }

    public   void onResume() {
        if (ensurePresenterInstance())
            presenter.onResume();
    }

    public  void onPause() {
        if (ensurePresenterInstance())
            presenter.onPause();
    }

  public   void onResult(int requestCode, int resultCode, Intent data) {
        if (ensurePresenterInstance())
            presenter.onResult(requestCode,resultCode,data);
    }
}
