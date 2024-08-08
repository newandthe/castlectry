import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] atoms;
    static int maxNumber = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        // 원소 입력
        st = new StringTokenizer(br.readLine());


        atoms = new int[K];
        for( int i=0; i<K; i++){
            atoms[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 수 찾기 시작 (재귀)
        BOJ_18511_function(0);

        System.out.println(maxNumber);

    }

    private static void BOJ_18511_function(int current) {
        if (current > N) return;

        if (current > maxNumber) {
            maxNumber = current;
        }

        for (int i = 0; i < atoms.length; i++) {
            BOJ_18511_function(current * 10 + atoms[i]);
        }
    }

}
