package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.02.21
 * @see https://www.acmicpc.net/problem/1012
 * @performance 13404 kb	104 ms
 * @category #dfs
 * @note
 */

public class BAEKJOON_S2_1012_유기농배추 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,K,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			cnt = 0;
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			visited = new boolean[N][M];
			map = new int[N][M];
			for(int k=0; k<K; k++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
					
				}
			}
			
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
	}
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+deltas[i][0];
			int ny = y+deltas[i][1];
			
			if(check(nx,ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
	
	public static boolean check(int x, int y) {
		return 0<= x && x<N && 0<= y && y<M;
	}
}
