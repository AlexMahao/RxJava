package cats5;

public class Test {
	public static void main(String[] args) {
		CastsHelp castsHelp = new CastsHelp();
		castsHelp.saveTheCutestCat("ss").start(new Callback<Uri>() {
			
			@Override
			public void onResult(Uri result) {
				//Uri 地址对象
			}
			
			@Override
			public void onError(Exception e) {
				//异常
			}
		});
	}
}
