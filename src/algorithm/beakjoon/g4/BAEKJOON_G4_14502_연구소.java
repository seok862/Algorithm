package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.20
 * @see https://www.acmicpc.net/problem/14502
 * @performance 294984 kb	708 ms
 * @category # dfs + bfs
 * @note
 */

public class BAEKJOON_G4_14502_연구소 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,M,ans;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		ans = 0;
		map = new int[N][M];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int lv) {
		if(lv==3) {
			bfs();
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					dfs(lv+1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		int[][] newMap = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				newMap[r][c] = map[r][c];
				if(newMap[r][c] == 2) q.add(new Point(r,c));
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				
				if(check(nx, ny)) {
					if(newMap[nx][ny] == 0) {
						newMap[nx][ny] = 2;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(newMap[r][c] == 0) cnt++;
			}
		}
		
		ans = Math.max(ans, cnt);
	}
	
	public static boolean check(int x, int y) {
		return 0<= x && x < N && 0 <= y && y < M;
	}
}
