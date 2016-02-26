package cats2;

import java.util.List;

public interface Api {

	
	/**
	 * 查询所有猫
	 * @param query
	 * @return
	 */
	void queryCats(String query,Callback castQueryCallback);
	
	
	/**
	 * 保存
	 * @param cat
	 * @return
	 */
	void store(Cat cat,Callback storeCallback);
	
}
