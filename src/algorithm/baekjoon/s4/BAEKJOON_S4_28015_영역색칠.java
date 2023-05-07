package algorithm.baekjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S4_28015_영역색칠 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;
	static int[][] arr, arr2;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		arr = new int[N][M + 1];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());

			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		arr2 = new int[N][M + 1];

		for(int i=0; i<N; i++) {
			for(int j=1; j<M+1; j++) {
				if(arr[i][j] != 0) {
					arr2[i][j] = 1;
					if(arr2[i][j] != arr2[i][j-1] && arr[i][j] == arr2[i][j]) {
						cnt++;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<M+1; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			
		}
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<M+1; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		arr2 = new int[N][M + 1];
		int cnt2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=1; j<M+1; j++) {
				if(arr[i][j] != 0) {
					arr2[i][j] = 2;
					if(arr2[i][j] != arr2[i][j-1] && arr[i][j] == arr2[i][j]) {
						cnt2++;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<M+1; j++) {
				if(arr[i][j] == 1) {
					arr2[i][j] = 1;
					if(arr2[i][j] != arr2[i][j-1] && arr[i][j] == arr2[i][j]) {
						cnt2++;
					}
				}
			}
		}
		
		System.out.println(Math.min(cnt, cnt2));
	}
}
