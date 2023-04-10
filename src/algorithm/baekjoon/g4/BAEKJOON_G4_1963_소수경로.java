package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.10
 * @see https://www.acmicpc.net/problem/1963
 * @performance 12396 kb	84 ms
 * @category # 에라토스테네스의 체, bfs
 * @note
 */


public class BAEKJOON_G4_1963_소수경로 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, a, b, cnt;
	static int N = 10000;
	static boolean[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		T= Integer.parseInt(input.readLine());
		
		arr = new boolean[N+1];
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i=2; i*i<=N; i++) {
			if(arr[i]) continue;
			
			for(int j=i*i; j<=N; j+=i) {
				arr[j] = true;
			}
		}
		
		for(int test_case=0; test_case<T; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			visited = new boolean[N+1];
			cnt = 0;
			
			bfs();
		
			output.append(cnt).append("\n");
		}
		System.out.println(output);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int j=0; j<size; j++) {
				int number = q.poll();
				
				if(number == b) return;
				
				int num1 = number/1000;
				int num2 = number/100%10;
				int num3 = number/10%10;
				int num4 = number%10;
				
				for(int i=1; i<=9; i++) {
					if(i == num1) continue;
					
					int n = i*1000+num2*100+num3*10+num4;
					
					if(!arr[n] && !visited[n]) {
						visited[n] = true;
						q.add(n);
					}
				}
				
				for(int i=0; i<=9; i++) {
					if(i == num2) continue;
					
					int n = num1*1000+i*100+num3*10+num4;
					
					if(!arr[n] && !visited[n]) {
						visited[n] = true;
						q.add(n);
					}
				}
				
				for(int i=0; i<=9; i++) {
					if(i == num3) continue;
					
					int n = num1*1000+num2*100+i*10+num4;
					
					if(!arr[n] && !visited[n]) {
						visited[n] = true;
						q.add(n);
					}
				}
				
				for(int i=0; i<=9; i++) {
					if(i == num4) continue;
					
					int n = num1*1000+num2*100+num3*10+i;
					
					if(!arr[n] && !visited[n]) {
						visited[n] = true;
						q.add(n);
					}
				}
			}
			cnt++;
		}
		
	}
}
