
import java.util.*;
import java.io.*;
public class Contest1Sr_DigitReassembly {
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("sendr"));
        for(int g = 0; g < 5; g++) {
            String input = in.next();
            int len = Integer.parseInt(in.next());
            //System.out.println(Arrays.toString(input));
            int temp =  input.length()/len;
            if(input.length()/len != 0) {
                temp++;
            }
            String[] add = new String[temp];
            temp = 0;
            for(int i = 0; i < input.length(); i += len) {
                if(i + len > input.length()) {
                    add[temp] = input.substring(i, input.length());
                    for(int j = 0; j <  i+len-input.length(); j++) {
                        add[temp] = add[temp] + "0";
                    }
                }else {
                    add[temp] = input.substring(i, i+len);
                }
                temp++;
            }

            System.out.println(Arrays.toString(add));
            int ans = 0;
            for(int i = 0; i < add.length; i++) {
                if(add[i] == null) {
                    continue;
                }
                ans += Integer.parseInt(add[i]);
            }
            System.out.println(ans);
        }
    }
}