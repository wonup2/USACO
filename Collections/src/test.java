/*
ID: wonup22
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new FileReader("test.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    
    int i1 = in.nextInt();    // first integer
    int i2 = in.nextInt();    // second integer
    out.println(i1+i2);       // output result
    out.close();              // close the output file
  }
}