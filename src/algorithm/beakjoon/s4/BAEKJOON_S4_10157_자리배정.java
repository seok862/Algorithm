package algorithm.beakjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/10157
 * @performance 19684 kb	128 ms
 * @category # 구현
 * @note
 */

public class BAEKJOON_S4_10157_자리배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int R,C,N;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		N = Integer.parseInt(input.readLine());
		
		map = new int[R][C];

		int n = 0;
		int nowx = R-1;
		int nowy = 0;
		int cnt = 1;
		if(N <= R*C) {
			while(true) {
				
				for(int i=0; i<R-n; i++) {
					map[nowx--][nowy] = cnt++;
				}
				
				nowx++;
				nowy++;
				n++;
				
				if(cnt > N) break;
				
				for(int i=0; i<C-n; i++) {
					map[nowx][nowy++] = cnt++;
					
				}
				
				nowy--;
				nowx++;
				
				if(cnt > N) break;
				
				for(int i=0; i<R-n; i++) {
					map[nowx++][nowy] = cnt++;
				}
				
				nowx--;
				nowy--;
				n++;
				
				if(cnt > N) break;
				
				for(int i=0; i<C-n; i++) {
					map[nowx][nowy--] = cnt++;
				}
				
				nowy++;
				nowx--;
				
				if(cnt > N) break;
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == N) {
						System.out.println((j+1)+" "+(R-i));
						System.exit(0);
					}
				}
			}
		}else {
			System.out.println(0);
		}
	}
}
