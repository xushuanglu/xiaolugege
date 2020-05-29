package com.baidu.ai.aip.face;

import java.util.HashMap;
import java.util.Map;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

/**
* 人脸融合
*/
public class FaceMerge {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String facemerge() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/merge";
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> image_templateMap = new HashMap<>();
            
            String filePath = "E:\\workspace1\\branch_HLS_LSWZ_20190617\\war\\u\\src\\main\\java\\com\\baidu\\ai\\aip\\mubiao.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String mubiao = Base64Util.encode(imgData);
            
            image_templateMap.put("image", mubiao);
            image_templateMap.put("image_type", "BASE64");
            image_templateMap.put("quality_control", "NONE");
            map.put("image_template", image_templateMap);
            Map<String, Object> image_targetMap = new HashMap<>();
            
            String filePath1 = "E:\\workspace1\\branch_HLS_LSWZ_20190617\\war\\u\\src\\main\\java\\com\\baidu\\ai\\aip\\moban.png";
            byte[] imgData1 = FileUtil.readFileByBytes(filePath1);
            String moban = Base64Util.encode(imgData1);
            
            image_targetMap.put("image", moban);
            image_targetMap.put("image_type", "BASE64");
            image_targetMap.put("quality_control", "NONE");
            map.put("image_target", image_targetMap);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.1d037130332c906571dd801f3e7d46cf.2592000.1565599626.282335-16569059";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceMerge.facemerge();
    }
}

	