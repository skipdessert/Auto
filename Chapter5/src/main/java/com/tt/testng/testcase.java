package com.tt.testng;
import org.testng.annotations.*;

public class testcase {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void test(){
        System.out.println("这个是日志开始");
    }
    @Test
    public void test1(){
        System.out.println("用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试方法之后运行的");
    }
@BeforeClass
    public void beforeClass(){
        System.out.println("这是类之前运行的");
}

@AfterClass
public void afterClass(){
    System.out.println("这是类之后运行的");
}
@BeforeSuite
public void beforeSuite(){
    System.out.println("这是beforeSuite");
}
@AfterSuite
public void afterSuite(){
    System.out.println("这是afterSuite");
}
}
