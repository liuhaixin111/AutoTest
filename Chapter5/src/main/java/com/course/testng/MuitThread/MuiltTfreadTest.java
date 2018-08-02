package com.course.testng.MuitThread;

import org.testng.annotations.Test;

public class MuiltTfreadTest {
    @Test(invocationCount = 10,threadPoolSize = 6)
    public void muiltTfreadTest(){
        System.out.println("打印1");
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
    }
}
