import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer> list[];
    static int[] arr;

    static boolean isVisited[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 방문 체크 여부
        isVisited = new boolean[N+1];

        // N 번 노드가 연결되어있는 배열 정보 생성
        arr = new int[N+1];
        list = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1); // root = 1


        for (int i=2; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

    }

    private static void dfs(int node) {
        isVisited[node] = true;

        for(int i: list[node]) {
            if(!isVisited[i]) {
                arr[i] = node;
                dfs(i);
            }

        }
    }

}
