package _2001_2002;
import java.util.*;
import java.io.*;

public class C1_JR_Code {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("test.in"));
		
		for(int i=1; i<=5; i++) {
			//input
			char input = in.next().charAt(0);
			//processing
			int n = input - 64;
			
			if(1<=n && n<=5) {
				n = n*2;
			}
			else if(6<=n && n<=10) {
				n = n % 3  *5;
			}
			else if(11<=n && n<=15) {
				int b = n / 4;
				n = b * 8;
			}
			else if(16<=n && n<=20) {
				int d=n%10;
				int c=n/10;
				n= (c+d) * 10;
			}
			else {
				for(int t=n/2; t>=1; t--) {
					if(n % t == 0){
                    	n = t;
                        break;
                    }
                  
                }
				n= n * 12;			
			}
			//output
			n=n%26;
			if(n==0){
				n=26;
			}
			n= n + 64;
			System.out.println((char)n);
		}
	}
}
      
      
      
      
      
      
/*
A
B
C
D
E

*/
	
