import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import rx.Observable;
import rx.functions.Action1;

public class Test {

	public static void main(String[] args) {
		
		Observable.timer(10, TimeUnit.SECONDS)
			.subscribe(new Action1<Long>() {

				@Override
				public void call(Long arg0) {
					// TODO Auto-generated method stub
					System.out.println(arg0);
				}
			});
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String string2Int(String str) {
		BigDecimal bigDecimal = new BigDecimal(str);
		str = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		//Logger.e(str);
		if (str.contains(".")) {
			if (Pattern.matches(".*(\\.)0+", str)) {
				return "0";
			}
			DecimalFormat df = new DecimalFormat("0.00");

			return df.format(Double.parseDouble(str));
		}

		return str;
	}

	
	public static double add(int year){
		double s = 10000;

		// 利息
		double lixi = s * 0.15 / 12;
		
		double num = 0;
		for (int i = 1; i <= year; i++) {
			for (int m = 1; m <= year*12; m++) {
				
				num = num + ( lixi * ((year*12-m)/ 4)) * 0.13 / 12;
				if(m==12){
					s = s + num+s*0.15;
				}
			}
			s = s + num+s*0.15;
			lixi = s*0.15/12;
			
		}
		return s;
	}
}
