package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_G4_3055_탈출 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static char[][] map;
	static int[][] intMap;
	static boolean [][] visited;
static Point end;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		// 물 = *, 돌 = X, 굴 = D, 고슴도치 = S

		map = new char[R][C];
		intMap = new int[R][C];
		visited = new boolean[R][C];
		end = null;
		Point start = null;
		for (int r = 0; r < R; r++) {
			String tmp = input.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = tmp.charAt(c);
				if (map[r][c] == 'D') {
					intMap[r][c] = Integer.MAX_VALUE;
					end = new Point(r, c);
				}
					
				if (map[r][c] == 'S') {
					start = new Point(r, c);
					map[r][c] = '.';
				}
				if (map[r][c] == '*') {
					visited[r][c] = true;
				}
					
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '*') {
					bfs(r, c);
				}
			}
		}
		
		move(start.x, start.y);
	}

	public static void move(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new Point(r, c));

		int cnt = 1;
		boolean flag = false;
		
		outer : while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				if(p.x == end.x && p.y == end.y) {
					flag = true;
					break outer;
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.x + deltas[i][0];
					int nc = p.y + deltas[i][1];
				
					if(isIn(nr,nc) && map[nr][nc] != 'X' && !visited[nr][nc] && cnt < intMap[nr][nc]) {
						
						visited[nr][nc] = true;
						q.add(new Point(nr,nc));
					}
				}
			}
			
			cnt++;
		}
		
		
		if(flag) {
			System.out.println(cnt-1);
		}else {
			System.out.println("KAKTUS");
		}
		
	}

	public static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		boolean visit[][] = new boolean[R][C];
		visit[r][c] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = p.x + deltas[i][0];
					int nc = p.y + deltas[i][1];
					if (isIn(nr, nc) && map[nr][nc] == '.' && !visit[nr][nc]) {
						visit[nr][nc] = true;
						if (intMap[nr][nc] != 0) {
							if (intMap[nr][nc] > cnt) {
								intMap[nr][nc] = cnt;
							}
						} else {
							intMap[nr][nc] = cnt;
						}
						q.add(new Point(nr, nc));
					}
				}
			}
			cnt++;
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
