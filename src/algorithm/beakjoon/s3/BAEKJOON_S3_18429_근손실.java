package algorithm.beakjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. kit의 종류를 담을 수 있는 배열 생성
 * 2. N개의 운동 키트로 만들 수 있는 순열 arr생성
 * 3. 각 arr원소를 더하고 -M를 했을 경우 500미만이 되는 경우가 있으면 return
 * 4. 각 arr배열을 끝까지 돌았을 경우 true면 cnt++
 */

/**
 * @author seok
 * @since 2023.02.21
 * @see https://www.acmicpc.net/problem/18429
 * @performance 12260 kb	100 ms
 * @category # 백트래킹
 * @note
 */

public class BAEKJOON_S3_18429_근손실 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,cnt;
	static int[] kit;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		kit = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		make(0,new int[N], new boolean[N]);
		make(0,500, new boolean[N]);
		
		System.out.println(cnt);
	}
	
	// 백트래킹
	public static void make(int lv, int weight, boolean[] visited) {
		if(weight < 500) {
			return;
		}
		
		if(lv == N) {
			cnt++;
			return;
		}
		
		weight -= M;
		for(int i=0; i<kit.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				make(lv+1, weight+kit[i], visited);
				visited[i] = false;
			}
		}
	}
	
	// 완전탐색
	public static void make(int lv, int[] choosed, boolean[] visited) {
		if(lv == choosed.length) {
			int num = 500;
			for(int i=0; i<choosed.length; i++) {
				num += choosed[i];
				num -= M;
				
				if(num < 500) return;
			}
			cnt++;
			return;
		}

		for(int i=0; i<kit.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[lv] = kit[i];
				make(lv+1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}
