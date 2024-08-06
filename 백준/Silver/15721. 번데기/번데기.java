import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /* 4 +

    0101/0011/0101
    * 01010011                  // 8번   // 4 4  // 1회차
    * 0101000111                // 10번  // 5 5  // 2회차
    * 010100001111              // 12번  // 6 6  // 3회차      // 14
    * ....
    * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());        // 참여자 수
        int T = Integer.parseInt(br.readLine());        // 구하고자 하는 번째 수
        int type = Integer.parseInt(br.readLine());     // "뻔" : 0, "데기" : 1

        BOJ_15721_function(A, T, type);



    }

    private static void BOJ_15721_function(int A, int T, int type) {

        int cycle = 1; // 사이클 번호
        int count = 0; // 현재까지의 "뻔" 또는 "데기" 수
        int currentPlayer = 0; // 현재 사람이 앉은 위치 (0번부터 시작)

        while (true) {
            // "뻔", "데기" 기본 패턴 반복
            for (int i = 0; i < 4; i++) {
                if (i % 2 == type) {
                    count++;
                    if (count == T) {
                        System.out.println(currentPlayer % A);
                        return;
                    }
                }
                currentPlayer++;
            }

            // 추가 "뻔", "데기" 반복 (사이클 번호만큼 반복)
            for (int i = 0; i < cycle + 1; i++) {
                if (0 == type) {
                    count++;
                    if (count == T) {
                        System.out.println(currentPlayer % A);
                        return;
                    }
                }
                currentPlayer++;
            }
            for (int i = 0; i < cycle + 1; i++) {
                if (1 == type) {
                    count++;
                    if (count == T) {
                        System.out.println(currentPlayer % A);
                        return;
                    }
                }
                currentPlayer++;
            }

            cycle++;
        }




    }
}
