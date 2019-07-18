package Section_1_2;
/*
ID: raychun2
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1 {
	
	static Scanner in;
	static PrintWriter out;
	static String result = "";

	// Input Variables	
	static LinkedHashMap<String, Integer> list;
	static int N;

	public static void main(String[] args) {
		
		try {			
			in = new Scanner(new File("gift1.in"));
			out = new PrintWriter(new File("gift1.out"));
			
			init();
			out.print(solve());
			
			in.close();
			out.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	private static void init() {
		
		N = Integer.parseInt(in.nextLine());
		list = new LinkedHashMap<String, Integer>();
		for(int i = 0; i < N; i++) {
			list.put(in.nextLine(), 0);
		}		
	}

	private static String solve() {
		
		for(int i = 0; i < N; i++) {
			String giver = in.nextLine();
			String [] temp = in.nextLine().split(" ");
			int totalMoney = Integer.parseInt(temp[0]);
			int numbPeop = Integer.parseInt(temp[1]);
			
			if(numbPeop == 0) continue; 
			
			int money = totalMoney / numbPeop;
			int left = totalMoney - (money * numbPeop);
			
			list.put(giver, list.get(giver)-totalMoney + left);
			
			for(int j = 0; j < numbPeop; j++) {
				String receiver = in.nextLine();
				list.put(receiver, list.get(receiver)+money);
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		for(String s: list.keySet()) {
			sb.append(s).append(" ").append(list.get(s)).append("\n");
		}
		
		return sb.toString();
		
		
	}
}