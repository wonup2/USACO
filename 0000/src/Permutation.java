import java.util.ArrayList;

public class Permutation {
	static ArrayList<String> p;
	
	public static void main(String[] a) {		
		p=new ArrayList<String>();
		//permute("123", "");
		permutation("");
		System.out.println(p);	
		
		
	}
	
	static void permute(String left, String right) {
	    if(left.length() == 0) {
	    	p.add(right); 
	    	return;
	    }
	    for(int i = 0; i < left.length(); i++) {
	    	char c = left.charAt(i);
	    	String l = left.substring(0, i) + left.substring(i + 1);
	    	String r = right + c;
	    	permute(l, r); 
	    }
	}
	
	static void permutation(String s) {
		if(s.length()==8) {
			p.add(s); 		
		}
		
		for(int i=0; i<8; i++) {			
			if(!s.contains(i+"")) permutation(s+i);
		}
	}
}