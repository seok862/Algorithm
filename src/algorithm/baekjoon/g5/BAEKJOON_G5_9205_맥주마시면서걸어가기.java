package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.05
 * @see https://www.acmicpc.net/problem/9205
 * @performance 12424 kb	96 ms
 * @category # bfs
 * @note
 */

public class BAEKJOON_G5_9205_맥주마시면서걸어가기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static Point[] arr;
	static int beer;
	static boolean[] visited;

	public static void main(String[] arg) throws IOException {
		T = Integer.parseInt(input.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			N = Integer.parseInt(input.readLine());

			arr = new Point[N + 2];
			visited = new boolean[N + 2];
			for (int i = 0; i < N + 2; i++) {
				tokens = new StringTokenizer(input.readLine());

				int r = Integer.parseInt(tokens.nextToken());
				int c = Integer.parseInt(tokens.nextToken());

				arr[i] = new Point(r, c);
			}

			if(bfs()) output.append("happy").append("\n");
			else output.append("sad").append("\n");
		}
		
		System.out.println(output);

	}

	public static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(arr[0]);
		visited[0] = true;

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (p.r == arr[arr.length-1].r && p.c == arr[arr.length-1].c) {
				return true;
			}
			
			for(int i=0; i<arr.length; i++) {
				if(!visited[i]) {
					if(Math.abs((arr[i].r-p.r))+Math.abs((arr[i].c-p.c)) <= 1000) {
						visited[i] = true;
						q.offer(arr[i]);
					}
				}
			}
		}
		
		return false;
	}


	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
