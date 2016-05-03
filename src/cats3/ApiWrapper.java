package cats3;

import java.util.List;

/**
 * 接口的包装类 备注人： Alex_MaHao
 * 
 * @date 创建时间：2016年2月26日 上午10:11:28
 */
public class ApiWrapper {
	Api api;

	public AsyncJob<List<Cat>> queryCats(final String query) {
		return new AsyncJob<List<Cat>>() {

			@Override
			public void start(final Callback<List<Cat>> callback) {
				api.queryCats(query, new Callback<List<Cat>>() {

					@Override
					public void onResult(List<Cat> result) {
						callback.onResult(result);
						
					}

					@Override
					public void onError(Exception e) {
						callback.onError(e);
						
					}
				});
			}
		};

	}
	
/*
	public static void main(String[] args) {
		//调用方法，返回包含我们回调信息的asyncJob类
		AsyncJob<List<Cat>> async = new ApiWrapper().queryCats("url");
		
		//启动回调方法，获取回调结果
		async.start(new Callback<List<Cat>>() {
			
			@Override
			public void onResult(List<Cat> result) {
				//所有猫的集合
			}
			
			@Override
			public void onError(Exception e) {
				//错误回调
			}
		});
	}*/
	
	
	public AsyncJob<Uri> store(final Cat cat) {
		return new AsyncJob<Uri>() {

			@Override
			public void start(final Callback<Uri> callback) {
				api.store(cat, new Callback<Uri>() {

					@Override
					public void onResult(Uri result) {
						callback.onResult(result);
					}

					@Override
					public void onError(Exception e) {
						callback.onError(e);
					}
				});
			}

		};
	}

}
