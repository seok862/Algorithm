package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.23
 * @see https://www.acmicpc.net/problem/2531
 * @performance 16500 kb	140 ms
 * @category # 슬라이딩 윈도우
 * @note
 */

public class BAEKJOON_S1_2531_회전초밥 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, D, K, C, cnt, max;
	static int[] arr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		arr = new int[N + K];
		visited = new int[3001];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}

		for (int i = N; i < arr.length; i++) {
			arr[i] = arr[i - N];
		}
		max = Integer.MIN_VALUE;
		cnt = 1;
		visited[C]++;
		for (int i = 0; i < K; i++) {
			visited[arr[i]]++;
			if (visited[arr[i]] == 1) {
				cnt++;
			}
		}

		int left = 0;
		int right = K - 1;

		for (int i = 0; i < N; i++) {
			visited[arr[left]]--;
			if (visited[arr[left]] == 0) cnt--;

			left++;
			right++;
			visited[arr[right]]++;

			if (visited[arr[right]] == 1) {
				cnt++;
			}

			max = Math.max(cnt, max);

		}

		System.out.println(max);

	}
}
