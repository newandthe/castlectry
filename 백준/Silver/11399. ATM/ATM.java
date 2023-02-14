import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		
		
		for (int i = 0; i < N; i++) {	// 입력부
			arr[i] = sc.nextInt();
		}
		
		// 최소값 찾기
		
		int Min, temp;
	    for (int i = 0; i < arr.length-1; i++) {        // 1.
	        Min = i;
	        for (int j = i + 1; j < arr.length; j++) {  // 2.
	            if (arr[j] < arr[Min]) {           // 3.
	                Min = j;
	            }
	        }
	        //  swap
	        temp = arr[Min];
	        arr[Min] = arr[i];
	        arr[i] = temp;
	  } // 정렬 완료
	    int sum=0;
	    for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
			
		}
	    
	    System.out.println(sum);
	    
	    
		
	}

}
