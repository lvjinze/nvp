package com.recive.test;

import org.junit.Test;

import java.io.File;

/**
 * Created by zhouyangying on 2017/9/28.
 */
public class TestFilePath {
    @Test
    public void test1(){
        File file = new File("a.txt");
        System.out.println(file.getAbsoluteFile());
    }
}
