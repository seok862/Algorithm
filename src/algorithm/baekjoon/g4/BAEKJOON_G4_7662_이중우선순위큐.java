package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.24
 * @see https://www.acmicpc.net/problem/7662
 * @performance 332900 kb	1860 ms	
 * @category # PriorityQueue
 * @note
 */

public class BAEKJOON_G4_7662_이중우선순위큐 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,Q;
	static PriorityQueue<Point> desc;
	static PriorityQueue<Point> asc;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=0; test_case<T; test_case++) {
			Q = Integer.parseInt(input.readLine());
			
			desc = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return Integer.compare(o2.num, o1.num);
				}
				
			});
			
			asc = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return Integer.compare(o1.num, o2.num);
				}
				
			});
			
			for(int t=0; t<Q; t++) {
				tokens = new StringTokenizer(input.readLine());
				
				String s = tokens.nextToken();
				int n = Integer.parseInt(tokens.nextToken());
				
				function(s,n);
			}
			
			Point max = poll(desc);
			Point min = poll(asc);
			if(max == null) output.append("EMPTY").append("\n");
			else {
				if(min == null) {
					min = max;
				}
				output.append(max.num).append(" ").append(min.num).append("\n");
			}
		}
		
		System.out.println(output);
	}
	
	public static void function(String s, int n) {
		if(s.equals("I")) {
			Point p = new Point(n,true);
			desc.offer(p);
			asc.offer(p);
		}else {
			if(n==1){
				poll(desc);
			}else {
				poll(asc);
			}
		}
	}
	
	public static Point poll(PriorityQueue<Point> pq) {
		while(!pq.isEmpty()) {
			Point tmp = pq.poll();
			if(tmp.check) {
				tmp.check = false;
				return tmp;
			}
		}
		
		return null;
	}
	
	public static class Point{
		int num;
		boolean check;
		public Point(int num, boolean check) {
			this.num = num;
			this.check = check;
		}
	}
}
