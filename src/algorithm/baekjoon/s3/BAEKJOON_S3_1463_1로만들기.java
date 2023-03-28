package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S3_1463_1로만들기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[1000001];
		
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=4; i<arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			if(i%3 == 0) {
				a = arr[i/3]+1;
			}
			if(i%2==0) {
				b = arr[i/2]+1;
			}
			c = arr[i-1]+1;
			
			min = Math.min(a, Math.min(b, c));
			
			arr[i] = min;
		}
		
		System.out.println(arr[N]);
		
	}
}
