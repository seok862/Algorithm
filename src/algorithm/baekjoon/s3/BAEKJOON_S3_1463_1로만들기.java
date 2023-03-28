package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.28
 * @see https://www.acmicpc.net/problem/1463
 * @performance 15664 kb 104 ms
 * @category # DP
 * @note
 */

public class BAEKJOON_S3_1463_1로만들기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(input.readLine());
		arr = new int[1000001];

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for (int i = 4; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				a = arr[i / 3] + 1;
			}
			if (i % 2 == 0) {
				b = arr[i / 2] + 1;
			}
			c = arr[i - 1] + 1;

			min = Math.min(a, Math.min(b, c));

			arr[i] = min;
		}

		System.out.println(arr[N]);
//		bfs(N);
	}

	// bfs로 푼 풀이
	public static void bfs(int num) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(num, 0));
		int idx = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.num == 1) {
				idx = p.idx;
				break;
			}

			if (p.num % 3 == 0) {
				q.add(new Point(p.num / 3, p.idx + 1));
			}

			if (p.num % 2 == 0) {
				q.add(new Point(p.num / 2, p.idx + 1));
			}
			q.add(new Point(p.num - 1, p.idx + 1));

		}

		System.out.println(idx);
	}

	static class Point {
		int num;
		int idx;

		public Point(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
}
