package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S3_15650_N과M_2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;

	static int[] choosed;
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		output = new StringBuilder();

		choosed = new int[M];
		visited = new boolean[N];

		makeArr(0, 0);

		System.out.println(output);
	}

	public static void makeArr(int num, int l) {
		if (l == choosed.length) {
			for (int i : choosed) {
				output.append(i).append(" ");
			}
			output.append("\n");
			return;
		}
		for (int i = num; i < N; i++) {
			choosed[l] = i + 1;
			makeArr(i + 1, l + 1);
		}

	}
}
