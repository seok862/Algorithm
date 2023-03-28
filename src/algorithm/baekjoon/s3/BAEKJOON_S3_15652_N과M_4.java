package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.26
 * @see https://www.acmicpc.net/problem/15652
 * @performance 15376 kb	108 ms	
 * @category # 백트래킹
 * @note
 */

public class BAEKJOON_S3_15652_N과M_4 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		visited = new boolean[N];
		
		dfs(0,0,new	int[M]);
		
		System.out.println(output);
	}
	
	public static void dfs(int lv, int start, int[] choosed) {
		if(lv == M) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			choosed[lv] = i+1;
			dfs(lv+1, i, choosed);
			visited[i] = false;
		}
	}
}
