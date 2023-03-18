package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.19
 * @see https://www.acmicpc.net/problem/7576
 * @performance 119736 kb	580 ms
 * @category # bfs
 * @note
 */

public class BAEKJOON_G5_7576_토마토 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int N,M;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		bfs(N,M);
		System.out.println(output.toString());
	}
	
	static void bfs(int N, int M) {
		Queue<Point> q = new LinkedList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					q.add(new Point(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x+deltas[i][0];
				int ny = p.y+deltas[i][1];
				
				if(isIn(nx, ny) && map[nx][ny] == 0) {
					map[nx][ny] = map[p.x][p.y]+1;
					q.add(new Point(nx,ny));
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					output.append("-1");
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		output.append(max-1);
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x && x<M && 0<=y && y<N;
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
