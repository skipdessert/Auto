package com.tt.testng.suite;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore 执行");
    }
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore 2222执行");
    }
}
