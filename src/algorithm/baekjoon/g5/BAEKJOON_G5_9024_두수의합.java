package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.23
 * @see https://www.acmicpc.net/problem/9024
 * @performance 231988 kb	1960 ms
 * @category #투포인터
 * @note
 */

public class BAEKJOON_G5_9024_두수의합 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T,N,K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
		
			arr = new int[N];
			
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			
			Arrays.sort(arr);
			
			int left = 0;
			int right = N-1;
			int number = Integer.MAX_VALUE;
			int cnt = 1;
			
			int sum = arr[left]+arr[right];
			while(left < right) {
				sum = arr[left]+arr[right];
				
				if(Math.abs(K-sum) == number) {
					cnt++;
				} else if(Math.abs(K-sum) < number) {
					cnt = 1;
					number = Math.abs(K-sum);
				}
				
				if(sum == K) {
					left++;
					right--;
				}else if( sum < K) {
					left++;
				}else {
					right--;
				}
			}
			
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
	}
}
