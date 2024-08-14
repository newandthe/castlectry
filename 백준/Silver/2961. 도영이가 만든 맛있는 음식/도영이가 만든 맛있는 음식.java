import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> list;

    static int N;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 완전탐색

        /*
         * S: 신맛, B: 쓴맛 [ 신맛 - 사용한 재료의 신맛의 곱 | 쓴맛 - 사용한 재료의 쓴맛의 합 ]
         * -- > 신맛과 쓴맛의 차이를 최소화
         * -- > 재료는 반드시 하나 이상 사용
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 사용한 재료의 개수

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());   // 신맛
            int B = Integer.parseInt(st.nextToken());   // 쓴맛

            list.add(new int[]{S, B});

        }

        // for (int[] ingredient : list) {
           // System.out.println(Arrays.toString(ingredient));
        // }


//        System.out.println(Arrays.deepToString(list));

        DFS(0, 1, 0, 0);

        System.out.println(result);


    }


    // .get(0) = 곱
    // .get(1) = 합

    private static void DFS(int depth, int S, int B, int count) {
        // System.out.println("depth " + depth + " S " + S + " B " + B + " count " + count);

        // 적어도 하나의 재료를 선택했을 때만 결과를 계산
        if (count > 0) {
            result = Math.min(result, Math.abs(S - B));
        }

        // 모든 재료를 탐색한 경우 종료
        if (depth == N) {
            return;
        }

        // 재료를 선택한 경우
        DFS(depth + 1, S * list.get(depth)[0], B + list.get(depth)[1], count + 1);
        // 재료를 선택하지 않은 경우
        DFS(depth + 1, S, B, count);

    }
}
