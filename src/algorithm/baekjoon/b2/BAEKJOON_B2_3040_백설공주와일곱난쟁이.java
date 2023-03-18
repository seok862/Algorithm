package algorithm.baekjoon.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author seok
 * @since 2023.02.17
 * @see https://www.acmicpc.net/problem/3040
 * @performance 11884 kb	84 ms
 * @category # 조합
 * @note
 */


public class BAEKJOON_B2_3040_백설공주와일곱난쟁이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int[] arr;
	static int[] choosed;
	public static void main(String[] args) throws IOException {
		
		arr = new int[9];
		choosed = new int[7];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		make(0,0);
	}
	
	public static void make(int lv, int start) {
		if(lv == choosed.length) {
			int sum = 0;
			for(int i : choosed) {
				sum += i;
			}
			
			if(sum == 100) {
				for(int i : choosed) {
					System.out.println(i);
				}
				System.exit(0);
			}
			
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			choosed[lv] = arr[i];
			make(lv+1,i+1);
		}
	}
}
