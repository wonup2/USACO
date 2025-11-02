import java.io.*;
import java.util.*;
public class FEB_BR_triangles {
	
	static TreeSet<Integer> setX, setY;
    static int x[], y[], n, m=1000000007;
	
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
    
    n = Integer.parseInt(br.readLine());
    x = new int[n];
    y = new int[n];
    
    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }
    
    
    int area = 0;
    
    setX = new TreeSet<Integer>();
    setY = new TreeSet<Integer>();
    
    for(int i = 0; i < n-2; i++) {
      for(int j = i+1; j < n-1; j++) { 
        for(int k = j+1; k < n; k++) {         	
        	if(ok(i, j, k)) 
        		area = area%m + ((setX.last()-setX.first())%m)   *  ( (setY.last()-setY.first()) %m );     
        	
        }
      }
    }
    pw.println(area);
    pw.close();
  }
  
  static boolean ok(int i, int j, int k) {	  
	 setX.clear(); setY.clear();
	 setX.add(x[i]);setX.add(x[j]);setX.add(x[k]);
	 setY.add(y[i]);setY.add(y[j]);setY.add(y[k]);
	  
	 return setX.size() == 2 && setY.size() == 2;
  }
}



/*
for(int i = 0; i < n; i++) {
for(int j = 0; j < n; j++) { // same x-coordinate
  if(i == j || x[i] != x[j]) continue;
  for(int k = 0; k < n; k++) { // same y-coordinate
    if(i == k || y[i] != y[k]) continue;
    ret = Math.max(ret, Math.abs(x[k] - x[i]) * Math.abs(y[j] - y[i]));
  }
}
*/