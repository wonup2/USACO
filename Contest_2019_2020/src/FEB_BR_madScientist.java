import java.io.*;

public class FEB_BR_madScientist {

	public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("breedflip.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
	//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   
	int n = Integer.parseInt(in.readLine());
    char x[] = in.readLine().toCharArray();
    char y[] = in.readLine().toCharArray();
    
    int ans = 0;
    boolean cng = false;
    
    for(int i = 0; i<n; i++) {
    	if(x[i] != y[i]) {
    		if(!cng) ans++;
    		cng = true;
    	}
    	else cng = false;
    }    
    
    out.println(ans);
    out.close();
  }    
}


