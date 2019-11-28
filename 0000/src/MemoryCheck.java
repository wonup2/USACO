import java.util.*;

public class MemoryCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Long>a=new ArrayList<Long>();
		long num = 3;
		a.add(num);
		while(num <= 1000000000000000000L) {
			num *=2;
			a.add(num);
		}
		List al = new ArrayList(); 
        al.add(1); 
        al.add(2); 
        al.add(3); 
        al.add(10); 
        al.add(20); 
  
        // 10 is present at index 3. 
        int index = Collections.binarySearch(a, 49l); 
        System.out.println(index); 

		System.out.println(a);
	}
}
