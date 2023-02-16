package algorithm.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.16
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=%ED%96%84%EB%B2%84%EA%B1%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 20,740 kb	710 ms
 * @category #부분집합
 * @note
 */


public class SWEA_D3_5215_햄버거다이어트 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr1;
	static int[] arr2;
	static int max;
	static int N,L;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			
			arr1 = new int[N];
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				arr1[i] = Integer.parseInt(tokens.nextToken());
				arr2[i] = Integer.parseInt(tokens.nextToken());
			}
			make(0,new boolean[N]);
			output.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(output.toString());
	}
	
	static void make(int lv, boolean[] check) {
		if(lv == check.length) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<check.length; i++) {
				if(check[i]) {
					sum1 += arr1[i];
					sum2 += arr2[i];
				}
			}
			
			if(max < sum1 && sum2 < L) {
				max = sum1;
			}
			return;
		}
		
		check[lv] = true;
		make(lv+1,check);
		check[lv] = false;
		make(lv+1,check);
	}
}

