package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.07
 * @see https://www.acmicpc.net/problem/27468
 * @performance 116972 kb	460 ms
 * @category # 구성적
 * @note
 */

public class BAEKJOON_G5_27468_2배 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] arr1 = {1,2,4,3};
	static int[] arr2 = {1,3,2,4};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		output.append("YES").append("\n");
		
		if(N%2 == 0) {
			int cnt = 0;
			int num = 0;
			while(cnt != N) {
				for(int i=0; i<4; i++) {
					cnt+=1;
					output.append(arr1[i]+4*num).append(" ");
					if(cnt == N) break;
				}
				num += 1;
			}
			
		}else {
			int cnt = 0;
			int num = 0;
			while(cnt != N) {
				for(int i=0; i<4; i++) {
					cnt+=1;
					output.append(arr2[i]+4*num).append(" ");
					if(cnt == N) break;
				}
				num += 1;
			}
		}
		
		System.out.println(output);
		
	}
}
