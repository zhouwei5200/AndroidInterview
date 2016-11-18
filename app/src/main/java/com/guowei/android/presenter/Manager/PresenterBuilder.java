package com.guowei.android.presenter.Manager;

import com.guowei.android.presenter.Presenter;
import com.guowei.android.presenter.RequiresPresenter;

/**
 * Created by zhoug on 2016/8/1.
 */
public class PresenterBuilder {
    //在这里通过view利用注解获取presenter
    public static <PresenterType extends Presenter> PresenterType fromViewClass(Class<?> viewClass){
        RequiresPresenter annotation = viewClass.getAnnotation(RequiresPresenter.class);
        if(annotation == null){
            return  null;
        }

        Class<PresenterType> presenterTypeClass = (Class<PresenterType>) annotation.value();
        PresenterType presenter;
        try{
            presenter = presenterTypeClass.newInstance();

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return presenter;
    }
}