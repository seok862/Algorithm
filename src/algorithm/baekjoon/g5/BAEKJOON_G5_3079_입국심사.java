package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @author seok
* @since 2023.04.12
* @see https://www.acmicpc.net/problem/3079
* @performance 22824 kb	280 ms
* @category # 이분탐색
* @note
*/


public class BAEKJOON_G5_3079_입국심사 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long N, M, ans;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		// N 입국 심사대 수
		N = Long.parseLong(tokens.nextToken());
		// M 친구 수
		M = Long.parseLong(tokens.nextToken());
	
		
		arr = new long[(int)N];
		long max = 0;
		ans = Long.MAX_VALUE;
		for(int t=0; t<N; t++) {
			arr[t] = Integer.parseInt(input.readLine());
			max = Math.max(max, arr[t]);
		}
		
		long right = max*M;
		long left = 1;

		while(left <= right) {
			long mid = (right+left)/2;
			long cnt = 0;
			
			for(int i=0; i<arr.length; i++) {
				cnt += mid/arr[i];
				
				if(cnt >= M) break;
			}
			
			if(cnt < M) {
				left = mid+1;
			}else {
				right = mid-1;
				ans = Math.min(ans, mid);
			}
				
		}
		
		System.out.println(left);
	}
}