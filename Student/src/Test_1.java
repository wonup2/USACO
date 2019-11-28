import java.util.*;
import java.io.*;

public class Test_1 {

	static Scanner in;
	static int[] a;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("Test_1.in"));
		
		for(int i=0; i<4; i++) {
			try {
				init(); 
				System.out.println(Arrays.toString(a));
			}catch(Exception e) {
				System.out.println(e);in.nextLine();
			}
		}

	}

	static void init() {
		a = new int[3];
		for(int i=0; i<3; i++)
			a[i] = in.nextInt();		
	}
}
