package com.baidu.ai.aip.face;

import java.util.HashMap;
import java.util.Map;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

import net.sf.json.JSONObject;

/**
* 人脸检测与属性分析
*/
public class FaceDetect {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            
            String filePath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\img\\223.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
//            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
//            String data = params.substring(6);
            
            map.put("image", imgStr);
            map.put("face_field", "faceshape,facetype,age");
            map.put("image_type", "BASE64");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.cd4b1258d2eb881f18df90b97a4e7a4d.2592000.1566112917.282335-16569059";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject lawPudJson = JSONObject.fromObject(result);
//    		JSONArray lawPuddata = (JSONArray) lawPudJson.get("d");
            String data = lawPudJson.getString("result");
            if(data != null && !"null".equals(data)){
            	System.out.println(result);
            	System.out.println(data);
            }else{
            	System.out.println("抠图文件有问题");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect.detect();
    }
}
