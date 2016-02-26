package catsend.rxjava;

import rx.Observer;

/**
 * RxJava实现
 * 备注人： Alex_MaHao
 * @date 创建时间：2016年2月26日 下午2:37:28
 */
public class Test {
	public static void main(String[] args) {
		CastsHelp castsHelp = new CastsHelp();
		castsHelp.saveTheCutestCat("ss").subscribe(new Observer<Uri>() {

			@Override
			public void onCompleted() {
				
			}

			@Override
			public void onError(Throwable arg0) {
				
			}

			@Override
			public void onNext(Uri arg0) {
				
			}
		});
	}
}
