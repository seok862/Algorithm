package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.30
 * @see https://www.acmicpc.net/problem/7562
 * @performance 71412 kb	244 ms
 * @category #bfs
 * @note
 */ 

public class BAEKJOON_S1_7562_나이트의이동 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static int[][] map;
	static Point[] points;
	static int[][] deltas = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			
			map = new int[N][N];
			
			points = new Point[2];
			
			for(int i=0; i<2; i++) {
				tokens = new StringTokenizer(input.readLine());
				
				int start = Integer.parseInt(tokens.nextToken());
				int end = Integer.parseInt(tokens.nextToken());
				
				points[i] = new Point(start, end, 0);
			}
			
			int ans = bfs(N);
			output.append(ans).append("\n");
		}
		System.out.println(output);
	}
	public static int bfs(int N) {
		Queue<Point> q = new LinkedList<>();
		q.offer(points[0]);
		
		boolean[][] visited = new boolean[N][N];
		visited[points[0].r][points[0].c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == points[1].r && p.c == points[1].c) {
				return p.cnt;
			}
			
			for(int i=0; i<8; i++) {
				int dr = p.r + deltas[i][0];
				int dc = p.c + deltas[i][1];
				
				// 범위가 벗어날 경우
				
				if( dr < 0 || dc< 0 || dr>=N || dc >= N) {
					continue;
				}
				
				if(!visited[dr][dc]) {
					visited[dr][dc] = true;
					q.offer(new Point(dr, dc, p.cnt+1));
				}
			}
		}
		return -1;
	}
	
	public static class Point{
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
