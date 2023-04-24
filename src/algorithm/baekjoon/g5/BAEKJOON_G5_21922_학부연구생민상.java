package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.24
 * @see https://www.acmicpc.net/problem/2293
 * @performance 458468 kb	2544 ms
 * @category # 그래프탐색	
 * @note
 */

public class BAEKJOON_G5_21922_학부연구생민상 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int direction;
	static int[][] map;
	static boolean[][][] visited;
	static int R, C;
	static Queue<Point> q;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][4];
		q = new LinkedList<>();
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());

			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());

				if (map[r][c] == 9) {
					for (int dir = 0; dir < 4; dir++) {
						visited[r][c][dir] = true;
						q.add(new Point(r, c, dir));
					}
				}
			}
		}

		bfs();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				for (int dir = 0; dir < 4; dir++) {
					if (visited[r][c][dir]) {
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			int nr = p.r + deltas[p.dir][0];
			int nc = p.c + deltas[p.dir][1];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (visited[nr][nc][p.dir])
				continue;
			
			visited[nr][nc][p.dir] = true;

			switch (map[nr][nc]) {
			case 1:
				if (p.dir == 1 || p.dir == 3)
					continue;
				break;
			case 2:
				if (p.dir == 0 || p.dir == 2)
					continue;
				break;
			case 3:
				if (p.dir == 0)
					p.dir = 1;
				else if (p.dir == 1)
					p.dir = 0;
				else if (p.dir == 2)
					p.dir = 3;
				else if (p.dir == 3)
					p.dir = 2;
				break;
			case 4:
				if (p.dir == 0)
					p.dir = 3;
				else if (p.dir == 1)
					p.dir = 2;
				else if (p.dir == 2)
					p.dir = 1;
				else if (p.dir == 3)
					p.dir = 0;
				break;
			}

			q.add(new Point(nr, nc, p.dir));
		}
	}

	public static class Point {
		int r;
		int c;
		int dir;

		public Point(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}