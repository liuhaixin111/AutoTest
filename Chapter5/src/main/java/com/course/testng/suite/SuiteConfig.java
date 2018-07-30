package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
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
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("方法之前执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("方法之hou执行");
    }
}
