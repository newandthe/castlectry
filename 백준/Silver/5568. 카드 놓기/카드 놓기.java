import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static Set<String> arr = new HashSet<>();       // 중복 없이 저장
        public static void main(String[] args) throws IOException {
        
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());       // 카드 장수
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());       // 몇 장을 선택 ?




        int[] cards = new int[n];       // 카드 담을 임시 배열 생성
        boolean[] visited = new boolean[n];   // 각 카드의 방문 여부를 체크할 배열

        for(int i=0; i<n; i++){         // 차례로 입력받기 (카드 숫자들)
            st = new StringTokenizer(br.readLine());
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 조합 생성
        generateCombinations(cards, visited, 0, k, "");

        // 결과 출력 (Set에 저장된 문자열의 개수)
        System.out.println(arr.size());

    }

    private static void generateCombinations(int[] cards, boolean[] visited, int depth, int k, String current) {

        if (depth == k) {
            arr.add(current);   // Set에 중복 없이 추가
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {   // 아직 방문하지 않은 카드라면
                visited[i] = true;
                generateCombinations(cards, visited, depth + 1, k, current + cards[i]);
                visited[i] = false;   // 재귀 호출 후 다시 방문 표시 해제
            }
        }

    }

}
