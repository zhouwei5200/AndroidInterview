package com.guowei.android.model.bmob;

import android.widget.Toast;

import com.guowei.android.model.AlgorithmBean;
import com.guowei.android.model.AndroidBean;
import com.guowei.android.model.CommitBean;
import com.guowei.android.model.DesignBean;
import com.guowei.android.model.JavaBean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import rx.Subscriber;

/**
 * Created by zhoug on 2016/8/18.
 */
public class BmobRecommend{



    public static <T> ArrayList<T> getRecommendData(final Subscriber<ArrayList<AndroidBean>> subscriber) {
        BmobQuery<AndroidBean> bmobQuery = new BmobQuery<>();
        bmobQuery.order("-createdAt");
        bmobQuery.findObjects(new FindListener<AndroidBean>() {
            @Override
            public void done(List<AndroidBean> list, BmobException e) {
               if(e == null){
                ArrayList<AndroidBean>   recommends = (ArrayList<AndroidBean>) list;
               subscriber.onNext(recommends);
                }else {
                    subscriber.onError(e);
               }
           }
        });
        return null;
    }


    public static <T> ArrayList<T> getJavaRecommendData(final Subscriber<ArrayList<JavaBean>> subscriber) {
        BmobQuery<JavaBean> bmobQuery = new BmobQuery<>();
        bmobQuery.order("-createdAt");
        bmobQuery.findObjects(new FindListener<JavaBean>() {
            @Override
            public void done(List<JavaBean> list, BmobException e) {
                if(e == null){
                    ArrayList<JavaBean>   recommends = (ArrayList<JavaBean>) list;
                    subscriber.onNext(recommends);
                }else {
                    subscriber.onError(e);
                }
            }
        });
        return null;
    }


    public static <T> ArrayList<T> getStyleRecommendData(final Subscriber<ArrayList<DesignBean>> subscriber) {
        BmobQuery<DesignBean> bmobQuery = new BmobQuery<>();
        bmobQuery.order("-createdAt");
        bmobQuery.findObjects(new FindListener<DesignBean>() {
            @Override
            public void done(List<DesignBean> list, BmobException e) {
                if(e == null){
                    ArrayList<DesignBean>   recommends = (ArrayList<DesignBean>) list;
                    subscriber.onNext(recommends);
                }else {
                    subscriber.onError(e);
                }
            }
        });
        return null;
    }
    public static <T> ArrayList<T> getArithmeticRecommendData(final Subscriber<ArrayList<AlgorithmBean>> subscriber) {
        BmobQuery<AlgorithmBean> bmobQuery = new BmobQuery<>();
        bmobQuery.order("-createdAt");
        bmobQuery.findObjects(new FindListener<AlgorithmBean>() {
            @Override
            public void done(List<AlgorithmBean> list, BmobException e) {
                if(e == null){
                    ArrayList<AlgorithmBean>   recommends = (ArrayList<AlgorithmBean>) list;
                    subscriber.onNext(recommends);
                }else {
                    subscriber.onError(e);
                }
            }
        });
        return null;
    }

     /*AndroidBean androidBean = new AndroidBean();
        androidBean.setArticle_author("zhou12314");
        androidBean.setArticle_name("222222222");
        initSerarchView();
        androidBean.setArticle_star(8);
        androidBean.setArticleUrl("http://blog.csdn.net/zhou12314");
        androidBean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this,"添加数据成功，返回objectId为：",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"添加数据失败，返回objectId为：",Toast.LENGTH_LONG).show();
                }
            }
        });*/
    public static String saveCommitBeanData(final Subscriber<String> subscriber,CommitBean commitBean) {
        commitBean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e == null){
                    subscriber.onNext(s);
                }else {
                    subscriber.onError(e);
                }
            }
        });
        return null;
    }




}
