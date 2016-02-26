package cats;

import java.util.List;

public interface Api {

	/**
	 * 查询所有猫
	 * @param query
	 * @return
	 */
	List<Cat> queryCats(String query);
	
	
	/**
	 * 保存
	 * @param cat
	 * @return
	 */
	Uri store(Cat cat);
	
}
