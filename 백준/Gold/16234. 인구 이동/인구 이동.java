import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pointer = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };  // 상, 하, 좌, 우 이동

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(simulate());
    }

    private static int simulate() {
        int resultDay = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int populationSum = bfs(i, j);
                        if (populationSum > 0) {
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break;
            resultDay++;
        }

        return resultDay;
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int populationSum = map[x][y];
        int countryCount = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int[] direction : pointer) {
                int nx = cx + direction[0];
                int ny = cy + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);

                    if (diff >= L && diff <= R) {
                        queue.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        populationSum += map[nx][ny];
                        countryCount++;
                    }
                }
            }
        }

        if (countryCount > 1) {
            int newPopulation = populationSum / countryCount;
            for (int[] country : union) {
                map[country[0]][country[1]] = newPopulation;
            }
            return populationSum;
        }

        return 0;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
