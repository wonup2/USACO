import java.io.*;
import java.util.*;

public class FEB_BR_cowqueue {

	public static void main(String[] args)  throws IOException {
		Scanner in = new Scanner(new FileReader("cowqueue.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		int n=in.nextInt();
		ArrayList<Pair1> cow = new ArrayList<Pair1>();
		for(int i=0; i<n; i++)
			cow.add(new Pair1(in.nextInt(), in.nextInt()));
		
		Collections.sort(cow);
		
		int arrives = cow.get(0).arrives;
		int done = arrives + cow.get(0).time;
		
		for(int i=1; i<cow.size(); i++){
			arrives = cow.get(i).arrives;
			if(done > arrives)
				done += cow.get(i).time;
			else 
				done = arrives + cow.get(i).time;
		}
		
		out.println(done);
		out.close();
		in.close();
	}	
}
class Pair1 implements Comparable<Pair1>{

	int arrives;
	int time;
	Pair1(int c, int t){
		arrives = c;
		time = t;
	}
	@Override
	public int compareTo(Pair1 that) {
		return this.arrives - that.arrives;
	}	
	public String toString(){
		return arrives+" "+time;
	}
}