
/**   
  * @文件名: Sample.java 
  * @包 com.baidu.ai.aip.audio 
  * @描述: TODO(用一句话描述该文件做什么) 
  * @作者：xushaunglu   
  * @创建时间 2019年8月12日 下午5:42:58 
  * @版本 V2.1  
  */
package com.baidu.ai.aip.audio;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


public class Sample {

	   //设置APPID/AK/SK
    public static final String APP_ID = "16822946";
    public static final String API_KEY = "i5m9TFVadX8rxANOkcO1AgOE";
    public static final String SECRET_KEY = "HY0dUjhBEAxTEhsDD0RnSNi4d9cVwKmh";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("127.0.0.1", 8080);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\java\\com\\baidu\\ai\\aip\\audio\\log4j.properties");

        // 调用接口
        JSONObject res = client.asr("E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\java\\com\\baidu\\ai\\aip\\audio\\test.wav", "wav", 16000, null);
        com.alibaba.fastjson.JSONObject js = JSON.parseObject(res.toString());
        JSONArray data = js.getJSONArray("result");
        String result = data.get(0).toString();
//        String result = res.get("result").toString();
        System.out.println(result);
        System.out.println(res.toString(2));
        
    }

}
