package text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {

	public static void main(String[] args) {
		getMD();
	}

	/**
	 * 获得月,天
	 */
	static void getMD() {
		
		SimpleDateFormat  sim = new  SimpleDateFormat("yyyyMMddhhmmss");
		
		Date date = null;
		try {
			date = sim.parse("20161129095518");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(date.toString());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +1);
		
		System.out.println(calendar.get(Calendar.MONTH));
		
		System.out.println( sim.format(calendar.getTime()) );
		
		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, 1);
		System.out.println(now.getTime()); 
		
	}
}
