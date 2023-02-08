package algorithm.beakjoon.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_B2_2798_블랙잭 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr;
	static int[] choosed = new int[3];
	static int N, M;
	static int max;
	static int ans;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		max = M;
		make(0,0);
		
		
		System.out.println(ans);
	}
	
	public static void make(int lv, int start) {
		if(lv == 3) {
			int sum = 0;
			for(int i:choosed) {
				sum += i;
			}
			
			if(sum <= max && sum > ans) ans = sum;
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			choosed[lv] = arr[i];
			make(lv+1, i+1);
		}
	}
}
