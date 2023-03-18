package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S3_11659_구간합구하기4 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		sum = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<N+1; i++) {
			sum[i] = sum[i-1]+Integer.parseInt(tokens.nextToken());
		}
		
		for(int t=0; t<M; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			int left = Integer.parseInt(tokens.nextToken());
			int right = Integer.parseInt(tokens.nextToken());
					
			output.append(sum[right]-sum[left-1]).append("\n");
		}
		
		System.out.println(output.toString());
	}
}
