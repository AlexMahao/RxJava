import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;


public class Demo2 {
	public static void main(String[] args) {
		ArrayList<Integer> items = new ArrayList<>();
		
		items.add(1);
		items.add(10);
		items.add(100);
		items.add(1000);
		
		
		
		Observable<Integer> observableInteger = Observable.from(items);
		
		
		observableInteger.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer i) {
				System.out.println(i);
			}
		});
		
		
		
	}
	
	
}
