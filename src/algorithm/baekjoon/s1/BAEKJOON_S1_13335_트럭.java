package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.13
 * @see https://www.acmicpc.net/problem/13335
 * @performance 12872 kb	96 ms	
 * @category # 자료구조 Queue
 * @note
 */

public class BAEKJOON_S1_13335_트럭 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,W,L;
	static int time,sum;
	static Queue<Integer> q = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			q.offer(Integer.parseInt(tokens.nextToken()));
		}
		
		
		for(int i=0; i<W; i++) {
			q2.offer(0);
		}
		
		time = 0;
		sum = 0;
		
		while(!q2.isEmpty()) {
			time++;
			sum -=q2.poll();
			
			if(!q.isEmpty()) {
				if(q.peek()+sum <= L) {
					sum += q.peek();
					q2.offer(q.poll());
				}else {
					q2.offer(0);
				}
			}
		}
		System.out.println(time);
		
		
		
	}
}
