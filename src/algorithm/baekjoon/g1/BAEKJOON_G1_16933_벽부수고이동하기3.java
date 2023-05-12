package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.12
 * @see https://www.acmicpc.net/problem/16933
 * @performance	699936 kb	4764 ms	
 * @category # bfs
 * @note
 */


public class BAEKJOON_G1_16933_벽부수고이동하기3 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,K;
	static int[][] map;
	static boolean[][][][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static ArrayDeque<Point> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1][2];
		
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c)-'0';
			}
		}
		
		q.add(new Point(0,0,0,1,0));
		bfs();
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				System.out.println(p.len);
				System.exit(0);
			}
			for(int i=0; i<4; i++) {
				int nr = p.r+deltas[i][0];
				int nc = p.c+deltas[i][1];
				
				if(!isIn(nr,nc)) continue;
				
				int now = p.now==1?0:1;

				if(visited[nr][nc][p.cnt][p.now]) continue;
				
				
				if(map[nr][nc] == 1) {
					if(p.cnt == K) continue;
					
					if(p.now == 1) {
						visited[p.r][p.c][p.cnt][p.now] = true;
						q.add(new Point(p.r, p.c, p.cnt, p.len+1, now));
					}else {
						visited[nr][nc][p.cnt][p.now] = true;
						q.add(new Point(nr, nc, p.cnt+1, p.len+1, now));
					}
				}else {
					visited[nr][nc][p.cnt][p.now] = true;
					q.add(new Point(nr, nc, p.cnt, p.len+1, now));
				}
			}
		}
		System.out.println(-1);
	}
	
	public static class Point{
		int r;
		int c;
		int cnt;
		int len;
		int now;
		public Point(int r, int c, int cnt, int len, int now) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.len = len;
			this.now = now;
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<= r && r < N && 0 <= c && c < M;
	}
}