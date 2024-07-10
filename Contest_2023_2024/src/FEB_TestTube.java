import java.util.*;
import java.io.*;
public class FEB_TestTube {
  public static void main(String[] args) throws IOException{
    Scanner input = new Scanner(System.in);
    int testCases = input.nextInt();
    for(int i = 0; i < 1; i++) {
      int count = 0;
      int fillLevel = input.nextInt();
      int query = input.nextInt();
      System.out.print(query);
      ArrayList<Integer> beaker1 = splitter(input.nextInt(),fillLevel);
      ArrayList<Integer> beaker2 = splitter(input.nextInt(),fillLevel);
      ArrayList<String> tracker = new ArrayList<String>();
      ArrayList<Integer> beaker3 = new ArrayList<Integer>();
        while(beaker1 != beaker2) { 
          System.out.println("here");
          if(beaker1.size() == 0) {
            tracker.add("3 1");
            count++;
            beaker1 = beaker3;
          } else if(beaker1.get(beaker1.size() - 1) == beaker2.get(beaker2.size() - 1)) {
           while(beaker1.get(beaker1.size() - 1) == beaker2.get(beaker2.size() - 1)) {
             beaker2.add(beaker1.get(beaker1.size() - 1));
             beaker1.remove(beaker1.size() - 1);
           }
            tracker.add("1 2");
          } else {
            while(beaker1.get(beaker1.size() - 1) != beaker2.get(beaker2.size() - 1)) {
              beaker3.add(beaker1.get(beaker1.size() - 1));
            }
            tracker.add("1 3");
          }
        }
        if(query == 1) {
          System.out.println(tracker.size());
        } else {
          for(int j = 0; j < tracker.size(); j++) {
            System.out.println(tracker.get(j));
          }
          System.out.println(tracker.size());
        }
    }
  }
  public static ArrayList<Integer> splitter(int split, int fillLevel) {
    ArrayList<Integer> Beaker = new ArrayList<Integer>();
    String k = Integer.toString(split);
    for(int i = 0; i < fillLevel; i++) {
      Beaker.add(Integer.parseInt(k.substring(i,i+1)));
    }
    return Beaker;
  }
}

/* 
6
4 1
1221
2211
4 2
1221
2211
4 3
1221
2211
6 3
222222
111112
4 3
1121
1222
4 2
1121
1222 */