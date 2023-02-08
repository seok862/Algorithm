package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_11660_구간합구하기5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<N+1; j++) {
				arr[i][j] = arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int t=0; t<M; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			output.append(arr[x2][y2] + arr[x1-1][y1-1] - arr[x1-1][y2] - arr[x2][y1-1]).append("\n");
		}
		System.out.println(output);
	}
}
