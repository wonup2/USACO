import java.util.*;
import java.io.*;
public class GridFit_solomon {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static boolean[][]a = new boolean[5][5];
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("gridfit.in"));
		out = new PrintWriter(new File("gridfit.out"));
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt();
		int temp;
		for(int i = 0; i < n; i++) {
			temp = in.nextInt();
			if(temp <= 5) {
				a[4][temp - 1] = true;
				continue;
			}
			if(temp <= 10) {
				a[3][temp - 6] = true;
				continue;
			}
			if(temp <= 15) {
				a[2][temp - 11] = true;
				continue;
			}
			if(temp <= 20) {
				a[1][temp - 16] = true;
				continue;
			}
			if(temp <= 25) {
				a[0][temp - 21] = true;
				continue;
			}
		}
	}
	static void solve() {
		int temp;
		for(int i = 0; i < 5; i++) {
			temp = in.nextInt();
			if(temp == 1) {
				one();
				continue;
			}
			if(temp == 2) {
				two();
				continue;
			}
			if(temp == 3) {
				three();
				continue;
			}
			if(temp == 4) {
				four();
				continue;
			}
			if(temp == 5) {
				five();
				continue;
			}
		}
		out.close();
		in.close();
	}
	
	static void one() {
		search: {
			for(int i = 4; i >= 0; i--) {
				for(int j = 0; j <= 4; j++) {
					if(a[i][j] == false) {
						a[i][j] = true;
						out.println(value(i, j));
						break search;
					}
				}
			}
		}
	}
	
	static void two() {
		search: {
			for(int i = 4; i >= 1; i--) {
				for(int j = 0; j <= 4; j++) {
					if(a[i][j] == false && a[i - 1][j] == false) {
						a[i][j] = true;
						a[i - 1][j] = true;
						out.println(value(i, j));
						break search;
					}
				}
			}
		}
	}
	
	static void three() {
		search: {
			for(int j = 0; j <= 3; j++) {
				for(int i = 4; i >= 0; i--) {
					if(a[i][j] == false && a[i][j + 1] == false) {
						a[i][j] = true;
						a[i][j + 1] = true;
						out.println(value(i, j));
						break search;
					}
				}
				if(j == 3)
					out.println("NONE");
			}
		}
	}
	
	static void four() {
		search: {
			for(int i = 4; i >= 1; i--) {
				for(int j = 0; j <= 3; j++) {
					if(a[i][j] == false && a[i - 1][j] == false && a[i - 1][j + 1] == false) {
						a[i][j] = true;
						a[i - 1][j] = true;
						a[i - 1][j + 1] = true;
						out.println(value(i, j));
						break search;
					}
				}
				if(i == 1)
					out.println("NONE");
			}
		}
	}
	
	static void five() {
		search: {
			for(int i = 4; i >= 1; i--) {
				for(int j = 0; j <= 3; j++) {
					if(a[i][j] == false && a[i - 1][j] == false && a[i][j + 1] == false) {
						a[i][j] = true;
						a[i - 1][j] = true;
						a[i][j + 1] = true;
						out.println(value(i, j));
						break search;
					}
				}
				if(i == 1)
					out.println("NONE");
			}
		}
	}
	
	static int value(int i, int j) {
		if(i == 4) {
			return j + 1;
		}
		if(i == 3) {
			return j + 6;
		}
		if(i == 2) {
			return j + 11;
		}
		if(i == 1) {
			return j + 16;
		}
		else {
			return j + 21;
		}
	}
}
