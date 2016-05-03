package cats3;

import java.util.List;

public interface Api {

	/**
	 * 查询所有猫
	 * @param query
	 * @return
	 */
	List<Cat> queryCats(String query,Callback castQueryCallback);
	
	
	/**
	 * 保存
	 * @param cat
	 * @return
	 */
	Uri store(Cat cat,Callback storeCallback);
	
}
