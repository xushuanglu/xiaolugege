
/**   
  * @文件名: PictureAuditTest.java 
  * @包 com.baidu.ai.aip.audit 
  * @描述: TODO(用一句话描述该文件做什么) 
  * @作者：xushaunglu   
  * @创建时间 2019年7月16日 下午1:16:21 
  * @版本 V2.1  
  */
package com.baidu.ai.aip.audit;

import java.io.IOException;
import java.net.URLEncoder;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;
/**
 * 用户头像审核
 * @author Administrator
 *
 */
public class PictureAuditTest {
	
	/*public void sample(AipContentCensor client) {
	    // 参数为本地图片路径
	    String path = "test.jpg";
	    JSONObject response = client.imageCensorUserDefined(path, EimgType.FILE, null);
	    System.out.println(response.toString());

		// 参数为url
		String url = "http://testurl";
	    response = client.imageCensorUserDefined(url, EimgType.URL, null);
	    System.out.println(response.toString());

	    // 参数为本地图片文件二进制数组
	    byte[] file = readImageFile(imagePath);
	    response = client.imageCensorUserDefined(file, null);
	    System.out.println(response.toString());
	}*/
	
	  /**
	    * 重要提示代码中所需工具类
	    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	    * 下载
	 * @throws IOException 
	    */
	    public static String bodyAttr() {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/solution/v1/face_audit";
	        try {
	            // 本地文件路径
	            String filePath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\img\\huang.jpg";
	            byte[] imgData = FileUtil.readFileByBytes(filePath);
	            String imgStr = Base64Util.encode(imgData);
	            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

	            String param = "images=" + imgParam;

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = "24.3b4dc63d9945766837b987e1831b36f0.2592000.1565846474.282335-16808022";

	            String result = HttpUtil.post(url, accessToken, param);
	            System.out.println(result);
//	            System.out.println(param);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public static void main(String[] args) throws IOException {
	    	/* // 本地文件路径
            String filePath = "E:\\workspace1\\xushuanglu-baidu-ai\\src\\main\\resources\\img\\huangse.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "images=" + imgParam;
            System.out.println(param);
            
            // 初始化一个AipImageCensor
            AipContentCensor client = new AipContentCensor(null, null, null);*/
	    	bodyAttr();
	    }

}
