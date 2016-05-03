package cats5;

import java.util.Collections;
import java.util.List;


public class CastsHelp {

	ApiWrapper apiWrapper;

	public AsyncJob<Uri> saveTheCutestCat(final String query) {

		final AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper
				.queryCats(query);
		final AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {

			@Override
			public Cat call(List<Cat> t) {
				return findCustest(t);
			}
		});
		AsyncJob<Uri> storedUriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {

			@Override
			public AsyncJob<Uri> call(Cat t) {
				return apiWrapper.store(t);
			}
		});
	
		return storedUriAsyncJob;
		
	}
	
	
/*
	public AsyncJob<Uri> saveTheCutestCat(final String query) {

		return apiWrapper
				.queryCats(query)
				.map(new Func<List<Cat>, Cat>() {

					@Override
					public Cat call(List<Cat> t) {
						
						
						return findCustest(t);
					}
				}).flatMap(new Func<Cat, AsyncJob<Uri>>() {

					@Override
					public AsyncJob<Uri> call(Cat t) {
						
						return apiWrapper.store(t);
					}
				});

	}
*/
	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
