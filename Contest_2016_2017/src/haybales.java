import java.io.*; 
import java.util.*; 

public class haybales{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader(new File("haybales.in")));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
         arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      for(int i = 0; i < Q; i++){
         st = new StringTokenizer(br.readLine());
         int low = Integer.parseInt(st.nextToken());
         int high = Integer.parseInt(st.nextToken());
         System.out.println(low+" "+high);
         int bi = Arrays.binarySearch(arr, low);
         System.out.print(bi + " ");
         if(bi < 0){
            bi = Math.abs(bi+1);
         }
         
         int ti = Arrays.binarySearch(arr, high);          

         if(ti < 0){
            ti = Math.abs(ti+2);
         }

         out.println(ti-bi+1);
      }
      out.close();
   }
}
