import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean bfsCheck[];
	static Queue<Integer> q = new LinkedList<>();
	static int count = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt();	// 컴퓨터의 수
		
		int node = sc.nextInt(); // 네트워크에 연결되어있는 컴퓨터 쌍의 수
		
		// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 (1번 제외)
		
		bfsCheck = new boolean[com+1];
		
		for(int i=0;i<=com;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < node; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		
		bfs(1);
	}	// main 끝
	
	
	static void bfs(int start) {
			
			q.offer(start);
			bfsCheck[start] = true;
			
			while(!q.isEmpty()) {
				
				int from = q.poll();
				// System.out.print(from + " ");
				count += 1;
				
				for (int i = 0; i < graph.get(from).size(); i++) {
					
					int to = graph.get(from).get(i);
					
					if (!bfsCheck[to]) {
						bfsCheck[to] = true;
						q.offer(to);
					}
				}						
			}
			System.out.println(count-1);
		}	
	
	
	

}
