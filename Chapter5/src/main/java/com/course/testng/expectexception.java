package com.course.testng;

import org.testng.annotations.Test;

public class expectexception {
    /**
     * 在期望结果是某一个异常时用到
     */
    //测试结果失败
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeexcrptionfail(){
        System.out.println("这是一个失败的异常测试");
    }
    //测试结果成功
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeexcrptionsuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
