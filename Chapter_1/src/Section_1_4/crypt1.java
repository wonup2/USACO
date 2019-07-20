package Section_1_4;
/*
ID: wonup21
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;

public class crypt1 {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static ArrayList<Integer> a;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("crypt1.in"));
			out = new PrintWriter(new File("crypt1.out"));
			init();
			out.println(solve());	
			in.close();
			out.close();		
		} 
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static void init(){
		n=in.nextInt();
		a=new ArrayList<Integer>();
		int i=n;
		while(i-->0) a.add(in.nextInt());
	}
	
	static int solve() {
		int x[] = new int[n*n*n];
		int y[] = new int[n*n];
		
		int index=0;		
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)for(int k=0;k<n;k++) {
			x[index]=a.get(i)*100+a.get(j)*10+a.get(k);
			if(i==0) y[index]=a.get(j)*10+a.get(k);
			index++;
		}

		int count=0;
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<y.length; j++) {
				int p1=x[i]*(y[j]%10);
				int p2=x[i]*(y[j]/10);
				int p3=p1+p2*10;
				
				if((p1+"").length()!=3||(p2+"").length()!=3||(p3+"").length()!=4) continue;
				
				if(isValid(p1)&&isValid(p2)&&isValid(p3)) count++;
			}
		}
		
		return count;
	}

	static boolean isValid(int n) {	
		while(n>0) {
			int temp = n%10;
			if(!a.contains(temp)) return false;
			n/=10;
		}
		return true;
	}
}
