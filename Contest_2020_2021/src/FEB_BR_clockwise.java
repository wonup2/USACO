import java.util.Scanner;
 
public class FEB_BR_clockwise  {
    static Scanner in;
    static int n;
    static String s;
    public static void main(String[] args) {
    	
        in = new Scanner(System.in);
    	n = in.nextInt(); in.nextLine(); 
    	
    	for(int i=0; i<n; i++) {
    		s = in.nextLine();
    		int cw = 0;
    		int ccw = 0;
    		
    		for(int j=0; j<s.length()-1; j++) {
    			
    			String sub = s.substring(j, j+2);
    			
    			if(sub.equals("NW") || sub.equals("SE") || sub.equals("EN") || sub.equals("WS")) ccw++;
    			else if(sub.equals("NE") || sub.equals("SW") || sub.equals("ES") || sub.equals("WN")) cw++;
    			
    		}
    		System.out.println(ccw+" "+cw);
    		
    		if(cw > ccw) System.out.println("CW");
    		else System.out.println("CCW");
    	}
    }
}

/*
2
NESW
WSSSEENWNEESSENNNNWWWS

*/