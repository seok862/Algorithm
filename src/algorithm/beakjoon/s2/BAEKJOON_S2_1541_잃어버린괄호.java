package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.03.08
 * @see https://www.acmicpc.net/problem/1541
 * @performance 11544 kb	76 ms
 * @category # 수학
 * @note
 */

public class BAEKJOON_S2_1541_잃어버린괄호 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int sum;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(),"-");
		sum = Integer.MAX_VALUE;
		while(tokens.hasMoreTokens()) {
			int tmp = 0;
			
			StringTokenizer tokens2 = new StringTokenizer(tokens.nextToken(),"+");
			
			while(tokens2.hasMoreTokens()) {
				tmp += Integer.parseInt(tokens2.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			}else {
				sum -= tmp;
			}
		}
		System.out.println(sum);
	}
}
