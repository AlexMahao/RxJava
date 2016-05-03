
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Demo4 {
	public static void main(String[] args) {
		 Observable
         .create(new Observable.OnSubscribe<String>() {
             @Override
             public void call(Subscriber<? super String> subscriber) {
                 subscriber.onNext("a");
                 subscriber.onNext("b");

                 subscriber.onCompleted();
             }
         })
         .subscribeOn(Schedulers.io())
        
         .subscribe(new Observer<String>() {
             @Override
             public void onCompleted() {
                 System.out.print("mmm");
             }

             @Override
             public void onError(Throwable e) {

             }

             @Override
             public void onNext(String integer) {
                 System.out.println(integer);
             }
         });
	}
}
