import java.util.*;
import java.io.*;
public class GridFit_Intermediate {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("GridFit_Int.in"));
		int n = in.nextInt();
		boolean[] a = new boolean[25];
		//Makes the arrays with initially filled spaces
		for(int i = 0; i < n; i++) {
			a[in.nextInt()-1] = true;
		}
		for(int x = 0; x < 5; x++) {
			int res = 0;
			int pattern = in.nextInt();
			if(pattern == 1) {
				for(int i = 0; i < 25; i++) {
					if(a[i] == false) {
						res = i+1;
						a[i] = true;
						break;
					}
				}
			}
			
			else if(pattern == 2) {
				for(int i = 0; i < 25; i++) {
					if(i > 4 && a[i] == false && a[i-5] == false) {
						res = i-5+1;
						a[i] = true;
						a[i-5] = true;
						break;
					}
				}
			}
			
			else if(pattern == 3) {
				for(int i = 0; i < 25; i++) {
					if(i % 5 != 4 && a[i] == false && a[i+1] == false) {
						res = i + 1;
						a[i] = true;
						a[i+1] = true;
						break;
					}
				}
			}
			
			else if(pattern == 4) {
				for(int i = 0; i < 25; i++) {
					if(i > 4 && i % 5 != 4 && a[i] == false && a[i-5] == false && a[i+1] == false) {
						res = i-5+1;
						a[i] = true;
						a[i-5] = true;
						a[i+1] = true;
						break;
					}
				}
			}
			
			else {
				for(int i = 0; i < 25; i++) {
					if(i > 4 && i % 5 != 4 && a[i] == false && a[i-5] == false && a[i-4] == false) {
						res = i-5+1;
						a[i] = true;
						a[i-5] = true;
						a[i-4] = true;
						break;
					}
				}
			}
			if(res == 0)
				System.out.println("NONE");
			else
				System.out.println(res);
		}
	}

}


