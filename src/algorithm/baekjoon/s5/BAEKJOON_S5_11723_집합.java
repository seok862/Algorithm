package algorithm.baekjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.21
 * @see https://www.acmicpc.net/problem/1339
 * @performance 11540 kb	80 ms
 * @category # 그리디
 * @note
 */

public class BAEKJOON_S5_11723_집합 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static boolean[] check;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		arr = new int[21];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			String st = tokens.nextToken();
			
			switch(st) {
			case "add":
				
				break;
			case "remove":
				break;
			case "check":
				break;
			case "toggle":
				break;
			case "all":
				break;
			case "empty":
				break;
			}
		}
	}
}
