import java.util.*;
public class DEC_BR_ReverseEngineering {
	static Scanner in;
	static boolean ok;
	static int n, m, t;
	static LinkedList<pair> a;
	static HashSet<Character> output0, output1;
	static ArrayList<Integer> idx0, idx1;
	
	static class pair{
		//data field
		String input;
		char output;
		
		//constructor
		pair(String i, char o){
			input = i;
			output = o;
		}
		
		//print
		public String toString() {
			return input+" "+output;
		}
	}
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		t = in.nextInt(); in.nextLine();
		
		while(t-->0) {
			init();
			solve();
		}
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt();

		a = new LinkedList<pair>();
		for(int i = 0; i<m; i++) 
			a.add(new pair(in.next(), in.next().charAt(0)));
	
	}
	static void solve() {		
	
		
		while(true) {
		
			int size1=a.size();
			
			for(int i=0; i<n; i++) {
				
				output0 = new HashSet<Character>();
				output1 = new HashSet<Character>();
				idx0 = new ArrayList<Integer>();
				idx1 = new ArrayList<Integer>();
	
				for(int j=0; j<a.size(); j++) {
					char bit = a.get(j).input.charAt(i);
					if(bit=='0') {
						output0.add(a.get(j).output);
						idx0.add(j);
					}
					else {
						output1.add(a.get(j).output);
						idx1.add(j);
					}
				}								

				if(output0.size()==1) 
					for(int k=idx0.size()-1; k>=0; k--) a.remove((int)idx0.get(k));					
				
				else if(output1.size()==1) 
					for(int k=idx1.size()-1; k>=0; k--) a.remove((int)idx1.get(k));							
				
			}
			
			int size2=a.size();

			if(size1==size2) break;
		}
 
		if(a.size()<=1) System.out.println("OK");
		else System.out.println("LIE");
	}
}
