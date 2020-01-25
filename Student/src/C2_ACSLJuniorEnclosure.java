import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class C2_ACSLJuniorEnclosure {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File ("test.in"));
		for(int g = 0; g<9; g++) {
            String input = in.nextLine();

            ArrayList<Integer> ans = new ArrayList<Integer>();
            for(int i = 0; i<input.length();i++) {
                if(input.charAt(i) == '(') {
                    int index = i+5;
                    
                    while(index <= input.length()+1) {
                        ans.add(index);
                        index = index + 2;
                    }
                }
                else if (input.charAt(i) == ')') {
                  int index = i-2;
                  while(index>0) {       
                      ans.add(index);
                      index = index - 2;                     
                  }
                }
            }
			Collections.sort(ans);
			System.out.println(ans);  
		}
	}
}
