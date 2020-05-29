package com.baidu.translate.demo;

import java.io.UnsupportedEncodingException;

/**
 * 百度通用翻译API
 * @author Administrator
 *
 */
public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID       = "20190715000318077";
    private static final String SECURITY_KEY = "cDOzM6wpRTQabxPC_LAf";	

    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "java开发工程师";
        System.out.println(api.getTransResult(query, "auto", "en"));
        
        String query1 = "apple";
        System.out.println(api.getTransResult(query1, "en", "zh"));
    }

}
