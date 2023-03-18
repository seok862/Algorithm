package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G4_9663_NQueen {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,-1},{1,-1},{-1,1},{1,1}};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		cnt = 0;
		map = new int[N][N];
		visited = new boolean[N][N];
		dfs(0);
	}
	
	public static void dfs(int lv) {
		if(lv == N) {
			cnt++;
			return;
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 0  && !visited[r][c]) {
					changeVisited(r,c);
					dfs(lv+1);
				}
			}
		}
	}
	
	public static void changeVisited(int r, int c) {
		for(int i=0; i<N; i++) {
			if(visited[r][i]) {
				visited[r][i] = false;
			}else {
				visited[r][i] = true;
			}
		}
		for(int i=0; i<N; i++) {
			if(visited[i][c]) {
				visited[i][c] = false;
			}else {
				visited[i][c] = true;
			}
		}
		
		for(int i=0; i<4; i++) {
			int index = 1;
			
			while(index < N) {
				int nr = r+deltas[i][0]*index++;
				int nc = r+deltas[i][0]*index++;
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					if(visited[nr][nc]) {
						visited[nr][nc] = false;
					}else {
						visited[nr][nc] = true;
					}
				}
			}
			
		}
		
		map[r][c] = 1;
		
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<N && c<=0 && c<N;
	}
	
}
