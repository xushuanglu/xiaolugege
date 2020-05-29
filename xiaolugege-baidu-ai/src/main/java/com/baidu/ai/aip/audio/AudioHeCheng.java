package com.baidu.ai.aip.audio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

/**   
  * @文件名: AudioHeCheng.java 
  * @包 com.baidu.ai.aip.audio 
  * @描述: 语音合成
  * @作者：xushaunglu   
  * @创建时间 2019年7月18日 下午1:57:21 
  * @版本 V2.1  
  */
public class AudioHeCheng {

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
		String url = "http://tsn.baidu.com/text2audio";
		try {

			Map<String, Object> map = new HashMap<>();
//			aue:3
//			ctp:1
//			cuid:abcdxxx
//			lan:zh
//			per:0
//			pit:5
//			spd:5
//			tex:%E7%99%BE%E5%BA%A6%E4%BD%A0%E5%A5%BD
//			tok:24.363be9909162bd36a67767194c537795.2592000.1566020916.282335-16834989
//			vol:9
			
			//全部路径
//			http://tsn.baidu.com/text2audio?lan=zh&ctp=1&cuid=abcdxxx&tok=24.363be9909162bd36a67767194c537795.2592000.1566020916.282335-16834989&tex=%E7%99%BE%E5%BA%A6%E4%BD%A0%E5%A5%BD&vol=9&per=0&spd=5&pit=5&aue=3

			map.put("aue", "3");
			map.put("ctp", "1");
			map.put("cuid", "xiaolu");
			map.put("lan", "zh");
			map.put("per", "0");
			map.put("pit", "5");
			map.put("spd", "5");
			map.put("tex", "百度你好");
			map.put("vol", "9");
			map.put("tok", "24.363be9909162bd36a67767194c537795.2592000.1566020916.282335-16834989");
			
			String param = GsonUtils.toJson(map);
			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			String accessToken = "24.363be9909162bd36a67767194c537795.2592000.1566020916.282335-16834989";

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
