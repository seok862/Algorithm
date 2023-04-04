package algorithm.baekjoon.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.04
 * @see https://www.acmicpc.net/problem/2933
 * @performance 45980 kb	396 ms
 * @category # bfs+시뮬
 * @note
 */

public class BAEKJOON_G2_2933_미네랄 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C;
	static char[][] map;
	static int N, min;
	static boolean[][] visited;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String temp = input.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c);
			}
		}

		N = Integer.parseInt(input.readLine());

		tokens = new StringTokenizer(input.readLine());
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(tokens.nextToken());
			// 왼쪽 던지기
			if (i % 2 != 0) {
				findLeft(h - 1);
			}

			// 오른쪽 던지기
			else {
				findRight(h - 1);
			}

			visited = new boolean[R][C];
			for (int c = 0; c < C; c++) {
				if (map[R - 1][c] == 'x' && !visited[R - 1][c]) {
					bfs(R - 1, c);
				}
			}

			min = h;

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (!visited[r][c] && map[r][c] == 'x') {
						findMin(r, c);
					}
				}
			}

			for (int r = R-1; r >=0; r--) {
				for (int c = C-1; c>=0; c--) {
					if (!visited[r][c] && map[r][c] == 'x') {
						moveX(r, c);
					}
				}
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

	public static void moveX(int r, int c) {
		map[r][c] = '.';
		map[r + min - 1][c] = 'x';
		visited[r+min-1][c] = true;
	}

	public static void findMin(int r, int c) {
		for (int i = r + 1; i < R; i++) {
			if (i >= R ||(visited[i][c] && map[i][c] == 'x')) {
				min = Math.min(min, i - r);
			}
		}
	}

	public static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + deltas[i][0];
				int nc = p.c + deltas[i][1];

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 'x') {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}

	}

	public static void findLeft(int h) {
		for (int i = 0; i < C; i++) {
			if (map[R - h - 1][i] == 'x') {
				map[R - h - 1][i] = '.';
				return;
			}
		}
	}

	public static void findRight(int h) {
		for (int i = C - 1; i >= 0; i--) {
			if (map[R - h - 1][i] == 'x') {
				map[R - h - 1][i] = '.';
				return;
			}
		}
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}
