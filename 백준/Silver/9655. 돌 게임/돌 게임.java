import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        /*
        1 or 3개 남겨 놓으면 상대 승리 -- > 무조건 1개 또는 3개만 취득 가능
        돌
        1  2  3  4  5
        sk cy sk cy sk ...
        * 홀수 인경우 sk, 짝수 인경우 cy
        *
        * */

        if( N % 2 == 0 ){
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
