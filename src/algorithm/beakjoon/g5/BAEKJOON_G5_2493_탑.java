package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEKJOON_G5_2493_탑 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Stack<Integer> stack = new Stack<>();
	static int max;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		output.append("0").append(" ");
		int n = Integer.parseInt(tokens.nextToken());
		stack.add(n);
		int max = n;
		int maxIdx = 1;
		for(int i=1; i<N; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(stack.peek() < num) {
				output.append(stack.size()).append(" ");
				max = num;
			}else {
				if(stack.peek() < max) {
			}
		}
		output.deleteCharAt(output.length()-1);
		System.out.println(output.reverse().toString());
	}
}
