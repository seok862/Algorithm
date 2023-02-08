package algorithm.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author seok
 * @since 2023.02.08
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 * @performance 18,468 kb 98 ms
 * @category #idea
 * @note
 */

public class SWEA_D2_1954_달팽이숫자 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int[][] arr;
	static int size;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			size = Integer.parseInt(input.readLine());
			arr = new int[size][size];
			int nowx = 0;
			int nowy = 0;
			
			int num = 1;

			int cnt = size;
			
			for(int i=0; i<2*size-1; i++) {
				switch(i%4) {
				case 0:
					for(int j=0; j<cnt; j++) {
						arr[nowx][nowy] = num;
						nowy++;
						num++;
					}
					nowy--;
					nowx++;
					cnt--;
					
					break;
				case 1:
					for(int j=0; j<cnt; j++) {
						arr[nowx][nowy] = num;
						nowx++;
						num++;
					}
					nowx--;
					nowy--;
					
					break;
				case 2:
					for(int j=0; j<cnt; j++) {
						arr[nowx][nowy] = num;
						nowy--;
						num++;
					}
					nowy++;
					nowx--;
					cnt--;
					
					break;
				case 3:
					for(int j=0; j<cnt; j++) {
						arr[nowx][nowy] = num;
						nowx--;
						num++;
					}
					nowx++;
					nowy++;
					
					break;
				}
			}
			output.append("#").append(t).append("\n");
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					output.append(arr[i][j]).append(" ");
				}
				output.append("\n");
			}
		}
		System.out.println(output.toString());
	}
}
