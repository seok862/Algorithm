package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.04
 * @see https://www.acmicpc.net/problem/3190
 * @performance 13540 kb	104 ms
 * @category # 덱 + 구현
 * @note
 */

public class BAEKJOON_G4_3190_뱀 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, L, cnt, current;
	static int[][] map;
	static int nowX, nowY;
	static Deque<Point> queue = new ArrayDeque<>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(input.readLine());

		for (int i = 0; i < K; i++) {
			tokens = new StringTokenizer(input.readLine());
			map[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = 2;
		}

		queue.offerFirst(new Point(1, 1));
		L = Integer.parseInt(input.readLine());
		cnt = 1;
		nowX = 1;
		nowY = 1;
		current = 0;
		arr = new int[L+1];
		String[] head = new String[L];
		for (int i = 0; i < L; i++) {
			tokens = new StringTokenizer(input.readLine());

			int X = Integer.parseInt(tokens.nextToken());
			arr[i+1] = X;

			head[i] = tokens.nextToken();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j <arr[i+1]-arr[i]; j++) {
				move(current);
				cnt++;
			}

			moveHead(head[i]);
		}
		for(int i=0; i<N; i++) {
			move(current);
			cnt++;
		}
	}

	public static void moveHead(String dir) {
		switch (dir) {
		case "D":
			current += 1;

			if (current == 4)
				current = 0;
			break;
		case "L":
			current -= 1;
			if (current == -1)
				current = 3;
			break;
		}
	}

	public static void move(int current) {
		
		switch (current) {
		
		case 0:
			nowY += 1;

			if (nowY > N || queue.contains(new Point(nowX, nowY))) {
				System.out.println(cnt);
				System.exit(0);
			} else {
				queue.offerFirst(new Point(nowX, nowY));
				if (map[nowX][nowY] == 0) {
					queue.pollLast();
				}else if(map[nowX][nowY] == 2) {
					map[nowX][nowY] = 0;
				}
			}

			break;
		case 1:
			nowX += 1;

			if (nowX > N || queue.contains(new Point(nowX, nowY))) {
				System.out.println(cnt);
				System.exit(0);
			} else {
				queue.offerFirst(new Point(nowX, nowY));

				if (map[nowX][nowY] == 0) {
					queue.pollLast();
				}else if(map[nowX][nowY] == 2) {
					map[nowX][nowY] = 0;
				}
			}

			break;
		case 2:
			nowY -= 1;

			if (nowY <= 0 || queue.contains(new Point(nowX, nowY))) {
				System.out.println(cnt);
				System.exit(0);
			} else {
				queue.offerFirst(new Point(nowX, nowY));
				if (map[nowX][nowY] == 0) {
					queue.pollLast();
				}else if(map[nowX][nowY] == 2) {
					map[nowX][nowY] = 0;
				}
			}

			break;
		case 3:
			nowX -= 1;

			if (nowX <= 0 || queue.contains(new Point(nowX, nowY))) {
				System.out.println(cnt);
				System.exit(0);
			} else {
				queue.offerFirst(new Point(nowX, nowY));
				if (map[nowX][nowY] == 0) {
					queue.pollLast();
				}else if(map[nowX][nowY] == 2) {
					map[nowX][nowY] = 0;
				}
			}

			break;
		}
	}

	public static class Point {
		int r;
		int c;

		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			if (this.r == p.r && this.c == p.c)
				return true;
			else
				return false;
		}

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
