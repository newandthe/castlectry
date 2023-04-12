import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 3개 있는 경우
		// OOX or OXO or XOO 중 최대값 찾아나가기
		// 인덱스 기준으로 하나 전과 두개 전을 비교.
		
		int dp[] = new int[N];
		dp[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			
			if(i == 1) {
				dp[1] = arr[0] + arr[1];
				continue;
			}
			
			if(i == 2) {
				dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
				continue;
			}
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i-1] + arr[i]));
		}
		
		System.out.println(dp[N-1]);
		
		// System.out.println(Arrays.toString(dp));
		
	}
}
