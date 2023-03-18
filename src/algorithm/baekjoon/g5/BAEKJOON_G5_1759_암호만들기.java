package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/1759
 * @performance 12,020 kb 80 ms
 * @category #백트래킹
 * @note
 */

public class BAEKJOON_G5_1759_암호만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr;
	static boolean[] visited;
	static char[] choosed;
	static int L, C;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		arr = new char[C];

		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tokens.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		choosed = new char[L];
		dfs(0, 0);

		System.out.println(output);
	}

	static void dfs(int num, int l) {
		if (l == L) {
			if (check()) {
				for (int i = 0; i < choosed.length; i++) {
					output.append(choosed[i]);
				}
				output.append("\n");
			}
			return;
		}

		for (int i = num; i < arr.length; i++) {
			choosed[l] = arr[i];
			dfs(i + 1, l + 1);
		}
	}

	public static boolean check() {
		int mo = 0;
		int ja = 0;

		for (char x : choosed) {
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				mo++;
			} else {
				ja++;
			}
		}

		if (mo >= 1 && ja >= 2) {
			return true;
		}
		return false;
	}
}
