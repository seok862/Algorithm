package algorithm.beakjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.22
 * @see https://www.acmicpc.net/problem/15686
 * @performance 11548 kb	84 ms
 * @category # 그리디
 * @note
 */

public class BAEKJOON_S4_11047_동전O {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K,cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
	
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		cnt = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(arr[i] <= K) {
				cnt += K/arr[i];
				K %= arr[i];
			}
		}
		
		System.out.println(cnt);
	}
}
