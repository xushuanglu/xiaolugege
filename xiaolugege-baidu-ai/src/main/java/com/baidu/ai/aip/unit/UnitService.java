package com.baidu.ai.aip.unit;
import com.baidu.ai.aip.utils.HttpUtil;
/*
 * unit对话服务
 */
public class UnitService {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    private static String utterance() {
        // 请求URL
        String talkUrl = "https://aip.baidubce.com/rpc/2.0/unit/service/chat";
        try {
            // 请求参数
            String params = "{\"log_id\":\"UNITTEST_10000\",\"version\":\"2.0\",\"service_id\":\"S10000\",\"session_id\":\"\",\"request\":{\"query\":\"WEATHER\",\"user_id\":\"88888\"},\"dialog_state\":{\"contexts\":{\"SYS_REMEMBERED_SKILLS\":[\"1057\"]}}}";
            String accessToken = "24.28c7d8e4d0c4c5fbc83e062f31fbdab6.2592000.1565761705.282335-16807651";
            String result = HttpUtil.post(talkUrl, accessToken, "application/json", params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        utterance();
    }
}

	