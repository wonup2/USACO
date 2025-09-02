//package Contest2018_2019;
import java.util.*;
import java.io.*;

public class evolution {
	static Scanner in;
	static PrintWriter out;
	static ArrayList<String[]> sub;
	static int n;
	static ArrayList<String> traits;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("evolution.in"));
		out = new PrintWriter(new File("evolution.out"));
		init();
		System.out.println(solve());
		in.close();
		out.close();
	}
	public static void init() {
		n = in.nextInt();
		sub = new ArrayList<String[]>();
		for(int j = 0; j < n; j++) {
			int num = in.nextInt();
			String[] temp = new String[num];
			for(int i = 0; i < num; i++) {
				temp[i] = in.next();
			}
			sub.add(temp);
		}
//		for(int j = 0; j < sub.size(); j++) {
//			System.out.println(Arrays.toString(sub.get(j)));
//		}
		traits = new ArrayList<String>();
		for(int j = 0; j < n; j++) {
			String[] curr = sub.get(j);
			for(int i = 0; i < curr.length; i++) {
				if(!traits.contains(curr[i]))traits.add(curr[i]);
			}
		}
		//System.out.println(traits);
	}
	public static String solve() {
		for(int j = 0; j < traits.size(); j++) {
			for(int i = j+1; i < traits.size(); i++) {				
				boolean ab = false;boolean a = false; boolean b = false;
				for(int t = 0; t < n; t++) {
					String curr = Arrays.toString(sub.get(t)); 
					if(curr.contains(traits.get(j)) && curr.contains(traits.get(i)))  ab = true;
					else if(curr.contains(traits.get(j))) a = true;
					else if(curr.contains(traits.get(i))) b = true;
				}
				if(ab && a && b)return "no";
			}
		}
		return "yes";
	}
}
