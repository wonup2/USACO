
public class PrintFormat1 {

	public static void main(String[] args) {

		double d = 123.456789;		
		System.out.printf("The number is %f\n", d);  //123.456789
		System.out.printf("The number is %.2f\n", d); //123.46		
		
		d=123.5;
		System.out.printf("The number is %.2f\n", d); //123.50

		
		d=1.3;
		System.out.printf("The number is %5.2f\n", d); //1.30
		System.out.printf("The number is %5.1f\n", d); //01.30




	}

}
