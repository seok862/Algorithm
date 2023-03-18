package algorithm.baekjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author seok
 * @since 2023.03.09
 * @see https://www.acmicpc.net/problem/1181
 * @performance 28332 kb	264 ms
 * @category # comparator
 * @note
 */

public class BAEKJOON_S5_1181_단어정렬 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static String[] arr;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = input.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else if(o1.length() > o2.length()){
					return 1;
				}else {
					return -1;
				}
			}
		});
		output.append(arr[0]).append("\n");
		for(int i=1; i<arr.length; i++) {
			if(arr[i].equals(arr[i-1])) continue;
			
			output.append(arr[i]).append("\n");
		}
		
		System.out.println(output);
	}
}
