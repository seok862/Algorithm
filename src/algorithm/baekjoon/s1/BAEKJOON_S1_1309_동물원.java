package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author seok
 * @since 2023.03.28
 * @see https://www.acmicpc.net/problem/1309
 * @performance 11528 kb	88 ms
 * @category # DP
 * @note
 */

public class BAEKJOON_S1_1309_동물원 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static int ans;
	static int[] arr;
	static int sum;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[3];
		sum = 0;
		
		for(int i=0; i<3; i++) {
			arr[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			int sum1 = arr[0]+arr[1]+arr[2];
			int sum2 = arr[0]+arr[2];
			int sum3 = arr[0]+arr[1];
			
			arr[0] = sum1%9901;
			arr[1] = sum2%9901;
			arr[2] = sum3%9901;
		}
		
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum%9901);
	}

	
}
