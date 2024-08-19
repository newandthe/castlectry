import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 체스말 이동 방향
    static int[][] horseMoves = { {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1} };

    // 상하좌우 이동 방향
    static int[][] monkeyMoves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    static int[][] map;
    static int W, H, K;

    static class State {
        int x, y, depth, remainingK;
        State(int x, int y, int depth, int remainingK) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.remainingK = remainingK;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int y = 0; y < H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < W; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.x == W - 1 && current.y == H - 1) {
                return current.depth;
            }

            // 원숭이 이동
            for (int[] move : monkeyMoves) {
                int nx = current.x + move[0];
                int ny = current.y + move[1];

                if (isValid(nx, ny) && !visited[ny][nx][current.remainingK]) {
                    visited[ny][nx][current.remainingK] = true;
                    queue.add(new State(nx, ny, current.depth + 1, current.remainingK));
                }
            }

            // 말 이동
            if (current.remainingK > 0) {
                for (int[] move : horseMoves) {
                    int nx = current.x + move[0];
                    int ny = current.y + move[1];

                    if (isValid(nx, ny) && !visited[ny][nx][current.remainingK - 1]) {
                        visited[ny][nx][current.remainingK - 1] = true;
                        queue.add(new State(nx, ny, current.depth + 1, current.remainingK - 1));
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H && map[y][x] == 0;
    }
}
