import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static long[] DP;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new long[N+1];

        DP[0] = 0;
        DP[1] = 1;


//        fiboFunction(N);

        for(int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }

        System.out.println(DP[N]);

    }

//    private static void fiboFunction(int N) {
//
//
//
//
//    }


}
