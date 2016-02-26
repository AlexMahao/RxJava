package cats4;

import java.util.Collections;
import java.util.List;

public class CastsHelp {

	ApiWrapper apiWrapper;

	public AsyncJob<Uri> saveTheCutestCat(final String query) {

		final AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper
				.queryCats(query);
		final AsyncJob<Cat> cutestCatAsyncJob = new AsyncJob<Cat>() {

			@Override
			public void start(final Callback<Cat> callback) {
				catsListAsyncJob.start(new Callback<List<Cat>>() {

					@Override
					public void onResult(List<Cat> result) {
						callback.onResult(findCustest(result));

					}

					@Override
					public void onError(Exception e) {
						callback.onError(e);
					}
				});
			}
		};

		AsyncJob<Uri> storedUriAsyncJob = new AsyncJob<Uri>() {

			@Override
			public void start(final Callback<Uri> callback) {
				cutestCatAsyncJob.start(new Callback<Cat>() {

					@Override
					public void onResult(Cat result) {
						apiWrapper.store(result).start(callback);
					}

					@Override
					public void onError(Exception e) {
						callback.onError(e);
					}
				});
			}
		};

		return storedUriAsyncJob;

	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
