package cats1;

import java.util.Collections;
import java.util.List;

import cats1.Api.CatsQueryCallback;
import cats1.Api.StoreCallback;

public class CastsHelp {
	
	public interface CutestCatCallback{
		void onCutestCatSaved(Uri uri);
		
		void onCutestCatFail(Exception e);
	}
	
	Api api;

	public void saveTheCutestCat(String query,final CutestCatCallback custestCatCallback) {
		List<Cat> queryCats = api.queryCats(query,new CatsQueryCallback() {
			
			@Override
			public void onCatsQueryError(Exception e) {
				custestCatCallback.onCutestCatFail(e);
			}
			
			
			@Override
			public void onCatListReceived(List<Cat> cats) {
				Cat cat = findCustest(cats);
				
				api.store(cat, new StoreCallback() {
					
					@Override
					public void onStoteFailed(Exception e) {
						custestCatCallback.onCutestCatFail(e);
						
					}
					
					@Override
					public void onCateStored(Uri uri) {
						custestCatCallback.onCutestCatSaved(uri);
					}
				});
			}
		});
		
	}

	private Cat findCustest(List<Cat> queryCats) {
		return Collections.max(queryCats);
	}
}
