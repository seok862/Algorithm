package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_S1_2529_부등호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
	
		
		
	}
		
	
	public static boolean check(int num1, int num2, int arrIdx) {
		if(arr[arrIdx-1] == '<') {
			return num1 < num2;
		}else {
			return num1 > num2;
		}
	}
}
