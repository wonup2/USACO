import java.util.*;

public class FEB_BR_blocks1 {

	//static boolean ans= false;
	static String blocks[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N= in.nextInt();
		blocks = new String [4];		
		for(int i=0; i<4; i++) blocks[i] = in.next();

		for(int i=0; i<N; i++) {
			String word = in.next();
		    boolean blocks_used[] = new boolean[4];
				    
		    boolean r = search_char(word, blocks_used);
		    if (r) System.out.println("YES");
			else System.out.println("NO");	
		}
	}
	
	static boolean search_char(String s, boolean blocks_used[]) {
	    
	    if (s.length()==0) return true;
	    
	    for (int i=0; i<4; i++) {
	        if (!blocks_used[i]&& blocks[i].contains(s.charAt(0)+"")) {
	            blocks_used[i] = true;
	            if (search_char(s.substring(1), blocks_used))
	                return true;
	            blocks_used[i] = false;
	        }
	    }
	    return false;   
	}
}


/*
6
MOOOOO
OOOOOO
ABCDEF
UVWXYZ
COW
MOO
ZOO
MOVE
CODE
FARM

*/