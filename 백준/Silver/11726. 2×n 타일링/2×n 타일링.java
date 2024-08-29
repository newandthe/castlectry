import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        if(n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {

            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {

                // 맨 오른쪽이 2 * 1 인 경우의 수 + 1 * 2 인 경우의 수
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

            }

            System.out.println(dp[n]);
        }



    }
}
