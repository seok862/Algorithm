package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.28
 * @see https://www.acmicpc.net/problem/15654
 * @performance 14996 kb	112 ms
 * @category # 조합
 * @note
 */

public class BAEKJOON_S3_15657_N과M_8 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		visited = new boolean[N];

		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}

		Arrays.sort(arr);

		make(0, 0, new int[M]);

		System.out.println(output);
	}

	public static void make(int lv, int startidx, int[] choosed) {
		if (lv == M) {
			for (int i = 0; i < M; i++) {
				output.append(choosed[i]).append(" ");
			}

			output.append("\n");

			return;
		}

		for (int i = startidx; i < N; i++) {
			choosed[lv] = arr[i];
			make(lv + 1, i, choosed);
		}
	}
}
