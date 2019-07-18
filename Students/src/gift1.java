/*
ID: wonup22
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;
public class gift1 {

	public static void main(String[] args) throws IOException{

		Scanner in = new Scanner(new File("gift1.in"));
		PrintWriter out = new PrintWriter(new File("gift1.out"));
		ArrayList<String> n=new ArrayList<String>();
		ArrayList<Integer> m=new ArrayList<Integer>();
		
		int k=Integer.parseInt(in.nextLine());
		for(int i=0; i<k; i++) {
			n.add(in.nextLine());
			m.add(0);
		}
		
		for(int i=0; i<k; i++) {
			String giver=in.nextLine();
			int money=in.nextInt();
			int div = in.nextInt(); in.nextLine();
			if(div==0)continue;
			int gift=money/div;
			int rem=money%div;
			int index=n.indexOf(giver);
			m.set(index, m.get(index)-money+rem);
			for(int j=0; j<div; j++) {
				String p = in.nextLine();
				index=n.indexOf(p);
				m.set(index, m.get(index)+gift);
			}
		}
		
		for(int i=0; i<k; i++) {
			out.println(n.get(i)+" "+m.get(i));
		}	
		
		in.close();
		out.close();
	}
}
