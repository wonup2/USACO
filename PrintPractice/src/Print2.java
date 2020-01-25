
public class Print2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int j=0; j<4; j++) {	
			
			for(int i=0; i<5; i++) {
				System.out.print("*");
			}
		    System.out.println();		    
		}

		System.out.println();
/*		
		*
		**
		***
		****
		*****
*/
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
/*
		*****
		****
		***
		**
		*
 */
		
		for(int i=5; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
/*

		    *
		   **
		  ***
		 ****
		*****
 */

		for(int i=0; i<5; i++) {
			for(int k=4; k > i; k--) {
				System.out.print(" ");; 
			}
			for(int j=0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		
		
		
		
		
		
	}

}
