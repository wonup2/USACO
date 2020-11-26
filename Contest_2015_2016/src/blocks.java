import java.util.*;
import java.io.*;
public class blocks {
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new FileReader(new File("blocks.in")));
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        
        int num=in.nextInt();
        int[] need=new int[26];
        int [] first=new int[26];
        int [] second=new int[26];
        
        for (int i=0; i<num; i++) {
            String word1=in.next();
            for (int j=0; j<word1.length(); j++) {
                char temp1=word1.charAt(j);
                first[temp1-'a']++;
            }
            //System.out.println(Arrays.toString(first));
            String word2=in.next();
            for (int j=0; j<word2.length(); j++) {
                char temp2=word2.charAt(j);
                second[temp2-'a']++;
            }
            for (int j=0; j<26; j++) {
                need[j]+=Math.max(first[j], second[j]);
            }
        }
        for (int i=0; i<26; i++) {
            out.println(need[i]);
        }
        in.close();
        out.close();
    }
}