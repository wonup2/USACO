import java.util.*;

public class MakePermutation {

	static ArrayList<String> p;
	
	public static void main(String[] args) {

		p=new ArrayList<String>();
		
		permut("1234", "");
		
		System.out.println(p);
		System.out.println(p.size());
	}

	
	static void permut(String l, String r) {
		
		if(l.length()==0) {
			p.add(r);
			return;
		}
		
		for(int i=0; i<l.length(); i++) {
			
			char c = l.charAt(i);
			String s1 = l.substring(0,i) + l.substring(i+1);
			String s2 = r+c;
			
			permut(s1,s2);
		}		
	}
}
