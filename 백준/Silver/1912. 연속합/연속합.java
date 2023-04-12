import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		// bottom up
		dp[0] = arr[0];
		int max = arr[0];
		
		for(int i=1; i<N; i++) {
			
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			
			
			max = Math.max(max, dp[i]);
			// System.out.println("i : " + i + " max : " + max);
			
		}
		
		
		
		System.out.println(max);
		
		// System.out.println(Arrays.toString(dp));
		
		
		
		
		
		
	}

}
