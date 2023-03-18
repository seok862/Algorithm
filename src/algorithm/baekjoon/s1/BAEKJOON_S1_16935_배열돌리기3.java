package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_16935_배열돌리기3 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, R;
	static int[][] arr;
	static int[][] tmp;
	static int max;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		max = Math.max(N, M);
		arr = new int[max + 1][max + 1];
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		tokens = new StringTokenizer(input.readLine());

		while (tokens.hasMoreTokens()) {
			switch (Integer.parseInt(tokens.nextToken())) {
			case 1:
				arr = make1(arr);
				break;
			case 2:
				arr = make2(arr);
				break;
			case 3:
				arr = make3(arr);
				break;
			case 4:
				arr = make4(arr);
				break;
			case 5:
				arr = make5(arr);
				break;
			case 6:
				arr = make6(arr);
				break;
			}
		}
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				output.append(arr[i][j]).append(" ");
			}
			output.append("\n");

		}

		System.out.println(output.toString());
	}

	public static int[][] make6(int[][] arr) {
		int[][] tmp = new int[max + 1][max + 1];
		for(int i=1; i<=N/2; i++) {
			for(int j=1; j<=M/2; j++) {
				tmp[i][j] = arr[i][j+M/2];
			}
		}
		for(int i=1; i<=N/2; i++) {
			for(int j=M/2+1; j<=M; j++) {
				tmp[i][j] = arr[i+N/2][j];
			}
		}
		
		for(int i=N/2+1; i<=N; i++) {
			for(int j=1; j<=M/2; j++) {
				tmp[i][j] = arr[i-N/2][j];
			}
		}
		
		for(int i=N/2+1; i<=N; i++) {
			for(int j=M/2+1; j<=M; j++) {
				tmp[i][j] = arr[i][j-M/2];
			}
		}
		
		return tmp;
	}
	
	public static int[][] make5(int[][] arr) {
		int[][] tmp = new int[max + 1][max + 1];
		for(int i=1; i<=N/2; i++) {
			for(int j=1; j<=M/2; j++) {
				tmp[i][j] = arr[i+N/2][j];
			}
		}
		for(int i=1; i<=N/2; i++) {
			for(int j=M/2+1; j<=M; j++) {
				tmp[i][j] = arr[i][j-M/2];
			}
		}
		
		for(int i=N/2+1; i<=N; i++) {
			for(int j=1; j<=M/2; j++) {
				tmp[i][j] = arr[i][j+M/2];
			}
		}
		
		for(int i=N/2+1; i<=N; i++) {
			for(int j=M/2+1; j<=M; j++) {
				tmp[i][j] = arr[i-N/2][j];
			}
		}
		
		return tmp;
	}

	public static int[][] make4(int[][] arr) {
		int[][] tmp = new int[max + 1][max + 1];

		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				tmp[i][j] = arr[j][max + 1 - i];
			}
		}
		return tmp;
	}

	public static int[][] make3(int[][] arr) {
		int[][] tmp = new int[max + 1][max + 1];

		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				tmp[i][j] = arr[max - j][i];
			}
		}
		return tmp;
	}

	public static int[][] make2(int[][] arr) {
		tmp = new int[max + 1][max + 1];
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				tmp[i][j] = arr[i][(max + 1) - j];
			}
		}
		return tmp;
	}

	public static int[][] make1(int[][] arr) {
		tmp = new int[max + 1][max + 1];

		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				tmp[i][j] = arr[(max + 1) - i][j];
			}
		}

		return tmp;
	}
}
