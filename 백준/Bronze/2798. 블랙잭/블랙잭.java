import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards); // 오름차순 정렬
        /*
        // 내림차순 정렬
        // Integer[] 형태로 선언
        Arrays.sort(cards, Collections.reverseOrder());
        */
//        System.out.println(Arrays.toString(cards));

        int result = BOJ_2798_function(N, M, cards);

        System.out.println(result);

    }

    private static int BOJ_2798_function(int N, int M, int[] cards) {
        int closestSum = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int currentSum = cards[i] + cards[j] + cards[k];
                    if (currentSum <= M && currentSum > closestSum) {
                        closestSum = currentSum;
                    }
                }
            }
        }

        return closestSum;
    }

}
