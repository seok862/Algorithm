package algorithm.swea.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D6_1263_사람네트워크2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static int[][] arr;
	static int INF = 987_654_321;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");

			tokens = new StringTokenizer(input.readLine());

			N = Integer.parseInt(tokens.nextToken());

			arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(tokens.nextToken());

					if (r != c && arr[r][c] == 0) {
						arr[r][c] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int s = 0; s < N; s++) {
					if (k == s)
						continue;

					for (int e = 0; e < N; e++) {
						if (e == k || e == s)
							continue;
						if(arr[s][e] > arr[s][k] + arr[k][e]){
							arr[s][e] = arr[s][k] + arr[k][e];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				int sum = 0;
				for(int c=0; c<N; c++) {
					sum += arr[r][c];
				}
				min = Math.min(min, sum);
			}
			
			output.append(min).append("\n");
		}
		System.out.println(output);
	}
}
