package algorithm.beakjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/2407
 * @performance 11652 kb	76 ms	
 * @category BigInteger
 * @note
 */
public class BAEKJOON_S3_2407_조합 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		BigInteger bigNumber1 = new BigInteger("1");
		
		for(long i=N; i>N-M; i--) {
			bigNumber1 = bigNumber1.multiply(BigInteger.valueOf(i));
		}
		
		BigInteger bigNumber2 = new BigInteger("1");
		
		for(long i=M; i>0; i--) {
			bigNumber2 = bigNumber2.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(bigNumber1.divide(bigNumber2));
	}
}
