import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list[];
    static int[] visited_node;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  트리의 정점 개수
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }

        visited_node = new int[N+1];

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 그래프 생성 끝

        // 문제 질문 리스트
        int q = Integer.parseInt(br.readLine());

        for(int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());   // [1: 단절점, 2: 단절선]
            int k = Integer.parseInt(st.nextToken());   // k번째 노드/간선이 단절점|단절선 인지 파악 => 'no' Or 'Yes'

            // 함수 호출

            if( t == 1 ) {      // 단절점 인가 ? ( Start, End 인경우 무조건 no 나머지는 무조건 yes )

                if(list[k].size() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }

            } else {
                System.out.println("yes");  // 하나의 선으로 구성된 트리 형태
            }
        }

    }



}
