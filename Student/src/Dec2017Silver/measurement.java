package Dec2017Silver;
import java.util.*;
import java.io.*;
public class measurement {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, g;
    static Measure[] logs;
    public static void main(String[] args) {
        try {
        	br = new BufferedReader(new FileReader(new File("measurement.in")));
            pw = new PrintWriter(new File("measurement.out"));

            init();
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	g = Integer.parseInt(st.nextToken());
    	logs = new Measure[n];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int day = Integer.parseInt(st.nextToken());
    		int ID = Integer.parseInt(st.nextToken());
    		int actualChange = Integer.parseInt(st.nextToken());
      		logs[i] = new Measure(day, ID, actualChange);
    	}
    	Arrays.sort(logs);
    	System.out.println(Arrays.toString(logs));
    }
    private static String solve() {
    	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	for(int i = 0; i < n; i++)
    		map.put(logs[i].getID(), g);
    	
    	System.out.println(map);
    	int countingChange = 1;
    	int max = g;
    	int secondMax = g;
    	for(int i = 0; i < n; i++) {
    		int id = logs[i].getID();
    		int newMilk = logs[i].getChange() + map.get(id);
    		if(newMilk >= max && map.get(id) < max || newMilk <= secondMax && map.get(id) == max)
    			++countingChange;
    		System.out.println(secondMax + " " + max);
    		if(newMilk > max)
    			max = newMilk;
    		if(secondMax < newMilk && newMilk < max)
    			secondMax = newMilk;
    		map.put(id, newMilk);
    		System.out.println(map.toString() + " " + countingChange);
    	}
    	return String.valueOf(countingChange);
    }
}
class Measure implements Comparable<Measure> {
    private int day;
    private int identification;
    private int change;
    public int compareTo(Measure m) {
        return this.day - m.day;
    }
    public Measure(int da, int id, int ch) {
        this.day = da;
        this.identification = id;
        this.change = ch;
    }
    public int getDay() {
    	return day;
    }
    public int getID() {
    	return identification;
    }
    public int getChange() {
    	return change;
    }
    public String toString() {
    	return day+ " "+ identification+" "+change;
    }
}


