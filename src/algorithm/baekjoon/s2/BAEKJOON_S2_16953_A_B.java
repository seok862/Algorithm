package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.01
 * @see https://www.acmicpc.net/problem/16953
 * @performance 15108 kb	104 ms
 * @category # bfs
 * @note
 */

public class BAEKJOON_S2_16953_A_B {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long A,B,cnt;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		A = Long.parseLong(tokens.nextToken());
		B = Long.parseLong(tokens.nextToken());
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				long num = q.poll();
				
				if(num == B) {
					System.out.println(cnt+1);
					System.exit(0);
				}else {
					if(num*2<=B) q.add(num*2);
					if(num*10+1<=B) q.add(num*10+1);
				}
			}
			
			cnt++;
		}
		
		System.out.println(-1);
	}
}
