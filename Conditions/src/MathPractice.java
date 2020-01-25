import java.util.*;

public class MathPractice {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random r = new Random();

		
		System.out.print("Input practice time: ");
		int n = in.nextInt();
		
		int correct = 0;
		
		for(int i=0; i<n; i++) {
			
			//Question			
			int x = r.nextInt(100);
			int y = r.nextInt(100);
			
			int com = 0;			
			int type = r.nextInt(3);
			
			System.out.print("Q"+(i+1) + ") ");	
			
			if(type ==0) com = add(x,y);
			else if (type==1) com = sub(x,y);
			else com = mult(x,y);				
							
			int ans = in.nextInt();
			
			//display answer
			if(ans == com) {
				System.out.println("    Correct");
				correct++;
			}
			else{
				System.out.println("    Incorrect. Answer is " + com);
			}					
		}
		
		//report card
		System.out.println("Score------------------------------");
		System.out.println("Correct : " + correct + "\tIncorrect: " + (n-correct));
		double score = correct / (n*1.0) * 100;
		System.out.println("Score is " + score + "%");
		
	}
		
	static int add(int a, int b) {
		System.out.print(a + " + " + b + " = ");
		return a+b;
	}
	
	static int sub(int a, int b) {
		System.out.print(a + " - " + b + " = ");
		return a-b;
	}
	
	static int mult(int a, int b) {
		System.out.print(a + " x " + b + " = ");
		return a*b;
	}
	
}















