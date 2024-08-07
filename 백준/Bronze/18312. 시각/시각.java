import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BOJ_18312_function(N, K);

    }

    private static void BOJ_18312_function(int N, int K) {

        int count = 0;
        String strK = String.valueOf(K);

        // 0시 0분 0초부터 N시 59분 59초까지 순회
        for (int hour = 0; hour <= N; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    // 현재 시각을 HHMMSS 형식의 문자열로 변환
                    String currentTime = String.format("%02d%02d%02d", hour, min, sec);
                    // 숫자 K가 포함되어 있는지 확인
                    if (currentTime.contains(strK)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
