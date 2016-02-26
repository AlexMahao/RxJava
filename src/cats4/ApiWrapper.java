package cats4;

import java.util.List;

import cats4.Api.CatsQueryCallback;
import cats4.Api.StoreCallback;

/**
 * 接口的包装类 备注人： Alex_MaHao
 * 
 * @date 创建时间：2016年2月26日 上午10:11:28
 */
public class ApiWrapper {
	Api api;

	public AsyncJob<List<Cat>> queryCats(final String query) {
		return new AsyncJob<List<Cat>>() {

			@Override
			public void start(final Callback<List<Cat>> callback) {
				api.queryCats(query, new CatsQueryCallback() {

					@Override
					public void onCatsQueryError(Exception e) {
						callback.onError(e);

					}

					@Override
					public void onCatListReceived(List<Cat> cats) {
						callback.onResult(cats);
					}
				});
			}
		};

	}
	

	public AsyncJob<Uri> store(final Cat cat) {
		return new AsyncJob<Uri>() {

			@Override
			public void start(final Callback<Uri> callback) {
				api.store(cat, new StoreCallback() {

					@Override
					public void onStoteFailed(Exception e) {
						callback.onError(e);
					}

					@Override
					public void onCateStored(Uri uri) {
						callback.onResult(uri);
					}
				});
			}

		};
	}

}
