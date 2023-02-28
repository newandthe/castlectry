import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
		
		// 배열 입력받기
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		int arr2[] = new int[M];
		
		for (int i = 0; i < M; i++) {
			arr2[i] = sc.nextInt();
		}
		
		int state = 10;
		
		// 출력 시작
		for (int i = 0; i < M; i++) {
			int key = arr2[i];
			if(Arrays.binarySearch(arr, key) >= 0) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
		
		
		
		
		
		
	
	
	
	}

}

