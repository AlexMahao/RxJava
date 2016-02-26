package cats5;

import java.util.Collections;
import java.util.List;

import cats3.Api.CatsQueryCallback;
import cats3.Api.StoreCallback;

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
				// TODO Auto-generated method stub
				return apiWrapper.store(t);
			}
		});
		
		

		
		return storedUriAsyncJob;

	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
