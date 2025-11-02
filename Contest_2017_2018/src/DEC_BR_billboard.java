import java.util.*;
import java.io.*;
public class DEC_BR_billboard {
	
	static Scanner in;
	static PrintWriter out;
	
	static boolean[][]array;	
	static int ans, x1, y1, x2, y2;
	
	static void solve() throws IOException {
		
		array=new boolean[2001][2001];
		
		ans = 0;
		
		for(int i=0; i<2; i++){
			
			x1=in.nextInt()+1000;
			y1=in.nextInt()+1000;
			x2=in.nextInt()+1000;
			y2=in.nextInt()+1000;
			
			for(int j=x1; j<x2; j++)
				for(int k=y1; k<y2; k++)		
					if(!array[j][k]) {
						array[j][k]=true;		
						ans++;
					}
		}
		
		x1=in.nextInt()+1000;
		y1=in.nextInt()+1000;
		x2=in.nextInt()+1000;
		y2=in.nextInt()+1000;
		
		for(int j=x1; j<x2; j++)
			for(int k=y1; k<y2; k++)		
				if(array[j][k]) ans--;					
		
		
		out.println(ans);
	}	
	
	public static void main(String[] args) throws IOException{
		
		in=new Scanner(new FileReader("billboard.in"));
		out=new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		solve();
		
		in.close();
		out.close();
	}
}


