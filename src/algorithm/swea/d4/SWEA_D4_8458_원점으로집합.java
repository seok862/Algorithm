package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_8458_원점으로집합 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			output.append("#").append(test_case).append(" ");
			N = Integer.parseInt(input.readLine());
			
			arr = new int[N];
			
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				int r = Integer.parseInt(tokens.nextToken());
				int c = Integer.parseInt(tokens.nextToken());
				
				int num = Math.abs(r-0)+Math.abs(c-0);
				int sum = 0;
				
				int idx = 1;
				while(num>0) {
					sum+=idx;
					num -= idx++;
				}
				idx--;
				if(num == 0) {
					arr[n] = idx;
				}else {
					num += idx;
					if(num%2 == 0) {
						if(idx%2 == 0) {
							arr[n] = idx;
						}else {
							arr[n] = idx+2;
						}
					}else if(num%2 != 0){
						if(idx%2 == 0) {
							arr[n] = idx+1;
						}else {
							arr[n] = idx;
						}
					}
				}
			}
			
			Arrays.sort(arr);
			
			boolean check = true;
			
			for(int i=0; i<N-1; i++) {
				if((arr[i+1]-arr[i])%3 != 0) check = false;
			}
			
			if(check) {
				output.append(arr[arr.length-1]).append("\n");
			}else {
				output.append(-1).append("\n");
			}
		}
		System.out.println(output);
	}
	
}
