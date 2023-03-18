package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.15
 * @see https://www.acmicpc.net/problem/12191
 * @performance 11552 kb	76 ms
 * @category #백트래킹
 * @note	풀이과정 검색함
 */

public class BAEKJOON_S1_12101_123더하기2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	static int cnt;
	static int[] visited = new int[11];
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		dfs(0,0);
		
		if(cnt != K) {
			System.out.println(-1);
		}
	}
	
	public static boolean dfs(int lv, int sum) {
		if(sum > N) {
			return false;
		}
		
		if(sum == N) {
			cnt++;
			
			if(cnt == K) {
				for(int i=0; i<lv-1; i++) {
					System.out.print(visited[i]+"+");
				}
				System.out.println(visited[lv-1]);
			return true;
			}
		}
		
		for(int i=1; i<=3; i++) {
			visited[lv] = i;
			if(dfs(lv+1,sum+i)) return true;
		}
		
		return false;
	}
}
