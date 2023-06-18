package algorithm.baekjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.18
 * @see https://www.acmicpc.net/problem/1251
 * @performance 29136 kb	144 ms	
 * @category # 정렬
 * @note
 */

public class BAEKJOON_S5_1251_단어나누기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String st;
	
	public static void main(String[] args) throws IOException {
		st = input.readLine();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=1; i<st.length()-1; i++) {
			String[] arr = new String[3];
			for(int j=i+1; j<st.length(); j++) {
				arr[0] = st.substring(0,i);
				arr[1] = st.substring(i,j);
				arr[2] = st.substring(j,st.length());
				
				String tmp = "";
				for(int a=0; a<3; a++) {
					for(int b = arr[a].length()-1; b>=0; b--) {
						tmp += arr[a].charAt(b);
					}
				}
				
				list.add(tmp);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
		
	}
}
