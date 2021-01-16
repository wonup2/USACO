
public class Data_Structure {
	public static void main(String[] args) {
		
		Pair<Integer, String> p = new Pair(5, "hello");
		System.out.println(p.first + " " + p.second);
		
	}
	
	
	static class Pair<K, V> implements Comparable<Pair>{
	    K first;
	    V second;

	    public Pair(K first_value, V second_value) {
	        first = first_value;
	        second = second_value;
	    }

		@Override
		public int compareTo(Data_Structure.Pair o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
