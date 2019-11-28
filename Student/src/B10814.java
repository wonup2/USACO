import java.util.*;
public class B10814 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		trio[] a = new trio[n];

		for(int i=0; i<n; i++) {
			a[i] = new trio(i, in.nextInt(), in.next());
		}
		Arrays.sort(a);

		StringBuilder result = new StringBuilder();
		for(int i=0; i<n; i++) {
			result.append(a[i].age)
			      .append(" ")
			      .append(a[i].name)
			      .append("\n");
		}
		
		System.out.print(result);
	}
}


class trio implements Comparable<trio>{
	int index;
	int age;
	String name;
	trio(int i, int a, String n){
		index = i;
		age = a;
		name = n;
	}
	@Override
	public int compareTo(trio that) {
		if(this.age>that.age) return 1;
		else if(this.age<that.age) return -1;
		else {
			if(this.index>that.index) return 1;
			else return -1;
		}
	}
	
	public String toString() {
		return index+" "+age+" "+name;
	}
}








