import java.util.*;
import java.io.*;
public class digitadd {
	static Scanner in;
	static PrintWriter out;
	static int[] num;
	static ArrayList<Integer> ans;
	static int[][] combo;
	public static void main(String[] args) {
		try {
			init();
			solve();
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		try {
			in = new Scanner(new File("photo.in"));
			out = new PrintWriter(new File("photo.out"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		String[] temp = in.nextLine().split(" ");
		num = new int[temp.length];
		for(int i = 0; i < temp.length; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		
		ans = new ArrayList<Integer> ();
		
		combo = new int[5][2];   // <-------------------이게 꼭 5 일 수는 없지.
		                         // if num[0] is 4  ---> combo is 1-3, 3-1
								 // so TreeMap 은 어떨까???
				
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				if(i + j == num[0]) {   //  <--------- 이렇게 하면 2 and 2 도 들어간다.
					combo[i][j] = i;
					combo[i][j+1] = j;
				}
			}
		}
	}
	public static void solve() {
		for(int i = 1; i < 4; i++) {
			if(num[i]-combo[i-1][i-1] <= 0 && num[i]-combo[i-1][i] <= 0) {
				break;
			}else if(num[i]-combo[i-1][i-1] <= 0) {
				ans.add(combo[i-1][i-1]);
				ans.add(combo[i-1][i]);
			}else if(num[i]-combo[i-1][i] <= 0) {
				ans.add(combo[i-1][i]);
				ans.add(combo[i-1][i-1]);
			}
			for(int j = 1; j < 4; j++) {
				if(num[i]-combo[i-1][i-1] <= 0 && num[i]-combo[i-1][i] <= 0) {
					break;
				}else if(num[i]-combo[i-1][i-1] <= 0) {
					ans.add(combo[i-1][i-1]);
					ans.add(combo[i-1][i]);
				}else if(num[i]-combo[i-1][i] <= 0) {
					ans.add(combo[i-1][i]);
					ans.add(combo[i-1][i-1]);
				}
				for(int k = 1; k < 4; k++) {
					if(num[i]-combo[i-1][i-1] <= 0 && num[i]-combo[i-1][i] <= 0) {
						break;
					}else if(num[i]-combo[i-1][i-1] <= 0) {
						ans.add(combo[i-1][i-1]);
						ans.add(combo[i-1][i]);
					}else if(num[i]-combo[i-1][i] <= 0) {
						ans.add(combo[i-1][i]);
						ans.add(combo[i-1][i-1]);
					}
					for(int l = 1; l < 4; l++) {
						if(num[i]-combo[i-1][i-1] <= 0 && num[i]-combo[i-1][i] <= 0) {
							break;
						}else if(num[i]-combo[i-1][i-1] <= 0) {
							ans.add(combo[i-1][i-1]);
							ans.add(combo[i-1][i]);
						}else if(num[i]-combo[i-1][i] <= 0) {
							ans.add(combo[i-1][i]);
							ans.add(combo[i-1][i-1]);
						}
					}
				}
			}
		}
		out.println(ans);
	}		
}
