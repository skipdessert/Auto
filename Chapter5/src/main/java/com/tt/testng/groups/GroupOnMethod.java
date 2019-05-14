package com.tt.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups="server")
    public void test1(){
        System.out.println("f服务端测试方法1");
    }
    @Test(groups="server")
    public void test2(){
        System.out.println("f服务端测试方法2");
    }
    @Test(groups="client")
    public void test3(){
        System.out.println("客户端测试方法1");
    }@Test(groups="client")
    public void test4(){
        System.out.println("客户端测试方法2");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("服务端运行前方法");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("服务端运行后方法！！！！");
    }
}
