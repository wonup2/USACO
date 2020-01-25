import java.util.*;
public class Test {
	public static void main(String[] args) {
		
		System.out.println(reverseWordOrder("Hello what is your name?"));
        

	}
	
	
	public static String reverseWordOrder(String s) {
		ArrayList<String> arr = new ArrayList<String>();
	    String temp = "";
	    for(int i = 0; i < s.length(); i++){
	        if((s.charAt(i)+"").equals(" ")){
	            arr.add(temp);
	            temp = "";
	            continue;
	        }
	        temp += s.charAt(i);
	    }
	    arr.add(temp);
	    String res = "";
	    for(int i = arr.size()-1; i >= 0; i--){
	        res += arr.get(i)+" ";
	    }
	    return res;
	}
	public static boolean isRotation(String a, String b){
	    StringBuilder sb = new StringBuilder(a);
	    StringBuilder[] array = new StringBuilder[a.length()];
	    char c;
	    if(a.equals(b))
	        return true;
	    for(int i = 0; i < a.length(); i++){
	        array[i] = sb; System.out.println(array[i]);
	        c = sb.toString().charAt(0);
	        sb.delete(0, 1);
	        sb.append("" + c);
	    }
	    
	    System.out.println(Arrays.toString(array));
	    for(StringBuilder x: array){
	    	System.out.println(x.toString());
	        if(x.toString().equals(b))
	            return true;
	    }
	    return false;
	}
}
