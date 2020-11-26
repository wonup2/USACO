
public class array1 {

	public static void main(String[] args) {

		//declare and initialize array
		int a[] = new int[5];
		
		//assign data in array
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		a[4] = 50;
		
		//print array
		for(int i=0; i<a.length; i++)
			System.out.println(a[i]);
		
		//last index ---> a.lenth - 1
		System.out.println(a[a.length-1]);		
	}
}
