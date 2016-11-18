package com.guowei.android.test;

/**
 * Created by zhoug on 2016/8/2.
 */
public class TestClone implements Cloneable {
    public  TestCloneA testCloneA;  //浅拷贝不能改变引用类型，只能深拷贝

    public  int i = 0;  //浅拷贝只会改变基本数据类型

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //这是浅拷贝，不用管该类中的引用类型
        return super.clone();
    }
}
