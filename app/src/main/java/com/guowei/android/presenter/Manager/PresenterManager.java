package com.guowei.android.presenter.Manager;

import com.guowei.android.presenter.Presenter;

/**
 * Created by zhoug on 2016/8/1.
 */
public abstract  class PresenterManager {

    private  static PresenterManager DefultPresenterManager  = new MyDefaultManager();
    public static PresenterManager getInstance(){
        return  DefultPresenterManager;
    }
    public  abstract  <T extends Presenter> T createPresenter(Object view);
    public  abstract  <T extends  Presenter> T getPresenter(String id);
    public  abstract  void destory(String id);

}
