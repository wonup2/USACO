import java.util.*;

public class RPS {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random r = new Random();
		
		// 1. Rock   2. Paper   3. Scissors
		
		System.out.println("Rock Paper Scissors Game ");
		int com = r.nextInt(3) + 1;
		
		System.out.println("Input either of the following: 1. Rock, 2. Paper, 3. Scissors");
		int me = in.nextInt();

		String com_result="";
		if(com == 1) com_result = "Rock";
		else if(com == 2) com_result = "Paper";
		else com_result = "Scissors";
		
		String me_result="";
		if(me == 1) me_result = "Rock";
		else if(me == 2) me_result = "Paper";
		else me_result = "Scissors";
		
		System.out.println("Computer did " + com_result);
		System.out.println("You did " + me_result);

		//result
		if(com==me) System.out.println("Tie");
		else if(com==1 && me==2) System.out.println("You win!");
		else if(com==2 && me==3) System.out.println("You win!");
		else if(com==3 && me==1) System.out.println("You win!");
		else System.out.println("Computer win!");		
		
	}
}
