import rx.Observable;
import rx.Subscriber;


public class RxJavaTest {

	public static void main(String[] args) {
		Observable<String> myObservable = Observable
				.create(new Observable.OnSubscribe<String>() {
					public void call(rx.Subscriber<? super String> sub) {
						sub.onNext("Hello,world");
						sub.onCompleted();
					}
				});

		Subscriber<String> mySubscriber = new Subscriber<String>() {

			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
					System.out.println(s);
			}

		};

		myObservable.subscribe(mySubscriber);
	}
}
