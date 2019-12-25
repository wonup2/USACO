import java.util.ArrayList;

public class Permutation {
	static ArrayList<String> p;
	
	public static void main(String[] a) {		
		p=new ArrayList<String>();
		permute("1234", "");
		System.out.println(p);		
	}
	
	private static void permute(String string, String result) {
	    if(string.length() == 0) {
	    	p.add(result);
	    	return;
	    }
	    for(int i = 0; i < string.length(); i++) {
	    	char c = string.charAt(i);
	    	String s = string.substring(0, i) + string.substring(i + 1);
	    	permute(s, result + c);
	    }
	}
}