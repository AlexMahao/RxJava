import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJava2 {
	public static void main(String[] args) {
		Observable<String> myObserver = Observable.just("Hello world");

		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println(s);
			}
		};

		myObserver.subscribe(onNextAction);

		Observable.just("hello two").subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});

		Observable.just("hello").map(new Func1<String, String>() {

			@Override
			public String call(String s) {
				return s + "haha";
			}
		}).subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});

		Observable.just("hello world").map(new Func1<String, Integer>() {
			@Override
			public Integer call(String s) {

				return s.hashCode();

			}
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer i) {

				System.out.println(Integer.toString(i));

			}
		});
	}

	Observable<List<String>> query(String text) {
		return Observable.create(new Observable.OnSubscribe<List<String>>() {

			@Override
			public void call(Subscriber<? super List<String>> sub) {
				List<String> urls = new ArrayList<String>();
				urls.add("http://www.baidu.com");
				urls.add("http://www.sina.com");
				sub.onNext(urls);
				sub.onCompleted();
			}

		});
	}
}
