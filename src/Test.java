import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("clientType", "1");

		map.put("shareState", "1");
		Gson gson = new Gson();
		paramsMap.put("requestData", gson.toJson(map));
		System.out.println(paramsMap.toString());
	}
}
