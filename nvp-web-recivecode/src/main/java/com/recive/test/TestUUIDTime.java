package com.recive.test;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by zhouyangying on 2017/9/26.
 */
public class TestUUIDTime {

    @Test
    public void test1(){
        int max=10000;
        long l = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {

            String s = UUID.randomUUID().toString();
            //System.out.println(s);
        }
        System.out.println(System.currentTimeMillis()-l);
    }
}
