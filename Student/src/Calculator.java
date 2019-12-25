import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//input
		System.out.print("Input the first number: ");
		int v1 = in.nextInt();
		System.out.print("Input the second number: ");
		int v2 = in.nextInt();
		
		//processing
		int add = v1+v2;
		int sub = v1-v2;
		int mul = v1*v2;
		int div = v1/v2;
		
		//output
		System.out.println("-----------------------");
		System.out.println("Calculator");
		System.out.println("-----------------------");
		System.out.println("Number 1 :" + v1);
		System.out.println("Number 2 :" + v2);
		System.out.println("-----------------------");
		System.out.println(v1 + " + " + v2 + " = " + add);
		System.out.println(v1 + " - " + v2 + " = " + sub);
		System.out.println(v1 + " X " + v2 + " = " + mul);
		System.out.println(v1 + " / " + v2 + " = " + div);


	}

}
