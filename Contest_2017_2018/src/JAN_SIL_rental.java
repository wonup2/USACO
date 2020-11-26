import java.io.*;
import java.util.*;
public class JAN_SIL_rental {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] cow = new int[n];
		for(int i = 0; i < n; i++) {
			cow[i] = Integer.parseInt(br.readLine());
		}
		sort(cow);   //System.out.println("milkProduced "+ Arrays.toString(milkProduced));  //
		
		Shop[] mart = new Shop[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			mart[i] = new Shop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(mart); //System.out.println("shops "+ Arrays.toString(shops));  //
		int[] rental = new int[r];
		for(int i = 0; i <r; i++) {
			rental[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rental);
		
		int[] milking = new int[n];
		long[] maxProfit = new long[n];
		int index = 0;
		
		
		for(int i = 0; i < n; i++) {
			
			while(index < m && cow[i] > 0) {
				
				int gal = Math.min(cow[i], mart[index].quantity);
				maxProfit[i] += gal * (long)mart[index].price;
				
				cow[i] -= gal;
				mart[index].quantity -= gal;
				
				if(mart[index].quantity == 0) index++;		
				
			}
		}				
		
		
		sort(maxProfit);
		
		for(int i = n-1, j = r-1; i >=0 && j >=0; i--, j--) {
			maxProfit[i] = Math.max(maxProfit[i], rental[j]);
		}
		
		long total = 0;
		for(int i = 0; i<n; i++) {
			total += maxProfit[i];
		}

		pw.println(total);
		pw.close();
	}

	public static void sort(int[] l) {
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) {
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}
	public static void sort(long[] l) {
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) {
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}
	static class Shop implements Comparable<Shop> {
		public int quantity, price;
		public Shop(int a, int b) {
			quantity=a;
			price=b;
		}
		public int compareTo(Shop s) {
			return s.price - price;
		}
		
		public String toString() {
			return quantity+":"+price;
		}
	}

}