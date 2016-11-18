package com.guowei.android.test;

/**
 * Created by zhoug on 2016/8/2.
 */
public class TestClone1 implements  Cloneable {
    private  TestCloneA testCloneA  ;
    public  void  setTestCloneA( TestCloneA testCloneA ){
        this.testCloneA = testCloneA;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        TestClone1 testClone1 = (TestClone1) super.clone();
        testClone1.testCloneA = (TestCloneA) testCloneA.clone();
        return  testClone1;
    }
}
