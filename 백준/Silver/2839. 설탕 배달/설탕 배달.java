import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int five = N/5;
		int left_kg = N%5;
		
		int ans = -1;
		
		
		
		for (int i = five; i >= 0; i--) {	// 최대한 적은 봉지 개수를 들기 위해 5키로로 최대한 나눈다.

			if(left_kg % 3 == 0) {
				ans = i + (left_kg/3);
				
				break;
			}
			
			left_kg += 5;
		}
		
		System.out.println(ans);
	}

}
