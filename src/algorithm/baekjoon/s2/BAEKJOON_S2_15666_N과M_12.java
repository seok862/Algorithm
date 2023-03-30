package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.30
 * @see https://www.acmicpc.net/problem/15666
 * @performance 12064 kb	92 ms
 * @category # 조합
 * @note
 */

public class BAEKJOON_S2_15666_N과M_12 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static Integer[] arr;
	static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
	
		arr = new Integer[N];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		set = new HashSet<Integer>(Arrays.asList(arr));
		
		arr = set.toArray(new Integer[0]);
		
		Arrays.sort(arr);
		
		make(0, new int[M], 0);
		
		System.out.println(output);
	}
	
	public static void make(int lv, int[] choosed, int startIdx) {
		if (lv == choosed.length) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
        }
		
        for (int i = startIdx; i <arr.length; i++) {
           choosed[lv] = arr[i];
           make(lv+1, choosed, i);
        }

	}
}
