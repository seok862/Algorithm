package algorithm.baekjoon.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.21
 * @see https://www.acmicpc.net/problem/11170
 * @performance 12512 kb	192 ms
 * @category # 브루트포스
 * @note
 */

public class BAEKJOON_B2_11170_0의개수 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,T;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			int cnt = 0;
			
			for(int i=N; i<=M; i++) {
				int n=i;
				
				if(n==0) {
					cnt++;
					continue;
				}
				
				while(n>1) {
					if(n%10 == 0) {
						cnt++;
					}
					n /= 10;
				}
			}
			
			System.out.println(cnt);
		}
		
	}
}
