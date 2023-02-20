package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.20
 * @see https://www.acmicpc.net/problem/1074
 * @performance 11928 kb	88 ms
 * @category # 분할정복
 * @note
 */

public class BAEKJOON_s1_1074_Z {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, R, C, size;
	static int[][] map;
	static int num;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		size = (int) Math.pow(2, N);
		num = 0;
		make(R, C, size);

		System.out.println(output.toString());

	}

	public static void make(int r, int c, int size) {
		if (r==0 && c==0) {
			output.append(num);
			return;
		}

		int half = size / 2;
		
		if (r < half && c < half) {
			num = 0;
			make(r, c, half);
		} else if (r < half && c >= half) {
			num = num +  half * half;
			make(r, c - half, half);
		} else if (r >= half && c < half) {
			num = num + half * half * 2;
			make(r - half, c, half);
		} else {
			num = num + half * half * 3;
			make(r - half, c - half, half);
		}
	}
}
