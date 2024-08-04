import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        boolean[] used = new boolean[N + 1];
        int[] currentSequence = new int[M];

        backtrack(N, M, 0, currentSequence, used);
    }

    private static void backtrack(int N, int M, int depth, int[] currentSequence, boolean[] used) {

        // 수열의 길이가 M이 되면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(currentSequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                // 현재 숫자를 사용한 것으로 표시하고 수열에 추가
                used[i] = true;
                currentSequence[depth] = i;

                // 재귀 호출
                backtrack(N, M, depth + 1, currentSequence, used);

                // 호출이 끝나면 숫자를 사용되지 않은 것으로 되돌리고 수열에서 제거
                used[i] = false;
            }
        }

    }


}