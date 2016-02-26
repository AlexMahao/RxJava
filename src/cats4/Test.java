package cats4;

public class Test {
	public static void main(String[] args) {
		CastsHelp castsHelp = new CastsHelp();
		castsHelp.saveTheCutestCat("ss").start(new Callback<Uri>() {
			
			@Override
			public void onResult(Uri result) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
