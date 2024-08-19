import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static boolean[] visited;
    public static int result = 0;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 검사 회수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 시작
        for (int i = 0; i < T; i++) {

            N = Integer.parseInt(br.readLine());    //  순열의 크기

            // 그래프 초기화
            arr = new int[2][N+1];
            visited = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <=N; j++) {
                arr[0][j] = j;
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            // System.out.println(Arrays.deepToString(arr));
            // 초기화 끝

            for(int check = 1; check <N+1; check++) {
                DFS(check, arr[1][check], check);   // 시작, 다음노드, 최초 시작 노드
            }

            System.out.println(result);

            result = 0;
        } // 테스트 케이스 끝

    }

    public static void DFS (int node, int nextNode, int initNode) {

//        System.out.println("node " + node);

        if(nextNode == initNode) {
            result++;
            return;
        }

        if(visited[node]){
            return;
        }

        visited[node] = true;
        DFS(arr[1][node], arr[1][node], initNode);

    }

}
