import java.util.*;
import java.io.*;

public class billboard {

  static Scanner in;
  static PrintWriter out;
  static pos b1, b2, t;

  public static void main(String[] args) throws IOException{
    
    in = new Scanner(new FileReader("billboard.in"));
    out = new PrintWriter(new File("billboard.out"));

    init();
    solve();

    in.close();
    out.close();
  }

  static void init() throws IOException{
    b1 = new pos(in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt());
    b2 = new pos(in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt());
    t = new pos(in.nextInt(), in.nextInt(),in.nextInt(),in.nextInt());
  }

  static void solve(){
    
	 int ans = area(b1) + area(b2) - ol(b1, t) - ol(b1,t);
	 out.println(ans);
	  
  }
  
  static int area(pos b) {
	  return (b.x2-b.x1) * (b.y2-b.y1);
  }
  
  static int ol(pos b, pos t) {
	  int top = Math.min(b.y2, t.y2);
	  int bottom = Math.max(b.y1, t.y1);
	  int right = Math.min(b.x2, t.x2);
	  int left = Math.max(b.x1, t.x1);
	  
	  int ans = (top-bottom) * (right-left);
	  
	  if(top<bottom || right < left) return 0;
	  return ans;
  }
  
  static class pos{
	  int x1, y1, x2, y2;
	  
	  pos(int a, int b, int c, int d){
		  x1 = a; y1=b; x2=c; y2=d;
	  }
  }
}

