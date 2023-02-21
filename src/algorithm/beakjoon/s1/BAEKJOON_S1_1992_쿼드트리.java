package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.21
 * @see https://www.acmicpc.net/problem/1992
 * @performance 11700 kb	80 ms
 * @category # 분할 정복
 * @note
 */


public class BAEKJOON_S1_1992_쿼드트리 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String st = input.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		make(0, 0, N);

		System.out.println(output.toString());
	}

	public static void make(int r, int c, int size) {

		if (check(r,c,size)) {
			output.append(map[r][c]);
			return;
		}
		
		output.append('(');
		int half = size / 2;

		make(r, c, half);
		make(r, c + half, half);
		make(r + half, c, half);
		make(r + half, c + half, half);

		output.append(')');

	}
	
	public static boolean check(int r, int c, int size) {
		int num = map[r][c];
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (num != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
