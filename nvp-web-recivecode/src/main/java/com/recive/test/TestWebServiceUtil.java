package com.recive.test;

import com.recive.utils.WebServiceUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by zhouyangying on 2017/9/28.
 */
public class TestWebServiceUtil {
    private Log log=LogFactory.getLog(this.getClass());
    @Test
    public void test1(){

        String ans = WebServiceUtil.getAnswer("北京天气");
        log.info("请求完毕");
        log.info("请求的内容是"+ans);
        log.info("请求字符串的长度是:"+ans.length());
        int i = ans.lastIndexOf("\r");
        String substring = ans.substring(0,i);
        log.info("得到答案:"+substring);
        //System.out.println(substring);
    }
}
