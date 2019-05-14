package com.tt.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 运行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite 运行");
    }
}
