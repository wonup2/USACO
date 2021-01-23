
public class CompleteSearch {

	public static void main(String[] args) {

		
		double num[] = {1.0, 1.0, 2.0, 3.0};
		int n = 4;
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = i; j <n; j++) {	
				
				double sum=0;
				for(int k = i; k<=j; k++) sum+=num[k];							
				
				double ave = sum/(j-i+1);
				
				for(int k = i; k<=j; k++) 				
					if(num[k]==ave) { cnt++; break;	}
					
			}
		}
		
		System.out.println(cnt);
		
	}

}
