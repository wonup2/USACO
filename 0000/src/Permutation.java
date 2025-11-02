import java.util.*;


public class Permutation {
	static HashSet<String> p;
	static int mask[];
	public static void main(String[] a) {		
		p=new HashSet<String>();

		permutation("");
		System.out.println(p.size());
		
		//mask = new int[5];
		//permutation(5);
		//System.out.println(Arrays.toString(mask));
	}
	
	static void permutation(String left, String right) {
	    if(left.length() == 0) {
	    	p.add(right); 
	    	return;
	    }
	    for(int i = 0; i < left.length(); i++) {
	    	char c = left.charAt(i);
	    	String l = left.substring(0, i) + left.substring(i + 1);
	    	String r = right + c;
	    	permutation(l, r); 
	    }
	}
	
	static void permutation(String s) {
		if(s.length()==5) {
			p.add(s); 		
		}
		
		for(int i=0; i<5; i++) {			
			if(!s.contains(i+"")) permutation(s+i);
		}
	}
	
	static void permutation(int num, int i) {
		
		int dec = (int)Math.pow(2, num);
		
		for(int k=0; k<dec; k++) {
    		
    		String bin = Integer.toBinaryString(k);
    		for(int j=bin.length(); j<num; j++) bin = "0"+bin;
    		
    		System.out.println(bin);

    	}
	}
	
 
	static void permutation(int i) {
		if (i >= 5) return;
	    mask[i] = 0;
	    permutation(i+1);

		mask[i] = 1;
		permutation(i+1);
	}
}