import java.util.*;
import java.io.*;

public class cereal_yunju {
	static BufferedReader in;
	static PrintWriter out;
	static int N,M;
	static int[] first;
	static int[] second;
	
	public static void main(String[] args) {
		try{
			in = new BufferedReader(new FileReader("cereal.in"));
			out = new PrintWriter(new File("cereal.out"));
		
			init();
			solve();
		
			in.close();
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	static void init() throws IOException{
		String temp[]=in.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		first = new int[N];
		second = new int[N];
		
		for(int i = 0; i < N; i++){
			temp = in.readLine().split(" ");
			first[i] = Integer.parseInt(temp[0]);
			second[i] = Integer.parseInt(temp[1]);
		}
		//System.out.println(N+" "+M);
	}
	static void solve(){
		int count = 0;
		int[] cereal = new int[M+1];
		int[] ans = new int[N];
		
		for(int i = N-1; i>=0; i--){
			int cow = i;
			int choice = first[i];
			
			while(true){
				//unoccupied(cereal not taken)
				if(cereal[choice] == 0){
					cereal[choice] = cow;
					count++;
					break;
				}
				//tries to replace higher priority cow
				else if(cereal[choice]<cow) {
					break;
				}
				//can replace
				else{
					int temp = cereal[choice];
					cereal[choice]  = cow;
					
					if(choice == second[temp]){
						break;
					}
					choice = second[temp];
					cow = temp;
					
				}
				
				
			}
			ans[i] = count;
		}

		StringBuilder sb = new StringBuilder();
		for(int i:ans)
			sb.append(i).append("\n");
		out.print(sb.toString());
		//for(int i = 0; i < N; i++){
		//	out.println(ans[i]);
		//}
	}

}
