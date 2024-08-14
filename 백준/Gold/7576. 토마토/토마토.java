import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

 // Queue 사용
public class Main {

    static int M, N;
    static int[][] arr;
    static int[][] pointer = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                if (arr[y][x] == 1) {
                    queue.add(new int[] {y, x});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNewRipen = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cy = current[0];
                int cx = current[1];

                for (int[] dir : pointer) {
                    int ny = cy + dir[0];
                    int nx = cx + dir[1];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && arr[ny][nx] == 0) {
                        arr[ny][nx] = 1;
                        queue.add(new int[] {ny, nx});
                        hasNewRipen = true;
                    }
                }
            }
            if (hasNewRipen) {
                days++;
            }
        }

        for (int[] row : arr) {
            for (int cell : row) {
                if (cell == 0) {
                    return -1;
                }
            }
        }

        return days;
    }

}


/*

public class BOJ_7576 {

    static int M;
    static int N;

    static int[][] arr;

    // 좌표 이동
    static int[][] pointer = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };

    static int result = 0;

    public static void BOJ_7576() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로 칸 수 (Columns)
        N = Integer.parseInt(st.nextToken());   // 세로 칸 수 (Rows)

        arr = new int[N][M];

        // 상자 초기화 (라인 단위로 입력)
        for(int y=0; y<N; y++) {

            st = new StringTokenizer(br.readLine());

            for(int x=0; x<M; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }

        }

//        System.out.println(Arrays.deepToString(arr));


        // 검사 Start

        if(isLocked()) {
            System.out.println("-1");
        } else {

            // 다음 좌표
            func:
            while(true) {
                boolean visit[][] = new boolean[N][M];

                visit = isSet(visit);

                for(int x=0; x<M; x++) {
                    for( int y=0; y<N; y++) {

                        if(visit[y][x] && arr[y][x] == 1) {

                            for(int i=0; i<4; i++) {

                                // 이동 하고자 하는 좌표
                                int px = x + pointer[i][0];
                                int py = y + pointer[i][1];

                                if(px>=0 && py>=0 && px<M && py<N && arr[py][px] != -1 && visit[y][x]) {

    //                                System.out.println("px " + px + " py " + py);
                                    arr[py][px] = 1;
                                }
                            }
                        }

                    }
                }
//                System.out.println(Arrays.deepToString(arr));


                result++;

                if(isEnd()) {
                    System.out.println(result);
                    break func;
                }

            }
        }

    }

    private static boolean isLocked() {

        for(int x=0; x<M; x++) {
            for (int y = 0; y < N; y++) {

                int count = 0;

                for(int i=0; i<4; i++) {

                    // 이동 하고자 하는 좌표
                    int px = x + pointer[i][0];
                    int py = y + pointer[i][1];

                    if(px<0 || py<0 || px>=M || py>=N || arr[py][px] == -1) {

                        count++;

                    }
                }
                if(count == 4) {
                    return true;
                }

            }
        }

        return false;
    }

    private static boolean isEnd() {

        for(int x=0; x<M; x++) {
            for (int y = 0; y < N; y++) {
                if(arr[y][x] == 0) {
                    return false;   // 더 해야함
                }
            }
        }

        return true;    // 종료
    }

    private static boolean[][] isSet(boolean visit[][]) {

        for(int x=0; x<M; x++) {
            for (int y = 0; y < N; y++) {
                if(arr[y][x] == 1) {
                    visit[y][x] = true;
                }
            }
        }

        return visit;

    }

}
*/
