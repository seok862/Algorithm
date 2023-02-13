package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.13
 * @see https://www.acmicpc.net/problem/1759
 * @performance 107444 kb	740 ms
 * @category #자료구조 stack
 * @note
 */
// 
public class BAEKJOON_G5_2493_탑 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Stack<top> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(tokens.nextToken());

			while (true) {
				if (stack.isEmpty()) {
					output.append("0 ");
					stack.add(new top(height, i));
					break;
				}

				top t = stack.peek();

				if (t.height > height) {
					output.append(t.idx).append(" ");
					stack.add(new top(height, i));
					break;
				} else {
					stack.pop();
				}
			}
		}

		System.out.println(output.toString());
	}

	static class top {
		int height;
		int idx;

		top(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
}
