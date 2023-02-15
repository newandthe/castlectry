import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int L=-1, P=-1, V=-1;
		int count = 1;
		int ans=0;
		int temp=-1;
		while( true ) {
			L = sc.nextInt();
			P = sc.nextInt();
			V = sc.nextInt();
			if(L == 0 && P == 0 && V == 0) {
				break;
			}
			temp = V/P;
			ans += temp*L;
			
			if(V%P < L) {
				temp = V%P;
			}
			else {
				temp = L;
			}
			ans += temp;
			
			list.add(ans);
			count++;
			ans = 0;
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Case " + (i+1) + ": " + list.get(i) );
		}
	}

}
