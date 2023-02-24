import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	static ArrayList<String> p;
	static int mask[];
	public static void main(String[] a) {		
		p=new ArrayList<String>();
		//permute("123", "");
		
		System.out.println(p);	
		mask = new int[5];
		permutation(0);
		System.out.println(Arrays.toString(mask));
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