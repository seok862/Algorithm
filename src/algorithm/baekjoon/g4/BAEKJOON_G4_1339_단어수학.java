package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.21
 * @see https://www.acmicpc.net/problem/1339
 * @performance 11540 kb	80 ms
 * @category # 그리디
 * @note
 */

public class BAEKJOON_G4_1339_단어수학 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		for(int i=0; i<N; i++) {
			String st = input.readLine();
			int len = (int)Math.pow(10, st.length()-1);
			for(int j=0; j<st.length(); j++) {
				alpha[st.charAt(j)-'A'] += len;
				len/=10;
			}
		}
		Arrays.sort(alpha);
		
		int sum = 0;
		for(int i=alpha.length-1, number = 9; i>0; i--) {
			sum += number*alpha[i];
			number--;
		}
		
		System.out.println(sum);
	}
}
