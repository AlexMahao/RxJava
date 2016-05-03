import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaOperator {
	public static void main(String[] args) {
		
		/*
		query("urls")
		.flatMap(new Func1<List<String>,Observable<String>>() {

			@Override
			public Observable<String> call(List<String> urls) {
				return Observable.from(urls);
			}
		})
		.filter(new Func1<String, Boolean>() {

			@Override
			public Boolean call(String title) {
			
				return title!=null;
			}
		})
		.take(5)
		.doOnNext(new Action1<String>() {

			@Override
			public void call(String s) {

				
			}
		})
		.subscribe(new Action1<String>() {

			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});*/
		
		/*query("urls")
		.subscribe(new Action1<List<String>>() {

			@Override
			public void call(List<String> urls) {
				Observable.from(urls).subscribe(new Action1<String>() {

					@Override
					public void call(String s) {
						System.out.println(s);
					}
				});
			}
		
		});*/
		
		query("urls")
		.flatMap(new Func1<List<String>,Observable<String>>() {

			@Override
			public Observable<String> call(List<String> urls) {
				return Observable.from(urls);
			}
		}).subscribe(new Action1<String>() {

			@Override
			public void call(String arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}
		});
	/*	
		
		query("urls").map(new Func1<List<String>, Observable<String>>() {

			@Override
			public Observable<String> call(List<String> arg0) {
				
				
				return Observable.from(arg0);
			}
		}).subscribe(new Action1<String>() {

			@Override
			public void call(String arg0) {
				System.out.println(arg0);
			}
		});*/
		
		
		
	}
	
	static Observable<List<String>> query(String text) {
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
