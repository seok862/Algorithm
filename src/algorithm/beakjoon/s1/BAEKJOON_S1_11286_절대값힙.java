package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEKJOON_S1_11286_절대값힙 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			int num1 = Math.abs(o1);
			int num2 = Math.abs(o2);
			if(num1 == num2) return o1-o2;
			else return num1-num2;
		}
	});
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(input.readLine());
			
			if(num == 0) {
				if(p.isEmpty()) output.append(0).append("\n");
				else {
					output.append(p.poll()).append("\n");
				}
			}else {
				p.add(num);
			}
		}
		
		System.out.println(output.toString());
	}
}
