package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since
 * @see
 * @performance
 * @category @note
 */
public class BAEKJOON_G4_17281_야구공 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, sum;
	static base b;
	static int[][] round;
	static int index = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		

		round = new int[N][9];

		b = new base(0, 0, 0);
		sum = 0;
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < 9; c++) {
				round[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		makePermutation(0, new int[9], new boolean[9]);
		
		System.out.println(sum);
		
	}

	public static void makePermutation(int lv, int[] choosed, boolean[] visited) {
		if (lv == choosed.length) {
			countScore(choosed);
			return;
		}
		if (lv == 3) {
			choosed[lv++] = 0;
		}
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[lv] = i;
				makePermutation(lv + 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	public static void countScore(int[] choosed) {
		int outCnt = 0;

		for (int i = 0; i < N; i++) {
			while (outCnt < 3) {
				switch (round[i][index++]) {
				case 0:
					outCnt++;
					break;
				case 1:
					if (b.b3 == 1) {
						b.b3 = 0;
					}
					if (b.b2 == 1) {
						b.b3 =1;
						b.b2 = 0;
					} else {
						b.b2 = 1;
					}
					
					if (b.b1 == 1) {
						b.b1 = 0;
						b.b2 = 1;
					} else {
						b.b1 = 1;
					}
					break;
				case 2:
					if (b.b3 == 1) {
						sum++;
						b.b3 = 0;
					}					
					if (b.b2 == 1) {
						b.b2 = 0;
						sum++;
					} 
					if (b.b1 == 1) {
						b.b1 = 0;
						b.b3 = 1;
					}
					break;
				case 3:
					if(b.b3 == 1) {
						sum++;
						b.b3 = 0;
					}
					
					if(b.b2 == 1) {
						b.b2 = 0;
						sum++;
					}
					
					if(b.b1 == 1) {
						b.b1 = 0;
						sum++;
					}
					break;
				case 4:
					if(b.b1 == 1) {
						b.b1 = 0;
						sum++;
					}
					if(b.b2 == 1) {
						b.b2 = 0;
						sum++;
					}
					if(b.b3 == 1) {
						b.b3 = 0;
						sum++;
					}
					break;
				}
				
				if(index == 9) index = 0;
			}
		}
	}

	public static class base {
		int b1;
		int b2;
		int b3;

		public base(int b1, int b2, int b3) {
			this.b1 = b1;
			this.b2 = b2;
			this.b3 = b3;
		}
	}
}
