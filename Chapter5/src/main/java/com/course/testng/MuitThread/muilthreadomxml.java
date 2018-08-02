package com.course.testng.MuitThread;

import org.testng.annotations.Test;

public class muilthreadomxml {
    @Test
    public void Test1(){
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void Test2(){
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void Test3(){
        System.out.printf("Thread id : %s%n",Thread.currentThread().getId());
    }
}
