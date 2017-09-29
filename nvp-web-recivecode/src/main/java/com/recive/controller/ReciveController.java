package com.recive.controller;

import com.recive.model.Prompt;
import com.recive.utils.WebServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhouyangying on 2017/9/26.
 * 接收vxml提交过来参数
 */
@Controller
@RequestMapping("recive")
public class ReciveController {
    private Log log= LogFactory.getLog(this.getClass());
    @RequestMapping(value = "test1", produces = "text/xml;charset=utf-8")
    @ResponseBody()
    public String test1(String[] filename,String[] formid,HttpServletRequest request) {
        Map<String,String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> e : parameterMap.entrySet()) {
            log.info("接收到的参数有:"+e.getKey()+":"+"接收到的值是:"+Arrays.toString(e.getValue()));
        }
        String query = request.getParameter("main.dm_root");
        log.info("得到的问题代码是:"+query);
        //拼接url
        String desEle = filename[0] + formid[0];
        log.info("目标descEle是"+desEle);

        String ans="";
        //请求知识平台
        if(query.equals("bjw")){
            ans = WebServiceUtil.getAnswer("北京天气");
        }
        log.info("请求完毕");
        log.info("请求的内容是"+ans);
        log.info("请求字符串的长度是:"+ans.length());
        int i = ans.lastIndexOf("\r");
        String substring = ans.substring(0,i);
        log.info("得到答案:"+substring);
        log.info("ans is " + ans);
        ans="北京天气很好";

        String s ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!--添加vxml约束,必须添加-->\n" +
                "<!DOCTYPE vxml PUBLIC \"-//Nuance/DTD VoiceXML 2.0//ZH\" \"http://voicexml.nuance.com/dtd/nuancevoicexml-2-0.dtd\">\n" +
                "<!--指定xml版本-->\n" +
                "<vxml version=\"2.0\">\n" +
                "    <form>\n" +
                "        <block>\n" +
                "            "+substring+"\n" +
                "            <goto next=\""+desEle+"\"/>\n" +
                "        </block>\n" +
                "    </form>\n" +
                "</vxml>\n";
        return s;
    }

}
