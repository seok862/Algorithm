package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_3079_입국심사 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		// N 입국 심사대 수
		N = Integer.parseInt(tokens.nextToken());
		// M 친구 수
		M = Integer.parseInt(tokens.nextToken());
	
		
		arr = new int[N];
		for(int t=0; t<N; t++) {
			arr[t] = Integer.parseInt(input.readLine());
		}
		
		
	}
}
