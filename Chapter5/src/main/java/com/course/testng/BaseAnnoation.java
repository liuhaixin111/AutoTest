package com.course.testng;

import org.testng.annotations.*;

public class BaseAnnoation {
    @Test
    public void testcase1(){
        System.out.println("测试一");
    }
    @Test
    public void testcase2(){
        System.out.println("测试er二");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("方法之前执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("方法之hou执行");
    }
    @BeforeSuite
    public void beforesuit(){
        System.out.println("suit之前执行");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("suit之hou执行");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("test之前执行");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("test之hou执行");
    }
}
