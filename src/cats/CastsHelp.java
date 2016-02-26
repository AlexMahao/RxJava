package cats;

import java.util.Collections;
import java.util.List;

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
