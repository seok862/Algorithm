package algorithm.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @author seok
 * @since 2023.02.13
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=%EC%95%94%ED%98%B8%EB%AC%B81&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 18,348 kb 105 ms
 * @category #자료구조 list
 * @note
 */


public class SWEA_D3_1228_암호문1 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		for(int t=1; t<=10; t++) {
			list = new ArrayList<>();
			output.append("#").append(t).append(" ");
			int N = Integer.parseInt(input.readLine());
			
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(tokens.nextToken()));
			}
			
			int cnt = Integer.parseInt(input.readLine());
			
			tokens = new StringTokenizer(input.readLine());
			
			int index = 0;
			int count = 0;
			while(tokens.hasMoreTokens()) {
				if(tokens.nextToken().equals("I")) {
					index = Integer.parseInt(tokens.nextToken());
					count = Integer.parseInt(tokens.nextToken());
					
					for(int j=0; j<count; j++) {
						list.add(index++, Integer.parseInt(tokens.nextToken()));
					}
				}
			}
			
			for(int i=0; i<10; i++) {
				output.append(list.get(i)).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}
}
