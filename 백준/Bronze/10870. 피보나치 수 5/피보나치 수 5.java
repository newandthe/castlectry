import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());

        int result = BOJ_10870_function(N);

        System.out.println(result);

    }

    private static int BOJ_10870_function(int N) {

        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return BOJ_10870_function(N-1) + BOJ_10870_function(N-2);
        }

    }
}
