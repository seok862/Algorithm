package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.28
 * @see https://www.acmicpc.net/problem/5582
 * @performance 75300 kb	192 ms
 * @category #LIS
 * @note
 */

public class BAEKJOON_G5_5582_공통부분문자열 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int max;
	public static void main(String[] args) throws IOException {
		String tmp1 = input.readLine();
		String tmp2 = input.readLine();
		
		int len1 = tmp1.length();
		int len2 = tmp2.length();
		
		map = new int[len1+1][len2+1];
		max = 0;
		for(int i=1; i<len1+1; i++) {
			
			for(int j=1; j<len2+1; j++) {
				if(tmp1.charAt(i-1) == tmp2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1]+1;
					max = Math.max(map[i][j], max);
				}
			}
		}
		System.out.println(max);
	}
}
