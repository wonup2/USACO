import java.util.*;

public class PrintFormat {

	public static void main(String[] args) {
		
		double d =123.456789;
		System.out.printf("the number is %f\n",d);//123.456789
		
		System.out.printf("the number is %.2f\n", d);//123.46
		
		d=123.5;
				
		System.out.printf("the number is %.2f\n", d);//123.50
		
		d=1.3689;
		System.out.printf("the number is %.2f\n",d);//1.30
		
		System.out.printf("the number is %05.1f\n",d );  //  1.4
		
		int h = 3;
		int m = 5;
		//03:45
		System.out.printf("%02d:%02d\n", h, m);
		
	}

}