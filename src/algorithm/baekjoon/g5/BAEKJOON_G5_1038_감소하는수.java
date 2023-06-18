package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.18
 * @see https://www.acmicpc.net/problem/1038
 * @performance 11656 kb	80 ms
 * @category # dfs
 * @note
 */

public class BAEKJOON_G5_1038_감소하는수 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static ArrayList<Long> list;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		list = new ArrayList<>();
		
		if(N <= 10) {
			System.out.println(N);
		}else if (N > 1022){
			System.out.println(-1);
		}else {
			for(int i=0; i<10; i++) {
				dfs(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(N));
		}
	}
	
	public static void dfs(long num, int lv) {
		if(lv > 10) {
			return;
		}
		
		list.add(num);
		for(int i=0; i<num%10; i++) {
			dfs((num*10)+i, lv+1);
		}
	}
}
