package algorithm.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_SWTEST_2115_벌꿀채취 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, M, C;
	static int[][] map;
	static boolean[][] visited;
	static int ans1, ans2;
	static int tot;
	static boolean[] make;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			output.append("#").append(test_case).append(" ");
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			tot = 0;
			map = new int[N][N];
			make = new boolean[M];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			
			selectFirst();
			
			output.append(tot).append("\n");
		}
		
		System.out.println(output);
	}
	
	public static void selectFirst() {
		visited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<=N-M; c++) {
				for(int i=c; i<c+M; i++) {
					visited[r][i] = true;
				}
				
				selectSecond(r,c);
				
				for(int i=c; i<c+M; i++) {
					visited[r][i] = false;
				}
			}
		}
	}
	
	public static void selectSecond(int fr, int fc) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<=N-M; c++) {
				boolean check = true;
				for(int i=c; i<c+M; i++) {
					if(visited[r][i]) {
						check = false;
						break;
					}
				}
				
				if(!check) continue;
				ans1 = 0;
				ans2 = 0;
				
				makeSum(fr, fc, r, c, 0);
				
				tot = Math.max(tot, ans1+ans2);
			}
		}
	}
	
	public static void makeSum(int fr, int fc, int sr, int sc, int lv) {
		if(lv == M) {
			int sum1 = 0;
			int sum2 = 0;
			
			int sumCol1 = 0;
			int sumCol2 = 0;
			
			for(int i=0; i<M; i++) {
				if(make[i]) {
					sum1 += map[fr][fc+i];
					sumCol1 += (int)Math.pow(map[fr][fc+i], 2);
					sum2 += map[sr][sc+i];
					sumCol2 += (int)Math.pow(map[sr][sc+i], 2);
				}
			}
			
			if(sum1 <= C) ans1 = Math.max(ans1, sumCol1);
			if(sum2 <= C) ans2 = Math.max(ans2, sumCol2);
			
			
			return;
		}
		
		make[lv] = true;
		makeSum(fr, fc, sr, sc, lv+1);
		make[lv] = false;
		makeSum(fr, fc, sr, sc, lv+1);
	}
}
