package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupsonclass3 {
    public void teacher1(){
        System.out.println("groupsonclass333中的teacher111111运行");
    }
    public void teacher2(){
        System.out.println("groupsonclass333中的teacher22222运行");
    }
}
