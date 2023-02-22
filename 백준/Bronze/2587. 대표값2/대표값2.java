import java.util.Arrays;
import java.util.Scanner;

 
 
public class Main {
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		// 정렬하기
		Arrays.sort(arr);
		
		// System.out.println(Arrays.toString(arr));
		
		
		// 평균 구하기
		int avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += arr[i];
		}
		
		// 평균 출력
		System.out.println(avg/5);
		
		
		
		// 중앙값 출력
		System.out.println(arr[2]);
		
	}
}