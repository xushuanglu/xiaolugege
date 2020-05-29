
/**   
  * @文件名: TextAudit.java 
  * @包 com.baidu.ai.aip.textaudit 
  * @描述: TODO(用一句话描述该文件做什么) 
  * @作者：xushaunglu   
  * @创建时间 2019年7月16日 下午7:54:35 
  * @版本 V2.1  
  */
package com.baidu.ai.aip.zhinengchuangzuo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

public class Redian {

	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 * 
	 * @throws IOException
	 */
	public static String bodyAttr() {
		// 请求url
		String url = "https://aip.baidubce.com/rpc/2.0/creation/v1/hot_list/domain";
		try {

			Map<String, Object> map = new HashMap<>();

			map.put("domain", "娱乐");
			
			String param = GsonUtils.toJson(map);
			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			String accessToken = "24.5b900ca979afbcced7f862689e493490.2592000.1565918395.282335-16821794";

			String result = HttpUtil.post(url, accessToken, param);
			System.out.println(result);
			// System.out.println(param);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		bodyAttr();
	}

}
