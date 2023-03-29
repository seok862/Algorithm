package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S2_11051_이항계수2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[][] map;
 
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N + 1][M + 1];
		for (int r = 0; r <= N; r++) {
			for (int c = 0; c <= Math.min(r, M); c++) {
				if (c == 0 || r == c)
					map[r][c] = 1;
				else
					map[r][c] = (map[r - 1][c - 1] + map[r - 1][c]) % 10007;
			}
		}
		System.out.println(map[N][M]);
	}
}
