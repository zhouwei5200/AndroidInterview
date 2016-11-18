package com.guowei.android.presenter.Manager;

import com.guowei.android.presenter.Presenter;

import java.util.HashMap;

/**
 * Created by zhoug on 2016/8/1.
 */
public class MyDefaultManager extends  PresenterManager {

    //创建一个集合用于保存presenter,避免保持View引用
    private HashMap<String ,Presenter> hashMap  = new HashMap<>();
    private int nextId;

    @Override
    public <T extends Presenter> T createPresenter(Object view) {
        T presenter = PresenterBuilder.fromViewClass(view.getClass());
        if(presenter == null)return  null;
        presenter.id = providePresenterId();
        hashMap.put(presenter.id,presenter);

        return presenter;
    }

    @Override
    public <T extends Presenter> T getPresenter(String id) {
        return (T) hashMap.get(id);
    }

    @Override
    public void destory(String id) {
        hashMap.remove(id);

    }
    private  String providePresenterId(){
        return  nextId ++ + "/" + System.nanoTime() + "/" +(int)(Math.random()*Integer.MAX_VALUE);
    }
}
