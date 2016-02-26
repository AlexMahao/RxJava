package cats3;

import java.util.Collections;
import java.util.List;

import cats3.Api.CatsQueryCallback;
import cats3.Api.StoreCallback;



public class CastsHelp {
	
	ApiWrapper apiWrapper;

	public AsyncJob<Uri> saveTheCutestCat(final String query) {
		return new AsyncJob<Uri>() {
			
			
			@Override
			public void start(final Callback<Uri> callback) {
				apiWrapper.queryCats(query).start(new Callback<List<Cat>>() {
					
					@Override
					public void onResult(List<Cat> result) {
						Cat cat = findCustest(result);
						
						apiWrapper.store(cat).start(new Callback<Uri>() {
							
							@Override
							public void onResult(Uri result) {
								callback.onResult(result);
							}
							
							@Override
							public void onError(Exception e) {
								callback.onError(e);
							}
						});
					}
					
					@Override
					public void onError(Exception e) {
						
					}
				});;
			}
		};
		
		
	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
