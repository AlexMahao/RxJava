package catsend.rxjava;

import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import catsend.rxjava.Api.CatsQueryCallback;
import catsend.rxjava.Api.StoreCallback;

/**
 * 接口的包装类 备注人： Alex_MaHao
 * 
 * @date 创建时间：2016年2月26日 上午10:11:28
 */
public class ApiWrapper {
	Api api;

	public Observable<List<Cat>> queryCats(final String query) {
		
		return Observable.create(new OnSubscribe<List<Cat>>() {

			@Override
			public void call(final Subscriber<? super List<Cat>> arg0) {
				api.queryCats(query, new CatsQueryCallback() {
					
					@Override
					public void onCatsQueryError(Exception e) {
						arg0.onError(e);
					}
					
					@Override
					public void onCatListReceived(List<Cat> cats) {
						arg0.onNext(cats);
					}
				});
			}
		});
	}

	public Observable<Uri> store(final Cat cat) {
		return Observable.create(new OnSubscribe<Uri>() {

			@Override
			public void call(final Subscriber<? super Uri> subscriber) {
				api.store(cat, new StoreCallback() {
					
					@Override
					public void onStoteFailed(Exception e) {
						subscriber.onError(e);
					}
					
					@Override
					public void onCateStored(Uri uri) {
						subscriber.onNext(uri);
					}
				});
			}
		});
	}

}
