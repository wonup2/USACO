import java.util.*;



public class IteratingE {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		
       
        ArrayList<Integer> a = new ArrayList<Integer>();


        HashSet<Integer> numbers = new HashSet<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        long startTime = System.nanoTime();

        for(int i =0; i<1000000; i++){

            numbers.add(i);

        }



        long endTime = System.nanoTime();

        System.out.println(" HashSet : " + (endTime - startTime));

 
        numbers = new LinkedHashSet<Integer>();

        startTime = System.nanoTime();

        for(int i =0; i<1000000; i++){

            a.add(i);
            b.add(i);
        }
        //b.addAll(a);
      
        endTime = System.nanoTime();

        System.out.println("ArrayList: " + (endTime - startTime));

       

        

	}



}



