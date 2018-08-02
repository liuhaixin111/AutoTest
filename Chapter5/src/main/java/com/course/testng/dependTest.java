package com.course.testng;

import org.testng.annotations.Test;

public class dependTest {
    @Test
    private void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    private void test2(){
        System.out.println("test2 run");
    }
}
