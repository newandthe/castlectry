import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] even = { {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {0, 1} };
    static int[][] odd =  { {-1, 0}, {1, 0}, {0, -1}, {1, -1}, {0, 1}, {1, 1} };

    static int[][] map;
    static boolean[][] visited;
    static int W, H;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 2][W + 2];
        visited = new boolean[H + 2][W + 2];

        for (int y = 1; y <= H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= W; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 외부 영역을 탐색하고 외벽의 길이를 계산
        BFS();
        System.out.println(result);
    }

    private static void BFS() {
        Queue<int[]> queue = new ArrayDeque<>();
        // 외부의 빈 공간을 큐에 추가
        for (int i = 0; i <= H + 1; i++) {
            for (int j = 0; j <= W + 1; j++) {
                if (i == 0 || i == H + 1 || j == 0 || j == W + 1) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        queue.add(new int[]{j, i});
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            int[][] directions = (y % 2 == 0) ? even : odd;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < W + 2 && ny < H + 2) {
                    if (map[ny][nx] == 1) {
                        result++;
                    } else if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}


/*
// 하단은 기존 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5547 {

    // 짝수인 경우 이동 가능 좌표 0, 2, 4 ...
    static int[][] even = { {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {0, 1} };

    // 홀수인 경우 이동 가능 좌표 1, 3, 5 ...
    static int[][] odd =  { {-1, 0}, {1, 0}, {0, -1}, {1, -1}, {0, 1}, {1, 1} };

    static int[][] map;
    static boolean[][] visited;
    static int[][] resultMap;

    static int W, H, result = 0;    // 가로, 세로 길이

    // [0] : X 좌표, [1] : Y 좌표
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void BOJ_5547() throws IOException {

        // 값 입력 받기
        input();

//        System.out.println(Arrays.deepToString(map));

        // map 에서 0을 기준 - 이동 가능한 좌표 1인 값 찾기
        BFS();

//        System.out.println(Arrays.deepToString(resultMap));

        // 테두리 개수 모두 세서 출력
        resultPrint();

    }

    private static void resultPrint() {



        for (int i = 0; i < resultMap.length; i++) {
            for (int j = 0; j < resultMap[i].length; j++) {
                result += resultMap[i][j];
            }
        }

        System.out.println(result);

    }

    */
/*
    * -- 전체 선의 개수 = 6 * N - 2 * (인접한 면의 개수) -- X
    * -- > 인접면 개수를 구하는 방식이 너무 어려움 ..
    *
    * -- 0일 경우 탐색 진행 하여 인접 면의 1의 개수 만큼 세주면 외벽의 테두리 합치면 된다..!! -- O
    * + 외벽 하나씩 더 안 붙이게 되는 경우 -- 바깥 테두리 개수 못구함 ..
    * *//*

    private static void BFS() {

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

//            System.out.println(arr[0] + " " + arr[1]);
            int x = arr[0];
            int y = arr[1];

            visited[y][x] = true;

            // y가 짝수 인 경우 방향 좌표
            if(y%2 == 0) {

                int cnt = 0;

                for (int[] ints : even) {

                    int px = x + ints[0];
                    int py = y + ints[1];

                    // 1인 경우 에만 외벽 맞닿는 개수 세기
                    if (canAccept(px, py) && map[py][px] == 1) {
                        cnt++;
                    } else if (canAccept(px, py) && map[py][px] == 0 && !visited[py][px]) {
                        queue.add(new int[]{px, py});
                    }


                }

                // 모두 둘러 쌓여 있다면, cnt = 6 이고, 이는 내부에 있어서 외벽 갯수 셀 필요 X
                if(cnt != 6){
                    resultMap[y][x] = cnt;
                }

            }
            // y가 홀수 인 경우 방향 좌표
            else {
                int cnt = 0;

                for (int[] ints : odd) {

                    int px = x + ints[0];
                    int py = y + ints[1];

                    // 1인 경우 에만 외벽 맞닿는 개수 세기
                    if (canAccept(px, py) && map[py][px] == 1) {
                        cnt++;
                    } else if (canAccept(px, py) && map[py][px] == 0 && !visited[py][px]) {
                        queue.add(new int[]{px, py});
                    }

                }

                if(cnt != 6){
                    resultMap[y][x] = cnt;
                }

            }

        }

    }

    private static boolean canAccept(int px, int py) {

        // 범위 내 && 아직 방문 X
        return px >= 0 && py >= 0 && px < W+2 && py < H+2 && !visited[py][px];
    }


    // map 초기화 (입력)
    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());   // 가로 길이
        H = Integer.parseInt(st.nextToken());   // 세로 길이

        map = new int[H+2][W+2];
        visited = new boolean[H+2][W+2];
        resultMap = new int[H+2][W+2];

        for (int y=1; y<H+1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=1; x<W+1; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0) {
                    queue.add(new int[]{x, y});
                }

                map[y][x] = tmp;
            }
        }

    }
}
*/
