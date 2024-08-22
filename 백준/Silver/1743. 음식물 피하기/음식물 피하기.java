import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static boolean[][] trashMap;
    static boolean[][] visited;

    static int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        trashMap = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;  // 행 (0-based index)
            int c = Integer.parseInt(st.nextToken()) - 1;  // 열 (0-based index)
            trashMap[r][c] = true;  // 쓰레기 존재 좌표 초기화
        }

        int maxTrashSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (trashMap[i][j] && !visited[i][j]) {
                    int trashSize = bfs(i, j);
                    maxTrashSize = Math.max(maxTrashSize, trashSize);
                }
            }
        }

        System.out.println(maxTrashSize);
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startY, startX});
        visited[startY][startX] = true;

        int trashSize = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            trashSize++;

            for (int[] dir : directions) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && trashMap[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny, nx});
                }
            }
        }

        return trashSize;
    }
}
