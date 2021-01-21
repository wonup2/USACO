import java.util.*;
import java.io.*;
class Main {
  static BufferedReader in;
  static PrintWriter out;
  static int n, k;
  static int[][] grid;
  static int[][] v;
  public static void main(String[] args) throws IOException{
    in = new BufferedReader(new FileReader(new File("mooyomooyo.in")));
    out = new PrintWriter(new File("mooyomooyo.out"));
    init();
    solve();
    in.close();
    out.close();
  }

  static void init() throws IOException{
    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    grid = new int[n][10];
    v = new int[n][10];

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(in.readLine());
      String temp = st.nextToken();
      for(int j = 0; j < 10; j++){
        grid[i][j] = Integer.parseInt(temp.substring(j, j + 1));
      }
    }
    print(grid);
  }

  static void solve(){
    for(int i = grid.length - 1; i >= 0; i--){
      for(int j = 0; j < 10; j++){
        if(grid[i][j] != 0){
          fill(i, j, grid[i][j], 1);
          drop();
        }
      }
    }
    System.out.println("----------------------------");
    print(grid);
  }

  static void fill(int row, int col, int color, int cnt){
    if(row >= grid.length || row < 0 || col > 9 || col < 0){
      return;
    }
    if(v[row][col] != 0){
      return;
    }
    if(grid[row][col] != color){
      return;
    }
    cnt++;
    v[row][col] = 1;
    fill(row - 1, col, color, cnt);
    fill(row + 1, col, color, cnt);
    fill(row, col - 1, color, cnt);
    fill(row, col + 1, color, cnt);

    if(cnt >= k){
      grid[row][col] = 0;
      v[row][col] = 0;
    }
  }

  static void drop(){
    //print(grid);
    for(int col = 0; col < 10; col++){
      int row = n - 1;
      boolean done = false;
      while(done == false){
        if(grid[row][col] == 0){
          int next = 69;
          for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] != 0){
              next = i;
              break;
            }
            if(i == 0)
              done = true;
          }
          grid[row][col] = grid[next][col];
          grid[next][col] = 0;
          row--;
        }else{
          for(int i = row; i >= 0; i--){
            if(grid[i][col] != 0){
              row = i;
              break;
            }
            if(i == 0){
              done = true;
            }
          }
        }
      }
    }
  }

  static void print(int[][] a){
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[0].length; j++){
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }
}