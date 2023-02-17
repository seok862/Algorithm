package algorithm.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808_규영이와인영이의카드게임 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr1;
	static int[] arr2;
	static boolean[] check;
	static int win;
	static int lose;
	static int sum;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			output.append("#").append(t).append(" ");
			tokens = new StringTokenizer(input.readLine());
			arr1 = new int[9];
			arr2 = new int[9];
			check = new boolean[19];
			win = 0;
			lose = 0;
			sum = 0;
			for(int i=0; i<arr1.length; i++) {
				int num = Integer.parseInt(tokens.nextToken());
				arr1[i] = num;
				check[num] = true;
				
			}
			
			for(int i=0; i<9; i++) {
				for(int j=1; j<19; j++) {
					if(!check[j]) {
						arr2[i] = j;
						check[j] = true;
						break;
					}
				}
			}
			
			make(0,new int[9],new boolean[9]);
			
			output.append(win).append(" ").append(lose).append("\n");
		}
		
		System.out.println(output.toString());
	}
	
	public static void make(int lv, int[] choosed, boolean[] visited) {
		if(lv == choosed.length) {
			
			for(int i=0; i<choosed.length; i++) {
				if(choosed[i] < arr1[i]) {
					sum += choosed[i]+arr1[i];
				}
			}
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[lv] = arr2[i];
				make(lv+1, choosed, visited);
				visited[i] = false;
			}
		}
		
	}
}
