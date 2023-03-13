package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_S1_13335_트럭 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,W,L;
	static int[] arr;
	static int sum;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		sum = arr[0];
		int idx = 1;
		
		while(sum > 0) {
			
		}
		
		
	}
}
