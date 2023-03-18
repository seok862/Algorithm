package algorithm.baekjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON_S4_2164_카드2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();
	static int ans;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		ans = 0;
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			int num = q.poll();
			q.offer(num);
		}
		
		System.out.println(q.poll());
	}
}
