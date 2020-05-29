package com.baidu.ai.aip.easydl;

import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.util.*;

/**
* easydl物体检测
*/
public class EasydlObjectDetection {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String easydlObjectDetection() {
        // 请求url
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/classification/lulu0316";
        try {
            Map<String, Object> map = new HashMap<>();
            
			String filePath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\img\\3.jpg";
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
            
            map.put("image", imgStr);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.8720a89895a3d79c1fc0e0c38d1f6574.2592000.1565763554.282335-16808086";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        EasydlObjectDetection.easydlObjectDetection();
    }
}

	