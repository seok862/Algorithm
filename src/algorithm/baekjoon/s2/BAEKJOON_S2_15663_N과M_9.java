package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.30
 * @see https://www.acmicpc.net/problem/15663
 * @performance 36964 kb	544 ms
 * @category # 조합
 * @note
 */

public class BAEKJOON_S2_15663_N과M_9 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static Integer[] arr;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
	
		arr = new Integer[N];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr);
		
		set = new LinkedHashSet<String>();
		
		make(0, new int[M], new boolean[arr.length]);
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static void make(int lv, int[] choosed, boolean[] visited) {
		if (lv == choosed.length) {
			StringBuilder st = new StringBuilder();
			for(int i=0; i<choosed.length; i++) {
				st.append(choosed[i]).append(" ");
			}
			set.add(st.toString());
			return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[lv] = arr[i];
                make(lv + 1, choosed, visited);
                visited[i] = false;
            }
        }

	}
}
