import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;


public class Demo1 {

	public static void main(String[] args) {
		
		Observable<Integer> observableString = Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> subscriber) {
				for(int i=0;i<5;i++){
					subscriber.onNext(i);
				}
				
				subscriber.onCompleted();
			}
		});
	
		Subscription subscribe = observableString.subscribe(new Observer<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("Observable completed");
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer item) {
				System.out.println(item);
			}
		});
		
		
		
		
	}
}
