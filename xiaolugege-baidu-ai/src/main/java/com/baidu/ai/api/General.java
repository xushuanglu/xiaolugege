package com.baidu.ai.api;

import java.net.URLEncoder;

import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;

/**
 * OCR 通用识别
 */
public class General {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static void main(String[] args) {
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
        //通用文字识别（高精度含位置版）
//        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate";
        //通用文字识别（含生僻字版）
//        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_enhanced";
        
    	//手写文字识别
//        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
        
        // 本地图片路径
        String filePath = "E:\\workspace1\\branch_HLS_LSWZ_20190617\\war\\u\\src\\main\\java\\com\\ibsonet\\matting\\baidu\\7.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = "24.d02d92ec7e91babed4f5a43e0345cd90.2592000.1565590523.282335-16797478";
            String result = HttpUtil.post(otherHost, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
