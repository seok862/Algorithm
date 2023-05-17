package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.17
 * @see https://www.acmicpc.net/problem/14503
 * @performance 11872 kb	84 ms
 * @category # 시뮬레이션
 * @note
 */

public class BAEKJOON_G5_14503_로봇청소기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cnt, r, c, dir;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		tokens = new StringTokenizer(input.readLine());
		
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		dir = Integer.parseInt(tokens.nextToken());
		
		cnt = 1;
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		dfs(r,c,dir);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r, int c, int dir) {
		
		map[r][c] = -1;

		for(int i=0; i<4; i++) {
			dir = (dir+3)%4;
			
			int nr = r+deltas[dir][0];
			int nc = c+deltas[dir][1];
			
			if(!isIn(nr,nc) || map[nr][nc] != 0) continue;
			
			cnt++;
			dfs(nr,nc,dir);
			
			return;
		}
		
		int back = (dir+2)%4;
		int br = r + deltas[back][0];
		int bc = c + deltas[back][1];
		
		if(isIn(br,bc) && map[br][bc] != 1) {
			dfs(br,bc,dir);
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
}
