package algorithm.baekjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.03.08
 * @see https://www.acmicpc.net/problem/3273
 * @performance 31104 kb	308 ms
 * @category # 투포인터
 * @note
 */

public class BAEKJOON_S3_3273_두수의합 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr;
	static int N,cnt;
	static long M;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(input.readLine());
		
		int cnt = 0;

		int left,right;

		left = 0;
		right = arr.length-1;
		
		
		while(true) {
			int num = arr[right]+arr[left];
			
			if(num == M) cnt++;
			
			if(num >= M) {
				right--;
			}else {
				left++;
			}
			
			if(right <= left) break;
		}
		
		System.out.println(cnt);
	}
}
