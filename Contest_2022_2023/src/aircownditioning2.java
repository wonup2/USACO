import java.util.Scanner;

public class aircownditioning2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] stalls = new int[100];
		int[][] ac = new int[10][4];
		
		for (int i=0; i<n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int req = in.nextInt();
			
			for (int j=start-1; j<end; j++) {
				stalls[j] = stalls[j] + req;
			}
		}
		
		for (int i=0; i<m; i++) {
			ac[i][0] = in.nextInt();  //start
			ac[i][1] = in.nextInt(); //end
			ac[i][2] = in.nextInt(); //power
			ac[i][3] = in.nextInt(); //cost
		}
		
		
		int mincost = Integer.MAX_VALUE;
		int[] a = new int[100];
		
		for (int i=0; i<Math.pow(2, m); i++) {
			
			String onoff = Integer.toBinaryString(i);
			while (onoff.length()<m) {
				onoff = "0"+onoff;
			}

			for (int j=0; j<100; j++) {
				a[j] = stalls[j];
			}

			int currentcost = 0;
			for (int j=0; j<m; j++) {
				if(onoff.charAt(j)=='1') {
					for (int k=ac[j][0]-1; k<ac[j][1]; k++) {
						a[k] = a[k] - ac[j][2];
					}
					currentcost+=ac[j][3]; 
				}
			}
			
			boolean comfortable = true;
			
			for (int j=0; j<100; j++) {
				if (a[j] > 0) {
					comfortable = false;
					break;
				}
			}
			
			if (comfortable && (currentcost < mincost)) {
				mincost = currentcost;
			}
		}
		System.out.println(mincost);
		in.close();
	}
}