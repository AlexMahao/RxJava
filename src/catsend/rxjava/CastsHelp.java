package catsend.rxjava;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class CastsHelp {

	ApiWrapper apiWrapper;

	public Observable<Uri> saveTheCutestCat(final String query) {
		return apiWrapper
				.queryCats(query)
				.map(new Func1<List<Cat>, Cat>() {

						@Override
						public Cat call(List<Cat> cats) {
			
							return findCustest(cats);
						}
					})
				.flatMap(new Func1<Cat, Observable<Uri>>() {
			
						@Override
						public Observable<Uri> call(Cat cat) {
			
							return apiWrapper.store(cat);
						}
					});

	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
