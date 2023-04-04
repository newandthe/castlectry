import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] water;
	static int[][] check;
	
	
	static int[] move_y = {-1,1,0,0};	// 상   하   좌   우   이동하기 위한 배열
	static int[] move_x = {0,0,-1,1};
	
	static int Max = 1;	// 처음엔 무조건 한개부터 시작
	static int count; // 안전 지역 개수세기위한 변수
	
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		
		arr = new int[N][N];	// 초기 배열 저장.


		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
			
		}
		

		
		for (int i = 1; i <= 100; i++) {	// 물 높이 증가시작. 처음에는 무조건 1
			water = new int[N][N];	// 물이 찼는지 확인 배열	(1이면 물이 찼다!)
			check = new int[N][N]; // 방문 여부 배열 생성.(1이면 방문 했다!)
			// System.out.println("i= " + i);
			count = 0;		// 모든 물높이의 경우의 수를 체크하기 위해 초기화
			

			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					
					if(arr[j][j2] <= i) {
						water[j][j2] = 1;	// 1이 되면 물 차게 된 지역.
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(water[j][j2] != 1 && check[j][j2] != 1) {	// 물이 차지 않았으며, 방문하지 않은 지역을 기준으로 탐색
						move(j, j2);
						count++;
						// System.out.println(count);
					}
				}
			}
			
			Max = Math.max(Max, count);
//			if( Max < count) {
//				System.out.println("Max " + Max);
//				System.out.println("count " + count);
//				Max = count;
//			} 

			
		}
		
		System.out.println(Max);
		
		
	}
	
	public static void move(int j, int j2) {
		check[j][j2] = 1;	// 호출 되자마자 방문 체크
		
		// 4방향 모두 확인 (상 하 좌 우)
		for (int i = 0; i < 4; i++) {
			int x = j + move_y[i];
			int y = j2 + move_x[i];
			
			if(x >= 0 && y >= 0 && x < N && y < N) {	// 이동하고자 하는 곳이 범위 밖이 아니고
				if((water[x][y] != 1) && (check[x][y] != 1)) {	// 물이 차지 않고 방문하지 않았다면.
					move(x, y);	// 다시 재귀를 호출하며 모든 방향 탐색
				}
			}
		}
		
		
	}
}
