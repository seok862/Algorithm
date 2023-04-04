package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.04.03
* @see https://www.acmicpc.net/problem/3055
* @performance 	11848 kb	84 ms
* @category # bfs
* @note
*/

public class BAEKJOON_G4_3055_탈출 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, ans;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static char[][] map;
	static Queue<Point> q = new LinkedList<>();
	static Queue<Water> water = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String tmp = input.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = tmp.charAt(c);
				
				if (map[r][c] == 'S') {
					q.add(new Point(r, c, 0));
				}else if (map[r][c] == '*') {
					water.add(new Water(r,c));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		
		bfs();
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(ans);
		}
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			int size = water.size();
			
			for(int i=0; i<size; i++) {
				Water w = water.poll();
				
				for(int j=0; j<4; j++) {
					int nr = w.x + deltas[j][0];
					int nc = w.y + deltas[j][1];
					
					if(isIn(nr,nc) && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.add(new Water(nr,nc));
					}
				}
			}
			
			size = q.size();
			
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				
				for(int j=0; j<4; j++) {
					int nr = p.x+deltas[j][0];
					int nc = p.y+deltas[j][1];
					
					if(isIn(nr, nc)) {
						if(map[nr][nc] == 'D') {
							ans = Math.min(ans, p.lv+1);
							return;
						}else if(map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							q.add(new Point(nr,nc,p.lv+1));
						}
					}
				}
			}
		}
	}
	

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static class Water{
		int x;
		int y;
		public Water(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Point {
		int x;
		int y;
		int lv;
		
		public Point(int x, int y, int lv) {
			this.x = x;
			this.y = y;
			this.lv = lv;
		}
	}
}
