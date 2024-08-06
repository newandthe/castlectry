import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        BOJ_2231_function(N);


    }

    public static void BOJ_2231_function(int N) {

        int result = 0;

        for(int i=0; i < N; i++) {
            int num = i;
            int sum = 0;    // 각 자릿수의 합

            while (num != 0) {
                sum += num % 10;    // 각 자릿수 더하기
                num /= 10;
            }

            if(sum + i == N) {
                result = i;

                break;

            }
        }

        System.out.println(result);


    }

}
