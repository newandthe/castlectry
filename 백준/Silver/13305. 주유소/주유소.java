import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		
		int bill[] = new int[N];	// 각 도시의 요금 만들기
		int leng[] = new int[N-1];	// 각 도시간의 거리
		
		int state = 0;
		int ans = 0;
		
		for (int i = 0; i < N-1; i++) {
			leng[i] = sc.nextInt();	// 도시간의 거리 입력 받기
		}
		
		for (int i = 0; i < N; i++) {
			bill[i] = sc.nextInt();	// 각 도시의 요금 받기
		}
		
		int min_index = 0; // 최소 요금 인덱스 찾기
		
		for (int i = 1; i < N-2; i++) {			// 마지막을 제외한 최소 요금 찾아내기 
			if(bill[min_index] > bill[i]) {		// min_index에 저장
				min_index = i;
			}
		}
		
		int left_leng = 0;
		// 최소 요금으로부터 마지막 도시까지의 남은 거리
		for (int i = min_index; i < N-1; i++) {
			left_leng += leng[i];
		}
		
		// System.out.println(min_index);
		// 0		1		2		3			각 도시의 인덱스
	    //      0        1       2				각 도시간의 거리
		
		for (int i = 0; i < N-1; i++) {		// 총 이동횟수는 N-1번이다.
			if(i < min_index) {			// 아래는 i -> i에서 i+1번 위치로 이동할때의 계산식
				ans += (bill[i] * leng[i]);
			}
			else {
				ans += (bill[i] * left_leng);
				break;
			}
		}
		
		System.out.println(ans);
	}

}
