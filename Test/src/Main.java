import java.util.*;
public class Main {
  static Scanner in;
  static int n, m, a[], ans, low, high, mid;
  
  public static void main(String[] args) {
    in=new Scanner(System.in);
    init();
    solve();
    count();
  }
  static void init(){
    n = in.nextInt();
    m = in.nextInt();
    a = new int[n];
    for(int i=0; i<n; i++) {
      a[i]=in.nextInt();
      low=Math.max(low,a[i]);
      high+=a[i];
    }
  }
  
  static void solve() {

    while(low<=high) {
      mid=(high+low)/2;
      if(check(mid)) {
        ans=mid;
        high=mid-1; //<----
      } else {
        low=mid+1; //<---
      }
    }
    System.out.println(ans);
  }
  
  static boolean check(int mid) {
    long total=0l;
    int group=1;
    for(int i=0;i<n;i++) {
      if(total+a[i]<=mid) {
        total+=a[i];
      } else {
        group++;
        total=a[i];
      }
    }
    return group<=m;
  }
  static void count() {
    int count=0, sum=0;
    for(int i=0;i<n;i++) {
      if(sum+a[i]<=ans) {
        count++;
        sum+=a[i];
        //System.out.println(count+" "+ a[i] +" "+sum);
      } else {
        System.out.print(count+" ");
        count=1;
        sum=a[i];
      }
    }
    System.out.println(count);
  } 
}