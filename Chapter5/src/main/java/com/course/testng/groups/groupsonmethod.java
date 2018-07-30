package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
public class groupsonmethod {
    @Test(groups = "server")
    public void test1() {
        System.out.println("服务端组测试一");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("服务端组测试二222");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端组测试33");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("客户端组测试4444");
    }

    @BeforeGroups("server")
    public void brforegroupssurver() {
        System.out.println("服务端组测试之前测试");
    }
    @AfterGroups("server")
    public void aftergroupsserver(){
        System.out.println("服务端组测试之后hou测试");
    }
}

