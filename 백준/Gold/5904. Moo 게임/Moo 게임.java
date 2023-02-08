import java.util.Scanner;

public class Main {

	public static char arr[] = { 'm', 'o', 'o' };
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		moo(N, 1, 3);
		
	}

	public static void moo(int N, int level, int leng) {
		int next_length = leng*2 + level + 3;
		
		if(N <= 3) { // S(1)의 경우
			System.out.println((arr[N-1]));
		}
		
		
		else if( next_length < N){
			moo(N, level+1, next_length);
		}
		
		else {
			
				if( N > leng && N <= leng + level + 3 ) { // 사이에 있다면
					if(N-leng == 1) {
						System.out.println('m');
						return;
					}
					else {
						System.out.println('o');
						return;
					}
				}
				else { // 사이에 있지 않다면
					moo(N-(leng+level+3), 1, 3);
				}
			
		}
		
	}	// 함수의 끝
}
