package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.07
 * @see https://www.acmicpc.net/problem/27468
 * @performance 375068 kb	27942 ms
 * @category # 구현
 * @note
 */

public class BAEKJOON_G5_27942_danceplant {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		int rs = N / 2;
		int cs = N / 2;
		int re = N / 2 + 1;
		int ce = N / 2 + 1;

		int ans1 = 0;
		String ans2 = "";
		int lv = 1;
		
		while (true) {
			int max = 0;
			int[] numbers = new int[4];
			// 상
			if (rs - 1 > 0) {
				for (int i = cs; i <= ce; i++) {
					numbers[0] += map[rs - 1][i];
				}
				max = Math.max(numbers[0], max);
			}
			// 하
			if (re + 1 <= N) {
				for (int i = cs; i <= ce; i++) {
					numbers[1] += map[re + 1][i];
				}
				max = Math.max(numbers[1], max);
			}

			// 좌
			if (cs - 1 > 0) {
				for (int i = rs; i <= re; i++) {
					numbers[2] += map[i][cs - 1];
				}
				max = Math.max(numbers[2], max);
			}
			
			// 우
			if (ce + 1 <= N) {
				for (int i = rs; i <= re; i++) {
					numbers[3] += map[i][ce + 1];
				}
				max = Math.max(numbers[3], max);
			}
			
			if (max == 0)
				break;

			else {
				int dir = 0;
				for (int i = 0; i < 4; i++) {
					if (numbers[i] == max) {
						dir = i;
						break;
					}
				}

				if (dir == 0) {
					ans1 += numbers[0];
					ans2 += "U";
					rs--;
					if (rs<0) {
						rs=1;
					}

				} else if (dir == 1) {
					ans1 += numbers[1];
					ans2 += "D";
					re++;
					if (re +1> N) {
						re=N;
					}

				} else if (dir == 2) {
					ans1 += numbers[2];
					ans2 += "L";
					cs--;
					if (cs <0) {
						cs= 1;
					}
				} else {
					ans1 += numbers[3];
					ans2 += "R";
					ce++;
					if (ce + 1 > N) {
						ce=N;
					}
				}
			}
		}
		output.append(ans1).append("\n").append(ans2);
		System.out.println(output);
	}

}
