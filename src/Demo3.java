import rx.Observable;
import rx.Observer;

/***
 * just()方法，执行此方法之后，会默认发送subscriber.onComplete();
 * 备注人： Alex_MaHao	
 * @date 创建时间：2016年3月1日 下午3:55:38
 */
public class Demo3 {
	public static void main(String[] args) {
	Observable<String> observable = Observable.just(hello());
		
		observable.subscribe(new Observer<String>(){

			@Override
			public void onCompleted() {
				System.err.println("observable completed");
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(String message) {
				System.out.println(message);
			}
			
		});
		
	
		
	}
	
	
	
	public static String hello(){
		return "Hello world!!";
	}
}
