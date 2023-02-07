package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_2529_부등호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr;
	static int max, min;
	static String maxAns, minAns;
	static int[] choosed;
	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(input.readLine());
		arr = new char[size];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		maxAns = "";
		minAns = "";
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<size; i++) {
			arr[i] = tokens.nextToken().charAt(0);
		}
		choosed = new int[size+1];
		
		for(int i=0; i<choosed.length; i++) {
			choosed[0] = i;
			makeNum(i,0);
		}
		
		System.out.println(maxAns);
		System.out.println(minAns);
	}
	
	
	public static void makeNum(int num, int arrIdx) {
		if(arrIdx == choosed.length) {
			String st = "";
			for(int i=0; i<choosed.length; i++) {
				st += choosed[i];
			}
			int N = Integer.parseInt(st);
			if(max < N) {
				max = N;
				maxAns = st;
			}
			
			if(min > N) {
				min = N;
				minAns = st;
			}
		}
		for(int i=0; i<9; i++) {
			if(check(num,i,arrIdx)) {
				choosed[arrIdx+1] = i;
				makeNum(i,arrIdx+1);
			}
		}
	}
	
	public static boolean check(int num1, int num2, int arrIdx) {
		if(arr[arrIdx] == '<') {
			return num1 < num2;
		}else {
			return num1 > num2;
		}
	}
}
