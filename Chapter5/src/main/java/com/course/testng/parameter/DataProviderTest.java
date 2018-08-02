package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void DataProviderTest1(String name,int age){
        System.out.println();
        System.out.println("name ="+name+" age ="+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerdata(){
        Object[][] a = new Object[][]{
                {"qwer",10},
                {"asdf",20},
                {"zxcv",30}
        };
        return a;
    }
    @Test(dataProvider = "datamethod")
    public void Test1(String name){
        System.out.println();
        System.out.println("nametest11111 ="+name);
    }
    @Test(dataProvider = "datamethod")
    public void Test2(String name,int age){
        System.out.println();
        System.out.println("nametest2222 ="+name+" age ="+age);
    }
    @DataProvider(name = "datamethod")
    public Object[][] methoddatatest(Method method){
        Object[][] result = null;
        if(method.getName().equals("Test1")){
             result = new Object[][]{
                    {"qwer"},
                    {"asdf"}
            };
        }else if (method.getName().equals("Test2")){
             result = new Object[][]{
                    {"zxcv",70},
                    {"iuyt",90}
            };
        }
        return result;

    }
}
