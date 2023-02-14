import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tmoney = 1000;
		int bill = sc.nextInt();
		
		tmoney = tmoney - bill;
		int count_c = 0;
		int count = 0;
		
			if(tmoney/500 >= 1) {	// 500엔
				
				tmoney -= 500;
				count++;
			}
			
			if(tmoney/100 >= 1 ) {
				
				count_c = tmoney/100; 
				tmoney -= count_c * 100;
				
				count += count_c; 
				
			}
			
			if(tmoney/50 >= 1) {
				
				count_c = tmoney/50; 
				tmoney -= count_c * 50;
				
				count += count_c;
			}
			
			if(tmoney/10 >= 1) {
				
				count_c = tmoney/10; 
				tmoney -= count_c * 10;
				
				count += count_c;
			}
			
			if(tmoney/5 >= 1) {
				
				count_c = tmoney/5; 
				tmoney -= count_c * 5;
				
				count += count_c;
			}
			
			if(tmoney/1 >= 1) {
				
				count_c = tmoney/1; 
				tmoney -= count_c;
				
				count += count_c;
			}
			
			System.out.println(count);
		}
		

}
