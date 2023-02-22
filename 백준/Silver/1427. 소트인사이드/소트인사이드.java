// import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		
		String num = sc.next();
		
		
		
		// System.out.println(num);
		int counting_sort[] = new int[10];
		
		// char n = num.charAt(0);

		// System.out.println(n - '0' + 1);
		// System.out.println(n - '0');
		
		
		
		// * 인덱스 번호를 입력 값처럼 사용
		  for (int i = 0; i < num.length(); i++) {
			  counting_sort[num.charAt(i) - '0']++;
		  }
		
		// System.out.println(Arrays.toString(counting_sort));
		
		  
		// 내림차순 출력
		// counting sort 배열의 인덱스 번호가 곧 값처럼 저장되어있으니 하나씩 빼며 출력!
		for (int i = 9; i >= 0; i--) {
			while (counting_sort[i]-- > 0) {
				System.out.print(i);
			}
			
		}
		
	}
}