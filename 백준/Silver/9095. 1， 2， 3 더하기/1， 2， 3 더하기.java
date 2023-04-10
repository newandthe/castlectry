import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] dp = new int[12];

		// 초기값 설정
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			// 다이나믹 프로그래밍으로 테스트 케이스 수만큼 결과 출력
			for (int j = 4; j <= n; j++) {

					dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];	// 점화식
				
				
			}
			
			System.out.println(dp[n]);
		}

	}

}
