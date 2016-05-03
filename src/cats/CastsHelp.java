package cats;

import java.util.Collections;
import java.util.List;

/**
 * 
 * 备注人： Alex_MaHao
 * @date 创建时间：2016年3月30日 下午4:22:40
 */
public class CastsHelp {
	Api api;

	public Uri saveTheCutestCat(String query) {
		List<Cat> queryCats = api.queryCats(query);
		Cat cat = findCustest(queryCats);
		
		Uri savedUri = api.store(cat);
		return savedUri;
	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
