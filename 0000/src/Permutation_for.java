import java.util.*;

public class Permutation_for {

	static ArrayList<String> p;
	public static void main(String[] args) {
	
		p = new ArrayList<String>();
		permutation();	
										
	}
	
	static void permutation() {
		for(int i = 1; i <= 4; i++) {			
			for(int j = 1; j <= 4; j++) {				
				if(j == i) continue;					
				for(int k = 1; k <= 4; k++) {					
					if(k == i || k == j) continue;						
					for(int l = 1; l <= 4; l++) {						
						if(l == i || l == j || l == k) continue;							
							p.add("" + i + j + k + l);						
					}
				}
			}
		}	
	}
}

