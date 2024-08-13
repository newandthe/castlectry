import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean[] visited_dfs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 노드 시작 번호

        boolean visited[] = new boolean[N + 1]; // 방문 여부를 검사할 배열
        visited_dfs = new boolean[N + 1];
        // 0번 인덱스 사용 X => N+1개
        LinkedList<Integer>[] adjList = new LinkedList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }


        // 인접리스트 생성 및 초기화

        // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        // 입력으로 주어지는 간선은 양방향이다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬
        }

        // ("BFS - 인접리스트");
        dfs(V, adjList);
        System.out.println();   // 줄바꿈
        bfs_list(V, adjList, visited);
    }

    // BFS - 인접리스트
    public static void bfs_list(int V, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[V] = true;
        queue.add(V);

        while(queue.size() != 0) {
            V = queue.poll();
            System.out.print(V + " ");

            Iterator<Integer> iter = adjList[V].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(! visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }




    // DFS - 재귀
    public static void dfs(int V, LinkedList<Integer>[] adjList) {

        visited_dfs[V] = true;  // 방문 처리

        System.out.print(V + " ");
//        System.out.println(Arrays.deepToString(adjList));

        for(int i=0; i<adjList[V].size(); i++) {

            if(!visited_dfs[adjList[V].get(i)]) {
                dfs(adjList[V].get(i), adjList);
            }
        }

    }
}
