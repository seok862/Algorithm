package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.05.09
* @see https://www.acmicpc.net/problem/1414
* @performance 	11796kb		88ms
* @category # 최소신장트리
* @note
*/

public class BAEKJOON_G3_1414_불우이웃돕기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, sum, total;
	static int[][] arr;

	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		arr = new int[N + 1][N + 1];
		
		for(int[] a:arr) {
			Arrays.fill(a, 100);
		}
		
		visited = new boolean[N + 1];
		for (int r = 1; r <= N; r++) {
			String st = input.readLine();
			for (int c = 1; c <= N; c++) {
				if (st.charAt(c-1) != '0') {
					char tmp = st.charAt(c-1);
					int n = 0;
					if((int)tmp >= (int)'a' && (int)tmp <= (int)'z') n = (int)tmp - (int)'a' + 1;
		            else n = (int)tmp - (int)'A' + 27;
					sum += n;
					if (r == c)
						continue;
					arr[r][c] = n;
				}
			}
		}
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {

				if (arr[r][c] > arr[c][r])
					arr[r][c] = arr[c][r];
				else {
					arr[c][r] = arr[r][c];
				}

			}
		}
		
		prim();
		boolean check = true;
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				check = false;
		}
		if (check)
			System.out.println(sum - total);
		else
			System.out.println(-1);

	}

	public static void prim() {

		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			int edge = e.a;
			int weight = e.b;
			if (visited[edge])
				continue;

			visited[edge] = true;
			total += weight;

			for (int i = 1; i <= N; i++) {
				if(arr[edge][i] != 100) {
					if(!visited[i]) pq.add(new Edge(i, arr[edge][i]));
				}
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int a;
		int b;

		public Edge(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.b, o.b);
		}
	}
}