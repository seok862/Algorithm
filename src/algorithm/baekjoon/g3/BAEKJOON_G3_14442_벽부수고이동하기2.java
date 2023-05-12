package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.05.12
* @see https://www.acmicpc.net/problem/14442
* @performance 	371708 kb	1600 ms
* @category # bfs
* @note
*/

public class BAEKJOON_G3_14442_벽부수고이동하기2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,K;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c)-'0';
			}
		}
		
		q.add(new Point(0,0,0,1));
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
				
				if(visited[nr][nc][p.cnt]) continue;
				
				if(map[nr][nc] == 1) {
					if(p.cnt == K) continue;
					visited[nr][nc][p.cnt] = true;
					q.add(new Point(nr, nc, p.cnt+1, p.len+1));
				}else {
					visited[nr][nc][p.cnt] = true;
					q.add(new Point(nr, nc, p.cnt, p.len+1));
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
		public Point(int r, int c, int cnt, int len) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.len = len;
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<= r && r < N && 0 <= c && c < M;
	}
}