
public class SringPractice {

	public static void main(String[] args) {
	
		String result = removeAll("Summer is here!", 'e');
		System.out.println("removeAll : "+result);

		result = reverseChunks("MehranSahami", 3);
		System.out.println("reverseChunks : "+result);
		
		
	}

	public static String reverseChunks(String s, int n) {
	    String r = "";
	    while(s.length()>=n){
	        String temp = s.substring(0,n);
		    r+=reverse(temp);
		    s=s.substring(n);
		}
		r += s;
		return r;
	}

	public static String reverse(String s){
		String res = "";
		for(int i=s.length()-1; i>=0; i--)
		    res+=s.charAt(i);
		return res;
	}
	
	
	
	
	public static String removeAll(String str, char ch) {
		String result = "";
	    for(int i=0; i<str.length(); i++){
	        if(str.charAt(i)!=ch) result+=str.charAt(i);
	    }
	    
	    return result;
	}
	
}
