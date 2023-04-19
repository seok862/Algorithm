package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_G3_1005_ACMCraft {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, K, end;
	static int[] edge;
	static int[] time;
	static int[] result;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			tokens = new StringTokenizer(input.readLine());

			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());

			time = new int[N + 1];
			edge = new int[N + 1];
			result = new int[N + 1];
			tokens = new StringTokenizer(input.readLine());

			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(tokens.nextToken());
			}

			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < K; i++) {
				tokens = new StringTokenizer(input.readLine());
				list.get(Integer.parseInt(tokens.nextToken())).add(Integer.parseInt(tokens.nextToken()));
			}

			for (int i = 1; i <= N; i++) {
				int size = list.get(i).size();

				for (int j = 0; j < size; j++) {
					edge[list.get(i).get(j)] += 1;
				}
			}

			end = Integer.parseInt(input.readLine());

			checkTime();
			output.append(result[end]).append("\n");
		}
		System.out.println(output.toString());
	}

	public static void checkTime() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < edge.length; i++) {
			result[i] = time[i];
			if (edge[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int point = q.poll();

			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < list.get(point).size(); i++) {
				int n = list.get(point).get(i);
				result[n] = Math.max(result[n], result[point]+time[n]);
				edge[n]--;
				if (edge[n] == 0) {
					q.add(n);
				}
			}

		}
	}
}
