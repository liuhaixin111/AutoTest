package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class groupsonclass1 {
    public void stu1(){
        System.out.println("groupsonclass1中的stu1111111运行");
    }
    public void stu2(){
        System.out.println("groupsonclass1中的stu2222222运行");
    }

}
