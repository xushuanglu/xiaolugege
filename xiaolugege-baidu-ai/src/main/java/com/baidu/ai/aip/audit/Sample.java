//
///**   
//  * @文件名: Sample.java 
//  * @包 com.baidu.ai.aip.audit 
//  * @描述: TODO(用一句话描述该文件做什么) 
//  * @作者：xushaunglu   
//  * @创建时间 2019年7月16日 下午1:37:39 
//  * @版本 V2.1  
//  */
//package com.baidu.ai.aip.audit;
//
//import org.json.JSONObject;
//
//import com.baidu.aip.contentcensor.AipContentCensor;
//import com.baidu.aip.imageclassify.AipImageClassify;
//
//public class Sample {
//    //设置APPID/AK/SK
//    public static final String APP_ID = "16808022";
//    public static final String API_KEY = "7CQuqu7VnlHYmwiKOxNCZGBr";
//    public static final String SECRET_KEY = "z1dFSECS1DmXv4FxZZUGXebhMRgqdGWV";
//
//    public static void main(String[] args) {
//        // 初始化一个AipImageCensor
//    	AipImageCensor client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(20000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("127.0.0.1", 8080);  // 设置http代理
////        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\log4j.properties");
//
//        // 调用接口
//        String path = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\img\\huangse.jpg";
//        JSONObject res = client.antiPorn(path);
//        System.out.println(res.toString(2));
//        
//    }
//}