package api_test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.util.MimeTypeUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zebra.api.commons.util.DateUtil;
import com.zebra.api.commons.util.HttpUtil;
import com.zebra.api.commons.util.SignConstants;
import com.zebra.api.commons.util.SignConstants.SignType;
import com.zebra.api.commons.util.SignUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoticeApiTest extends BaseTest {

	public static void main(String[] args) throws Exception {
		HttpUtil httpUtil = HttpUtil.getInstance("utf-8", 10000, 10000);
		Map<String, Object> map = new HashMap<>();
		Map<String, String> headMap = new HashMap<>();
		String tokenTime = DateUtil.format(new Date(), SignConstants.TOKEN_TIME_FORMT);
		String tokenNonceStr = UUID.randomUUID().toString();
		map.put("tokenTime", tokenTime);
		map.put("tokenNonceStr", tokenNonceStr);
		String sin = SignUtil.generateSignature(map, SECRET, SignType.HMACSHA256);
		JSONObject jsonObject = (JSONObject) JSON.toJSON(map);
		jsonObject.put("sign", sin);
		log.info("[信息]请求-" + jsonObject.toString());
		headMap.put(KEY_HEAND, KEY);
		String result = httpUtil.sendHttpPost("http://127.0.0.1:1213/noticeServer/getNotice/1", null, headMap,
				jsonObject.toString(), MimeTypeUtils.APPLICATION_JSON);
		log.info("[信息]响应-" + result);
	}

}
