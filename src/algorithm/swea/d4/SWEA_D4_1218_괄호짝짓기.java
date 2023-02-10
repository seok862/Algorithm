package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * @author seok
 * @since 2023.02.10
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=%EA%B4%84%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 19,340 kb	120 ms
 * @category #자료구조 stack
 * @note
 */


public class SWEA_D4_1218_괄호짝짓기 {

	static Stack<Character> stack;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= 10; t++) {
			stack = new Stack<>();
			int N = Integer.parseInt(input.readLine());

			output.append("#").append(t).append(" ");

			String tmp = input.readLine();
			stack.add(tmp.charAt(0));
			for (int i = 1; i < tmp.length(); i++) {
				char st = tmp.charAt(i);

				switch (st) {
				case ')':
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.add(st);
					}
					break;
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						stack.add(st);
					}
					break;
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						stack.add(st);
					}
					break;
				case '>':
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						stack.add(st);
					}
					break;
				default:
					stack.add(st);
				}
			}

			if (stack.isEmpty()) {
				output.append("1");
			} else {
				output.append("0");
			}

			output.append("\n");
		}

		System.out.println(output.toString());
	}
}
