import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] map;
    static boolean[][][] visited;

    // z, y, x
    static Queue<int[]> queue = new ArrayDeque<>();

    static int N, M, H, result = 0;

    // Z, Y, X 축
    // Z축 +-1, 평면 상하좌우 이동 가능 좌표
    static int[][] movePoint = { {-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1} };

    public static void main(String[] args) throws IOException {

        input();
        BFS();

//         System.out.println(Arrays.deepToString(map));
        if(result()){
            System.out.println(result - 1);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean result() {

        for(int[][] map: map){
            for (int[] map2: map){
                for (int map3: map2) {
                    if (map3 == 0) {
                        return false;
                    } else {
                        result = Math.max(map3, result);
                    }
                }
            }
        }
        return true;
    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int z = point[0];
            int y = point[1];
            int x = point[2];

            visited[z][y][x] = true;    // 방문 체크

//            System.out.println(z + " " + y + " " + x);
//            System.out.println();

            for (int[] i: movePoint) {
//                System.out.println(i[0] + " " + i[1] + " " + i[2]);
                int pz = z + i[0];
                int py = y + i[1];
                int px = x + i[2];

                // 범위 내이며 방문 하지 않았고 이동 가능한 경우
                if(pz >= 0 && py >= 0 && px >= 0 && pz < H && py < N && px < M && !visited[pz][py][px] && map[pz][py][px] == 0) {
                    map[pz][py][px] = map[z][y][x] + 1;   // 인접한 토마토 좌표 이동시 익히기 ( 0인경우 아직 방문처리 X, 좌표 이동과 동시에 count + 1 로 일자 표시하며 익혀나가기 )
                    queue.add(new int[] {pz, py, px});
                }
            }
        }

    }


    /*
    * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 비어 있는 공간
    * 상하좌우 및 Z축 +-1 좌표에 영향을 줌.
    * */
    // 입력 및 초기화
    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로 칸 수
        N = Integer.parseInt(st.nextToken());   // 세로 칸 수
        H = Integer.parseInt(st.nextToken());   // 상자 쌓아 올린 높이

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int z = 0; z < H; z++) {

            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    int tmp = Integer.parseInt(st.nextToken());

                    if(tmp == 1) {
                        queue.add(new int[] {z, y, x});
                    }

                    map[z][y][x] = tmp;
                }
            }

        }

    }


}
