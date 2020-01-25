import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] d = new int[5];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		int index=0;
		for(int i = 3; i <=10; i++) {
			d[3] = d[2] + d[1] + d[0];
			System.out.println(i+" "+d[3]);
			d[0]=d[1];
			d[1]=d[2];
			d[2]=d[3];
		}
		
		System.out.println(Arrays.toString(d));
		
		int t = in.nextInt();
		while(t-- >0){
			int n = in.nextInt();
			System.out.println(d[n]);
		}
	}
}

//[1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274]