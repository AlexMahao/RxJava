package catsend.rxjava;

import java.util.List;

public interface Api {

	
	interface CatsQueryCallback{
		void onCatListReceived(List<Cat> cats);
		void onCatsQueryError(Exception e);
	}
	
	
	interface StoreCallback{
		void onCateStored(Uri uri);
		void onStoteFailed(Exception e);
	}
	/**
	 * 查询所有猫
	 * @param query
	 * @return
	 */
	List<Cat> queryCats(String query,CatsQueryCallback castQueryCallback);
	
	
	/**
	 * 保存
	 * @param cat
	 * @return
	 */
	Uri store(Cat cat,StoreCallback storeCallback);
	
}
