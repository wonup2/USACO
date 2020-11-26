import java.util.*;
import java.io.*;
public class US_SIL_moop {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("moop.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		boolean[] done = new boolean[n];
		particle[] p = new particle[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			p[i] = new particle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p);
		for(int i = 0; i < n; i++) {
			if(done[i] == true) {
				continue;
			}
			boolean found = false;
			for(int j = i+1; j < n; j++) {
				if(p[j].y == p[i].y) {
					done[j] = true;
				}else {
					if(p[j].x < p[i].x) {
						found = true;
					}else {
						if(found) {
							done[i] = true;
							break;
						}else{
							done[j] = true;
						}
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(done[i]== false) {
				ans++;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class particle implements Comparable<particle>{
		int x;
		int y;
		public particle (int X, int Y) {
			x = X;
			y = Y;
		}
		public int compareTo(particle m) {
			if(this.y > m.y) {
				return 1;
			}
			else if(this.y == m.y) {
				if(this.x > m.x) {
					return 1;
				}else {
					return -1;
				}
			}
			return-1;
		}
	}
}
