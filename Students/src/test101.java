import java.util.ArrayList;

public class test101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "hello";		
		StringBuilder sb = new StringBuilder("hello");
		
		s = s + " world";
		sb.append(" world");
		
		System.out.println(s);
		System.out.println(sb);
		
		
		s = s.substring(3);
		sb.delete(0, 3);
		
		System.out.println(s);
		System.out.println(sb);
		
		System.out.println(sb.substring(3));
		System.out.println(sb);
		
	}

}
