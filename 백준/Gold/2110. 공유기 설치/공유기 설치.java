import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
		
		Scanner sc = new Scanner(System.in);
		
		// 집 개수
		int N = sc.nextInt();
		
		// 공유기 개수
		int C = sc.nextInt();
		
		int arr[] = new int[N];
		
		// 집 좌표 입력 받기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		// 이진탐색 위해서 정렬
				
		int min = 1;	// 첫번째집에 무조건 설치
		int max = arr[N-1] - arr[0];	// 가능한 최대 거리
		int leng = 0;
		int ans = 0;
		
		while(min<=max) {
			int count=1; // 첫번째 공유기
			int before_X = arr[0];
			
			// 중간지점부터 이분탐색
			int mid = (min+max)/2;
			
			// 공유기 설치시작
			for(int i=1; i<N; i++) {
				if(arr[i]-before_X >= mid) {
					count++;
					before_X = arr[i];
				}
			}
			
			if(count>=C) {// 집 사이 거리를 적당히 설정하였다면
				ans = mid;
				
				min = mid+1;
				
			}else {	// 집 사이 거리를 너무 넓게 설정하였다면
					// 간격을 더 좁혀간다
				max = mid-1;
				
			}
		}
		
		System.out.println(ans);
	}

}

