package cats2;

import java.util.Collections;
import java.util.List;

public class CastsHelp {

	Api api;

	public void saveTheCutestCat(String query,final Callback<Uri> custestCatCallback) {
		api.queryCats(query, new Callback<List<Cat>>() {

			@Override
			public void onResult(List<Cat> result) {
				Cat cat = findCustest(result);
				api.store(cat, new Callback<Uri>() {

					@Override
					public void onResult(Uri result) {
						custestCatCallback.onResult(result);
					}

					@Override
					public void onError(Exception e) {
						custestCatCallback.onError(e);
					}
				});
			}

			@Override
			public void onError(Exception e) {
				custestCatCallback.onError(e);
				
			}
		});
		
	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
