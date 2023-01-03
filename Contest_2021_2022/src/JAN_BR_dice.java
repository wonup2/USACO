import java.util.*;

public class JAN_BR_dice {
	
	static Scanner in;
	static int a[], b[], c[], t;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		t = in.nextInt();
		a = new int[4];
		b = new int[4];
		c = new int[4];
	
	    for (int test = 0; test < t; test++){
	    	
	    	boolean AB = false, BC_CA = false;
	    	
	        for (int i = 0; i < 4; i++) a[i] = in.nextInt();
	        for (int i = 0; i < 4; i++)	b[i] = in.nextInt();
	          
	        //A beats B
	        int ab = beats(a, b);  
	        
	        if (ab == 0) {
	        	System.out.println("no");
	        	continue;
	        }
	        else if (ab < 0) {
	            int[] temp = a.clone();
	            a = b.clone();
	            b = temp.clone();	            
	        }	     
	        
	        AB = true;
	        
	        
	        //B beats C and C beats A
	        for (c[0] = 1; c[0] <= 10; c[0]++)
	            for (c[1] = 1; c[1] <= 10; c[1]++)
	                for (c[2] = 1; c[2] <= 10; c[2]++)
	                    for (c[3] = 1; c[3] <= 10; c[3]++)
	                        if (beats(c, a) > 0 && beats(b, c) > 0) BC_CA = true;
	                   
	        
	        //output
	        if (AB && BC_CA)
	            System.out.println("yes");
	        else
	        	System.out.println("no");	    
	   }
	}
	
	static int beats(int a[], int b[]){		
	    int wins = 0, lose = 0;	    
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++){
	            wins += a[i] > b[j]? 1:0;
	            lose += a[i] < b[j]? 1:0;
	        }
	    }  
	    return wins-lose;
	}
}
