import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[][] movePoint = { {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1} };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        input();

    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        // 테스트 케이스 만큼 반복
        for (int i = 0; i < T; i++) {

            int I = Integer.parseInt(br.readLine());    // 한변의 길이 I인 정 사각형
            map = new int[I][I];                        // 지도 새로 생성
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 시작 좌표
            int initPointX = Integer.parseInt(st.nextToken());
            int initPointY = Integer.parseInt(st.nextToken());

            // 목적지 좌표
            st = new StringTokenizer(br.readLine());
            int goalPointX = Integer.parseInt(st.nextToken());
            int goalPointY = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();

            queue.add(new int[] {initPointX, initPointY});
            visited[initPointX][initPointY] = true;

            endPoint :
            while (!queue.isEmpty()) {
                int[] point = queue.poll();

                int x = point[0];
                int y = point[1];

                visited[x][y] = true;

                for (int j=0; j< movePoint.length; j++) {

                    int px = x + movePoint[j][0];
                    int py = y + movePoint[j][1];

                    if(px >= 0 && py >= 0 && px < I && py < I && !visited[px][py] && map[px][py] == 0) {
                        visited[px][py] = true;
                        map[px][py] = map[x][y] + 1;

                        if (px == goalPointX && py == goalPointY) {
//                            System.out.println("!!!!!!!!!!!!!!");
//                            System.out.println(goalPointX + " " + goalPointY);
                            break endPoint;
                        }

                        queue.add(new int[] {px, py});
                    }

                }


            }

//            System.out.println(Arrays.deepToString(map));

            System.out.println(map[goalPointX][goalPointY]);


        }


    }

}
