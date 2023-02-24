package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/10971
 * @performance 12168 kb	96 ms
 * @category # 백트래킹
 * @note
 */

public class BAEKJOON_S2_10971_외판원순회2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,sum,min;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,i,0,0);
		}
		
		System.out.println(min);
	}
	
	public static void dfs(int first, int nowCity, int sum, int lv) {
		if(lv == N-1) {
			if(arr[nowCity][first] != 0) {
				sum += arr[nowCity][first];
				min = Math.min(min, sum);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && arr[nowCity][i] != 0) {
				visited[i] = true;
				
				if(sum+arr[nowCity][i] <= min) {
					dfs(first, i, sum+arr[nowCity][i],lv+1);
				}
				
				visited[i] = false;
			}
		}
	}
}
