package algorithm.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.14
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
 * @performance 24,556 kb	189 ms
 * @category #재귀 조합
 * @note
 */

public class SWEA_D3_9229_한빈이와SportMart {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr;
	static int max;
	static int N, M;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");
			tokens = new StringTokenizer(input.readLine());
			max = -1;
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			arr = new int[N];

			tokens = new StringTokenizer(input.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}

			make(0, new int[2], 0);

			output.append(max).append("\n");
		}
		System.out.println(output.toString());
	}

	public static void make(int lv, int[] choosed, int startIdx) {
		if (lv == choosed.length) {
			int sum = 0;
			for (int i = 0; i < choosed.length; i++) {
				sum += choosed[i];
			}
			if (sum > M)
				return;
			max = Math.max(sum, max);
			return;
		}

		for (int i = startIdx; i < arr.length; i++) {
			choosed[lv] = arr[i];
			make(lv + 1, choosed, i + 1);
		}
	}
}
