package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.18
 * @see https://www.acmicpc.net/problem/1527
 * @performance 11492 kb	84 ms	
 * @category # dfs
 * @note
 */

public class BAEKJOON_S1_1527_금민수의개수 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int A, B, ans;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		ans = 0;
		dfs(0);
		
		System.out.println(ans);
	}
	
	public static void dfs(long num) {
		if(num > B) return;
		
		if(A <= num && num <= B) ans++;
		
		dfs(num*10+4);
		dfs(num*10+7);
	}
}
