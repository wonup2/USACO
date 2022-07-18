import java.io.*;
import java.util.*;

public class battleship {
	
   public static void main(String[] args) throws IOException{
       //Input
       Scanner in = new Scanner(new InputStreamReader(System.in));

       String line = in.nextLine();  System.out.println(line);
       String [] a = line.split(" ");
       int n = Integer.parseInt(a[0]);
       System.out.println(n);
       int r = Integer.parseInt(a[1]);
       int c = Integer.parseInt(a[2]);

       String [][] bat = new String[n][n];
       for(int i = 0; i<n; i++) {

           String temp = in.nextLine();
           String[] temp2 = temp.split(" ");

           for(int j = 0; j<n; j++) {
               bat[i][j] = temp2[j];
           }
       }

       String ans = "";
       if(bat[r][c].equals("S")) ans = "No";
       else ans = "Yes";

       System.out.println( ans);

       //Process
       /*
       Your code would go here.
        */
   }
}