package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_21608_상어초등학교 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[N*N][5];

		for(int i=0; i<N*N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		
	}
}
