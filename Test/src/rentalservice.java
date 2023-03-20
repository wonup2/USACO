import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class rentalservice {
    static Scanner in;
	static PrintWriter out;
    static int n, m, r;
    static int cow[], farm[];
    static long maxmilk, maxprofit, curprofit, maxstoreprofit, gallonssold, milk;
    static pair store[];

    static class pair implements Comparable<pair>{
		long maxgallon, centpergallon;
		
		pair(long one, long two) {
			maxgallon = one;
			centpergallon = two;
		}		

		public String toString() {
			return maxgallon+" "+centpergallon;
		}
		@Override
		public int compareTo(rentalservice.pair o) {
			
			if (this.centpergallon > o.centpergallon) return -1;
			else if (this.centpergallon == o.centpergallon) {
				if (this.maxgallon > o.maxgallon) return -1;
				else return 1;
			}
			else return 1;
		}		
	}

    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("rental.in"));
        out = new PrintWriter(new File("rental.out"));
        
        n = in.nextInt();
        m = in.nextInt();
        r = in.nextInt();

        init();
        solve();

        in.close();
        out.close();
	}


    public static void init() {
        milk = 0l;
        cow = new int[n];
        for (int i=0; i<n; i++) {
            cow[i] = in.nextInt();
            maxmilk+=(long)cow[i];
        }
        Arrays.sort(cow);

        gallonssold = 0;
        store = new pair[m];
        for (int i=0; i<m; i++) {
            store[i] = new pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(store);

        farm = new int[r];
        for (int i=0; i<r; i++) {
            farm[i] = in.nextInt();
        }
        Arrays.sort(farm);
        
        System.out.println(Arrays.toString(cow));
        System.out.println(Arrays.toString(store));
        System.out.println(Arrays.toString(farm));

    }

    public static void solve() {
        maxprofit = 0;
        curprofit = 0;
        maxstoreprofit = 0;
        int milksold = 0;
        for (pair p : store) {
            if (p.maxgallon + milksold <= maxmilk) {
                maxstoreprofit += p.maxgallon * p.centpergallon;
                milksold += p.maxgallon;
            }
            else {
                maxstoreprofit += (maxmilk-milksold) * p.centpergallon;
                break;
            }
        }
        maxprofit = maxstoreprofit;

        curprofit = 0;
        // function to determine max from all possible patterns of renting to farms
        
        out.println(maxprofit);
    }
}