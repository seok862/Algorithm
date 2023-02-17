package algorithm.beakjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S4_2839_설탕배달 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int cnt;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		while(true) {
			if(N%5==0) {
				cnt += N/5;
				output.append(cnt);
				break;
			}else {
				N-=3;
				cnt++;
			}
			
			if(N<0) {
				output.append("-1");
				break;
			}
		}
		
		System.out.println(output.toString());
	}
}
