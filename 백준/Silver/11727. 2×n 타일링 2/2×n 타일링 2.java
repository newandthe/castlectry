import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long[] DP;
    static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 직사각형 가로 길이
        n = Integer.parseInt(br.readLine());

        DP = new long[n+1];

        DP[0] = 0;
        DP[1] = 1;
        if ( n > 1 ) {
            DP[2] = 3;
        }

        /*
        *
        1×2 타일 사용
        2×i 직사각형의 오른쪽 끝에 1×2 타일을 세로로 배치하는 경우, 나머지 부분은 2×(i-1) 직사각형을 타일로 채우는 문제와 같습니다. 따라서 이 경우의 방법 수는 dp[i-1]
        *
        2×1 타일 사용
        2×i 직사각형의 오른쪽 끝에 2×1 타일을 가로로 배치하는 경우, 나머지 부분은 2×(i-2) 직사각형을 타일로 채우는 문제와 같습니다. 따라서 이 경우의 방법 수는 dp[i-2]
        *
        2×2 타일 사용
        2×i 직사각형의 오른쪽 끝에 2×2 타일을 배치하는 경우, 나머지 부분은 2×(i-2) 직사각형을 타일로 채우는 문제와 같습니다. 따라서 이 경우의 방법 수는 dp[i-2]
        *
        * --> DP[N] = DP[N-1] + 2 * DP[N-2]
        * */

        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i-1] + 2 * DP[i-2];
            DP[i] %= 10007;
        }

        System.out.println(DP[n]);

    }

}
