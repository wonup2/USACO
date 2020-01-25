import java.util.*;
public class Map_Practice2 {

	public static void main(String[] args) {

		int[] a = {27, 15, 15, 11, 27};
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	    
	    for(int i=0 ; i<a.length; i++){
	        
	        if(m.containsKey(a[i])) 
	        	m.put(a[i], m.get(a[i])+1);
	        else m.put(a[i], 1);
	    }
	                     
	    //find maximum value
	    int max = 0;
	    for(int key:m.keySet()) {
	    	max = Math.max(max, m.get(key));
	    }
	    
	    //find the minimum key which has "2"
	    int min = Integer.MAX_VALUE;
	    for(int key:m.keySet()) {
	    	if(m.get(key)==max) {
	    		min=Math.min(min, key);
	    	}
	    }
	    
	}
}
