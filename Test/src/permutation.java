import java.util.*;
public class permutation {

	static ArrayList<String> p;
	
	public static void main(String[] args) {

		p = new ArrayList<String>();
		
		//permutation1();
		
		//permutation2("1234", "");
		permutation3("");
		System.out.println(p);
	}

	
	static void permutation3(String s) {
		
		if(s.length()==4) {
			p.add(s); return;
		}
		
		for(int i=1; i<=4; i++) {
			if(!s.contains(i+"")) permutation3(s+i);
		}
		
	}
	
	
	static void permutation2(String left, String right){
		
		if(right.length()==4) {
			p.add(right);
			return;
		}
		
		for(int i=0; i<left.length(); i++) {
			
			String r = right + left.charAt(i);
			
			String l = left.substring(0, i) + left.substring(i+1);			
			
			permutation2(l, r);
			
		}
		
	}
	
	
	
	static void permutation1() {
		
		for(int a = 1; a <= 4 ; a++) {
			
			for(int b = 1; b <=4 ; b++) {
				
				if(a==b) continue;
				
				for(int c = 1; c<= 4; c++) {
					
					if(c==a || c==b) continue;
					
					for(int d = 1; d<=4; d++) {
						
						if(d==a || d==b || d==c) continue;
						
						p.add(""+a+b+c+d);
					}					
					
				}				
				
			}	
		}
	}
	
}
