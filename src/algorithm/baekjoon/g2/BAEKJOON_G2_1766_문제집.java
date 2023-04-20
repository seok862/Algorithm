package algorithm.baekjoon.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.04.20
* @see https://www.acmicpc.net/problem/1766
* @performance 	47884 kb	464 ms	
* @category # pq, 위상정렬
* @note
*/
public class BAEKJOON_G2_1766_문제집 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static int[] edge;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		edge = new int[N+1];
		
		list = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			list.get(a).add(b);
			edge[b]++;
		}
		
		getOrder();
		System.out.println(output);
	}
	
	public static void getOrder() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=1; i<N+1; i++) {
			if(edge[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int point = q.poll();
			
			output.append(point).append(" ");
			
			for(int i=0; i<list.get(point).size(); i++) {
				edge[list.get(point).get(i)]--;
				
				if(edge[list.get(point).get(i)] == 0) {
					q.add(list.get(point).get(i));
				}
			}
		}
	}
}
