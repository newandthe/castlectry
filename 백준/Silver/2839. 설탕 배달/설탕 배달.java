import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean isSuccess = false;

        /*
        * N을 5와 3으로 나눈 몫의 합 최소 값 구하는 문제
        * 구할 수 없는 경우 -1 출력
        * */

        int tmp_5 = N / 5;    // 일단 5로 나눠서 봉지 수 최대의 경우 수 취득
        int tmp_3 = 0;
        int tmpMod = N % 5;   // 나머지 값 취득
//        System.out.println("############");
//        System.out.println(tmp_5);
//        System.out.println(tmpMod);
//        System.out.println("############");

        endPoint:
        while (tmp_5 >= 0) {

            if (tmpMod % 3 == 0) {
//                System.out.println("A");
//                System.out.println("5: " + tmp_5 + " 3: " + tmp_3 + " mod: " + tmpMod);
                System.out.println(tmp_5 + (tmpMod / 3)  );
                isSuccess = true;
                break endPoint;
            }

            tmp_5--; tmpMod += 5;

        }

        if (!isSuccess) {
            System.out.println(-1);
        }

    }
}
