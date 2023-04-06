package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G1_3678_카탄의개척자 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[] arr;
	static int[][] map;
	static int[][] deltas = {{2,0},{1,1},{0,2},{-1,1},{-2,0},{-1,-1},{0,-2},{1,-1}};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N];
		
		for(int t=0; t<N; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			arr[t] = Integer.parseInt(tokens.nextToken());
		}
		
		map = new int[100][100];

		map[50][50] = 1;
		
		int nowx = 50;
		int nowy = 50;
		int index = 1;
		int number = 1;

		while(index <= 10000) {
			
		}
	}
}
