package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.09
 * @see https://www.acmicpc.net/problem/2529
 * @performance 23228 kb	136 ms
 * @category #백트래킹
 * @note
 */

public class BAEKJOON_S1_2529_부등호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr;
	static boolean[] useNumber = new boolean[10];
	static int N;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new char[10];
		list = new ArrayList<>();
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = tokens.nextToken().charAt(0);
		}

		make("", 0);
		
		output.append(list.get(list.size()-1)).append("\n").append(list.get(0));
		
		System.out.println(output.toString());
	}

	public static void make(String num, int lv) {
		if (lv == N + 1) {
			list.add(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (useNumber[i])
				continue;

			if (lv == 0 || check(num.charAt(lv - 1) - '0', i, arr[lv - 1])) {
				useNumber[i] = true;
				make(num + i, lv + 1);
				useNumber[i] = false;
			}
		}
	}

	public static boolean check(int num1, int num2, char c) {
		if (c == '>') {
			return num1 > num2;
		} else {
			return num1 < num2;
		}

	}

}
