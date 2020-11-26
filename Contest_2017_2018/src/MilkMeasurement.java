import java.io.*;
import java.util.*;

public class MilkMeasurement {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static triple[] a;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("measurement.in"));
		out = new PrintWriter(new File("measurement.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() {
		n = in.nextInt();
		a = new triple[n];
		for(int i =0; i<n; i++) {
			a[i] = new triple(in.nextInt(), conv(in.next()), Integer.parseInt(in.next()));
		}
	    Arrays.sort(a);
	}
 
	static void solve() {
		int[] amount = new int[3];
		for(int i =0; i<3; i++) amount[i] = 7;
		//System.out.println(Arrays.toString(amount));
		int max = 7;
		boolean[] x = new boolean[3];
		for(int p = 0; p<3; p++) {
			x[p] = true;
		}
		boolean[] y = new boolean[3];
		int count = 0;
		
		for(int i =0; i<n; i++) {
			max=0;
			amount[a[i].id]+=a[i].milk;

          	for(int j =0; j<3;j++) {
                max = Math.max(max, amount[j]);
			}

			for(int j =0; j<3;j++) {
				if(amount[j]==max) y[j]=true;
                else y[j] = false;
			}

          	if(!Arrays.equals(x, y))count++;
          	x = y.clone();
		}
		out.println(count);
		
	}
	static int conv(String id) {
		if(id.equals("Bessie"))return 0;
		else if(id.equals("Elsie")) return 1;
		else return 2;
	}
	static class triple implements Comparable<triple>{

        int day;
        int id;
        int milk;
        
        triple(int d, int i, int m){
            day = d;
            id = i;
            milk = m;
        }        
        
        @Override
        public int compareTo(triple that) {
            if(this.day>=that.day) return 1;
            else if(this.day<=that.day) return -1;
            else return 1;
        }    
        
        public String toString() {
            return day+" "+id+" " + milk;
        }
        
    }

}
