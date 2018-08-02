package com.course.testng.suite;

import org.testng.annotations.Test;

public class TimeoutTest {
    @Test(timeOut = 3000)//单位毫秒
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 3000)
    public void test2() throws InterruptedException {
        Thread.sleep(4000);
    }
}
