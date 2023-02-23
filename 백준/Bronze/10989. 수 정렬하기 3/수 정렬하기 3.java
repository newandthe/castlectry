import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int count_sorting[] = new int[10001];	// 0포함 1~10000까지의 수 10001개
		
		
		int N = Integer.parseInt(br.readLine());
		
		int num=0;
		for (int i = 0; i < N; i++) {	// 모든 값을 입력 받아 인덱스 번호를 값처럼 사용
			num = Integer.parseInt(br.readLine());
			
			count_sorting[num]++;
		}
		
		br.close();
		
		StringBuilder stb = new StringBuilder();
		
		// 카운트 정렬의 모든 값들을 오름차순으로 출력
		for (int i = 0; i < count_sorting.length; i++) {
			
			while(count_sorting[i] > 0) {
				stb.append(i).append("\n");
				count_sorting[i]--;
			}
		}
		
		System.out.println(stb);
		
	} // 메인의 끝
	
	
	
	


}

