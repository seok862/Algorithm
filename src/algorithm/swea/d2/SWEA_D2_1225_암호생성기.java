package algorithm.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.08
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 * @performance 22,452 kb	141 ms
 * @category #자료구조 Queue
 * @note
 */

public class SWEA_D2_1225_암호생성기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		
		for(int t=1; t<=10; t++) {
			input.readLine();
			tokens = new StringTokenizer(input.readLine());
			output.append("#").append(t).append(" ");
			Queue<Integer> q = new LinkedList<>();
			
			while(tokens.hasMoreTokens()) {
				q.offer(Integer.parseInt(tokens.nextToken()));
			}
			boolean check = true;
			while(check) {
				int cnt = 1;
				for(int i=0; i<5; i++) {
					int num = q.poll();
					num -= cnt++;
					if(num <= 0) num = 0;
					
					q.add(num);
					
					if(num == 0) {
						check = false;
						break;
					}
				}
			}
			
			while(!q.isEmpty()) {
				output.append(q.poll()).append(" ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}
}
