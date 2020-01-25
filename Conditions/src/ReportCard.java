import java.util.Scanner;

public class ReportCard {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//input
		System.out.print("Input Name: ");
		String name = in.nextLine();
		System.out.print("Input English Score: ");
		double eng = in.nextDouble();
		System.out.print("Input Math Score: ");
		double math = in.nextDouble();
		System.out.print("Input History Score: ");
		double his = in.nextDouble();
		System.out.print("Input Science Score: ");
		double sci = in.nextDouble();
		
		//process
		double sum = eng+math+his+sci;
		double ave = sum/4;
		char grad = 'F';
		
		if(ave >= 90) grad = 'A';
		else if(ave >= 80) grad = 'B';
		else if(ave >= 70) grad = 'C';
		else if(ave >= 60) grad = 'D';
		
		//output
		
		
		
		
		
		
	}

}
