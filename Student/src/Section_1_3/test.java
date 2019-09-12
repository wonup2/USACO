package Section_1_3;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		LocalDate brian = LocalDate.of(2018, Month.APRIL, 10);
		System.out.println(brian.getYear() + " " + brian.getMonth() + " "+ brian.getDayOfMonth());
				
		LocalDate brandon = LocalDate.of(2018, Calendar.APRIL, 10);
		System.out.println(brandon.getYear() + " " + brandon.getMonth() + " "+ brandon.getDayOfMonth());



	}

}
