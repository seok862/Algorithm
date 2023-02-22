package algorithm.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_SWTEST_4012_요리사 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Integer> list = new ArrayList<>();
	static int[][] arr;
	static int T,N;
	static int[] ans;
	static int min;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			output.append("#").append(t).append(" ");
			N = Integer.parseInt(input.readLine());
			ans = new int[N/2];
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for(int j=0; j<N; j++){
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			make1(0,new int[N/2], 0);
			
			output.append(min).append("\n");
		}
		
		System.out.println(output.toString());
		
	}
	
	static void make1(int lv, int[] choosed, int startIdx) {
		if(lv==N/2) {
			check(choosed);
			return;
		}
		
		for(int i=startIdx; i<N; i++) {
			choosed[lv] = i;
			make1(lv+1,choosed,i+1);
		}
	}
	
	static void check(int[] choosed) {
		int[] other = new int[choosed.length];
	}
}
