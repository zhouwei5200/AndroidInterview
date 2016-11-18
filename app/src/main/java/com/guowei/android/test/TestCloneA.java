package com.guowei.android.test;

/**
 * Created by zhoug on 2016/8/2.
 */
public class TestCloneA  implements  Cloneable{
    //
    private  int i = 1111;

    @Override
      protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
