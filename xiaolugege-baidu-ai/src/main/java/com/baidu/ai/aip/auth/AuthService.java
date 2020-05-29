package com.baidu.ai.aip.auth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * 获取token类
 */
public class AuthService {

    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "E6Iy7749tH3GwQs8XSfq2566";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "RqKTmr4FbIpZclBl6uhTf2c6GyM1l75Q";
        return getAuth(clientId, clientSecret);
    }
    
    public static void main(String[] args) {
    	//人体分割
//    	getAuth("oGcHkYocnHmNSw1fCLDQtf03","ArQygElf2ewQhbeHlBfl9ItFc3lcDrMl");
    	//人体分析
//    	getAuth("oGcHkYocnHmNSw1fCLDQtf03","ArQygElf2ewQhbeHlBfl9ItFc3lcDrMl");
    	//自然语言
//    	getAuth("6w4ib72sDrPGmSVLUVmgiFRv","uGmpUbSC69EkaP0y2ciQtrKNeu8kkWdw");
//    	getAuth("HQ56Tm9EGwsDh1P9R0gUxdhO","ZctK6WeuIsR6X1aZUUmy3Mg1HODsqYHY");
    	//内容审核
//    	getAuth("7CQuqu7VnlHYmwiKOxNCZGBr","z1dFSECS1DmXv4FxZZUGXebhMRgqdGWV");
    	//文本审核
//    	getAuth("HB49tL1wzI6llrUzlUggEiAq","iIbThOI5uf4flVIhHmmr76W6akEP9IqP");
    	//智能创作平台
//    	getAuth("5pnGVsN27fYmcTaRE0sQenWZ","3ugmiBIkuGiQdqk2OFtr166QqsCGVD1x");
    	//热点发现
//    	getAuth("rrwanbSGCEjyVUzCs0XnzdUk","LXTadclS3NCtea4pS9El5RPrvCWjwEQo");
    	//语音合成
//    	getAuth("uhUnLX11GdxzL9EZkbB7q5co","sNGq96twuX4h0PBrOnlH4SCWB4X9u7OT");
    	//人脸识别
    	getAuth("sFKouQuFQHEAV7uLGNb11UHa","bKqQEpPq0ue8nzhU8b72aNolCCNZRTjT");
	}

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            System.out.println("access_token:" + access_token);
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
    
}

