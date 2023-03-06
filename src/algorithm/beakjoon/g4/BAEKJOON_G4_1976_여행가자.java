package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.06
 * @see https://www.acmicpc.net/problem/1976
 * @performance 15912 kb	136 ms
 * @category # 유니온파인드
 * @note
 */

public class BAEKJOON_G4_1976_여행가자 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static int[] repres;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		repres = new int[N+1];
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		makeSet();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					union(r+1,c+1);
				}
			}
		}
		tokens = new StringTokenizer(input.readLine());
		
		int num = Integer.parseInt(tokens.nextToken());
		boolean check = true;
		
		for(int i=1; i<M; i++) {
			int n = Integer.parseInt(tokens.nextToken());
			
			if(repres[num] != repres[n]) check = false;
		}
		
		System.out.println(check?"YES":"NO");
	}
	
	public static void makeSet() {
		for(int i=1; i<N+1; i++) {
			repres[i] = i;
		}
	}
	
	 public static int findSet(int a) {
		 if(repres[a] == a) {
			 return a;
		 }
		 return repres[a] = findSet(repres[a]);
	 }
	 
	 public static void union(int a, int b) {
		 a= findSet(a);
		 b= findSet(b);
		 
		 if(a != b) {
			 if(a>b) {
				 repres[a] = b;
			 }else {
				 repres[b] = a;
			 }
		 }
	 }
}
