import java.util.*;

public class lineup {

	static ArrayList<String> p;
	public static void main(String[] args) {

		init();
	}

	static void init() {
		
		p= new ArrayList<String>();
		permutation("");
		
		//System.out.println(p);
		
	}
	
	static void permutation(String s) {
		
		if(s.length()==8) {
			p.add(s);
			return;
		}
		
		for(int i=1; i<=8; i++)
			if(!s.contains(i+"")) permutation(s+i);
		
		
	}
}
