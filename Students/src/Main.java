import java.util.*;
import java.io.*;
class Main {
  static BufferedReader in;
  static PrintWriter out;
  static int n, m, c;
  static int[] a;
  public static void main(String[] args) throws IOException{
    in = new BufferedReader(new FileReader(new File("convention.in")));
    out = new PrintWriter(new File("convention.out"));
    init();
    solve();
    in.close();
    out.close();
  }

  static void init() throws IOException{
    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    a = new int[n];
    st = new StringTokenizer(in.readLine());
    for(int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(a);
  }

  static void solve(){
    int low = 0, high = a[a.length - 1] - a[0], ans = 69;
    //System.out.println(Arrays.toString(a));
    while(low <= high){
      int mid = (low + high) / 2;
      if(check(mid)){
        ans = mid;
        high = mid - 1;
      }else{
        low = mid + 1;
      }
    }
    System.out.println(ans);
  }

  static boolean check(int mid){
    int buses = 1;
    int number = 0;
    int start = a[0];
    
    for(int i = 0; i < n; i++){
      number++;
      if(a[i] - start> mid || number > c){
        number = 1;
        buses++;
        start = a[i];
      }
    }
    return buses <= m;
  }
}