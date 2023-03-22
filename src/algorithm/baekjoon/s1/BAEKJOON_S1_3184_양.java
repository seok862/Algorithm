package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.20
 * @see https://www.acmicpc.net/problem/3184
 * @performance 18476 kb	172 ms
 * @category # bfs
 * @note
 */

public class BAEKJOON_S1_3184_양 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,O,V;
	static char[][] map;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char[N][M];
		
		for(int r=0; r<N; r++) {
			String tmp = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = tmp.charAt(c);
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != '#') {
					bfs(r,c);
				}
			}
		}
		
		System.out.println(O+" "+V);
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		
		int oCnt = 0;
		int vCnt = 0;
		
		if(map[r][c] == 'o') oCnt++;
		if(map[r][c] == 'v') vCnt++;
		
		q.add(new Point(r,c));
		map[r][c] = '#';
		
		while(!q.isEmpty()) {
			Point nowPoint = q.poll();
			for(int i=0; i<4; i++) {
				int nr = nowPoint.r+deltas[i][0];
				int nc = nowPoint.c+deltas[i][1];
				
				if(isIn(nr,nc) && map[nr][nc]!='#') {
					if(map[nr][nc] == 'o') oCnt++;
					if(map[nr][nc] == 'v') vCnt++;
					
					map[nr][nc] = '#';
					
					q.add(new Point(nr,nc));
				}
			}
		}
		
		if(oCnt > vCnt) O += oCnt;
		else V += vCnt;
	}
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
}
