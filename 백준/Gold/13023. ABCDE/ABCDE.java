import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M; // 사람의 수, 친구 관계의 수
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static boolean result = false;

    public static void main(String[] args) throws IOException {

        /*
        * 총 Depth ==> 4번 연결 되는 테스트 케이스 존재 하면 백트래킹 && sout 1 else sout 0
        * -- 중복 관계 없음
        * */

        input();

//        System.out.println(Arrays.toString(adj));

//        BFS or DFS
        for (int i = 0; i < N; i++) {
            if(result) break;
            DFS(visited, i, 0);
        }

        if(result){
//            System.out.println("###############");
            System.out.println(1);
        } else {
//            System.out.println("###############");
            System.out.println(0);
        }


    }



    // 시간 초과
    private static void DFS(boolean[] visited, int node, int depth) {

        if(depth == 4){
            result = true;
            return;
        }

        if(visited[node]) return;

        visited[node] = true;

        for (int i = 0; i < adj[node].size(); i++) {
            if (!visited[adj[node].get(i)]) {
                DFS(visited, adj[node].get(i), depth + 1);
            }
        }

        visited[node] = false;
    }


    // 사용자 입력 및 초기화
    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        adj = new ArrayList[N];

        // ArrayList 초기화 필수 작업
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {

            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);

        }




    }
}
