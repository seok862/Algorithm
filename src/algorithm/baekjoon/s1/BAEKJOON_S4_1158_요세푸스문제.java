package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.13
 * @see https://www.acmicpc.net/problem/1158
 * @performance 292568 kb	644 ms
 * @category #자료구조 Queue
 * @note
 */

public class BAEKJOON_S4_1158_요세푸스문제 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		output.append("<");
		int n = K-1;
		while(!q.isEmpty()) {
			for(int i=0; i<n; i++) {
				int num = q.poll();
				q.add(num);
			}
			
			output.append(q.poll()).append(", ");
		}
		output.deleteCharAt(output.length()-1);
		output.deleteCharAt(output.length()-1);
		output.append(">");
		System.out.println(output.toString());
	}
	
}
