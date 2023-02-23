package algorithm.beakjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G3_10986_나머지합 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M;
	static long N,cnt,sum;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new long[M];
		
		tokens = new StringTokenizer(input.readLine());
		sum = 0;
		for(int i=0; i<N; i++) {
			sum += Long.parseLong(tokens.nextToken());
			arr[(int)(sum%M)]++;
		}
		
		cnt = arr[0];
		
		for(int i=0; i<M; i++) {
			long num = arr[i];
			cnt += num*(num-1)/2;
		}
		
		System.out.println(cnt);
	}
}
