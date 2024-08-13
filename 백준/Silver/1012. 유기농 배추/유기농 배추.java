import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우
    static int[][] drdx = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int[][] arr;

    static int maxColSize;

    static int maxRowSize;

    // 방문 여부
    static boolean[][] visited;

    // 결과 값
    static int result = 0;

        public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){


            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = maxColSize = Integer.parseInt(st.nextToken());   // 가로 길이
            int N = maxRowSize = Integer.parseInt(st.nextToken());   // 세로 길이
            int K = Integer.parseInt(st.nextToken());   // 개수

            arr = new int[M][N];
            visited = new boolean[M][N];

            for (int i=0; i<K; i++) {

                // 좌표 입력
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 존재 위치 초기화
                arr[x][y] = 1;

            }


            for(int x=0; x<M; x++) {
                for(int y=0; y<N; y++) {

                    if(!visited[x][y] && arr[x][y] == 1){

                        result += 1;
                        movePoint(x, y);
                    }

                }
            }
            System.out.println(result);
            result = 0; // 결과 값 초기화

        }


    }

    public static void movePoint(int x, int y) {

        visited[x][y] = true;

        // 4방향 접근
        for(int i=0; i<4; i++) {

            int px = x + drdx[i][0];
            int py = y + drdx[i][1];


            if( px >= 0 && py >= 0 && px < maxColSize && py < maxRowSize && visited[px][py] == false && arr[px][py] == 1){
                movePoint(px, py);
            }

        }


    }

}
