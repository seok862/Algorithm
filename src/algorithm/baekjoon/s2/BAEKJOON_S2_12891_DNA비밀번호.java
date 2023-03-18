package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_S2_12891_DNA비밀번호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] alpha = new int[4];
	static int[] use = {'A','C','G','T'};
	
	static int S, P;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		S = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		
		String st = input.readLine();
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<4; i++) {
			alpha[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
			
		System.out.println(Arrays.toString(alpha));
		
		
	}
}
