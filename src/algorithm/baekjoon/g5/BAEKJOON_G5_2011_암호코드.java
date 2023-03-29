package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_G5_2011_암호코드 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long[] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		String st = input.readLine();
		arr = new int[st.length()+1];
		dp = new long[st.length()+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i=1; i<=st.length(); i++) {
			arr[i] = st.charAt(i-1)-'0';
		}
		
		if(arr[1] == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i=2; i<arr.length; i++) {
			if(arr[i] == 0) {
				dp[i] = dp[i-2];
			}else {
				String tmp = st.substring(i-2, i);
				if(tmp.equals("00")) {
					System.out.println(0);
				}else {
					int num = Integer.parseInt(tmp);
					if(10 < num && num < 27) {
						dp[i] = dp[i-1]%1000000+dp[i-2]%1000000;
					}else {
						dp[i] = dp[i-1]%1000000;
					}
				}
				
			}
		}
		
		System.out.println(dp[st.length()]%1000000);
	}
}
