import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // 한시간 일하면 쌓이는 피로도 양
        int B = Integer.parseInt(st.nextToken());   // 한 시간 단위로 처리하는 일의 양
        int C = Integer.parseInt(st.nextToken());   // 한 시간 단위로 쉬면 감소하는 피로도 양
        int M = Integer.parseInt(st.nextToken());   // 허용 가능한 피로도 최대치


        int maxJob = 0;             // 현재 일의 양
        int currentFatigue = 0;     // 현재 피로도 양

        // 하루에 일할 수 있는 양은 ?
        for(int hour=1; hour<=24; hour++) {

            // 휴식
            if (M < (currentFatigue + A)) {
                currentFatigue -= C;
                if(currentFatigue < 0) { currentFatigue = 0; }

            }

            // 일
            else {
                currentFatigue += A;
                maxJob += B;
            }

        }

        System.out.println(maxJob);
    }


}
