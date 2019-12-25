import java.util.*;

public class MathPractice {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		
	      
	    //addition
		int n1 = r.nextInt(100);
		int n2 = r.nextInt(100); 		
		System.out.print(n1 + " + " + n2 + " = ");
		int ans = in.nextInt();
		int add = n1 + n2;
		if(ans == add) System.out.println("Correct");
		else System.out.println("Incorrect");
	      
	     
	    //subtraction  
	    n1 = r.nextInt(100);
	    n2 = r.nextInt(100);
		System.out.print(n1 + " - " + n2 + " = ");
		ans = in.nextInt();
		int subtract = n1 - n2;	      
	    if(ans == subtract) System.out.println("Correct");
		else System.out.println("Incorrect");
	      
	    //multiplication
	    n1 = r.nextInt(10);
	    n2 = r.nextInt(10);
	    System.out.print(n1 + " x " + n2 + " = ");
	    ans = in.nextInt();
	    int multiply = n1 * n2;	      
	    if(ans == multiply) System.out.println("Correct");
	    else System.out.println("Incorrect");
	      
	    //division
	    n1 = r.nextInt(100);
	    n2 = r.nextInt(100);
	    System.out.print(n1 + " / " + n2 + " = ");
	    ans = in.nextInt();
	    int divide = n1 / n2;
	      
	    if(ans == divide) System.out.println("Correct");
	    else System.out.println("Incorrect");      
      
    }
}