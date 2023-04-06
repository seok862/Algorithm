package algorithm.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607_조합 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int p = 1234567891;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			output.append("#").append(t).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			
			int n = Integer.parseInt(tokens.nextToken());
			int r = Integer.parseInt(tokens.nextToken());
			
			output.append(combination(n,r)).append("\n");
		}
		System.out.println(output);
	}
	
	public static long combination(int n, int r) {
		if(r ==0) {
			return 1;
		}
		
		long[] fac = new long[n+1];
		
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1]*i%p;
		}
		
		return (((fac[n]%p)*(power(fac[r], p-2)%p))%p*(power(fac[n-r], p-2)%p))%p;
	}
	
	public static long power(long fac, long y) {
		long tmp = 1;
		fac = fac%p;
		
		while(y>0) {
			if(y%2 == 1) {
				tmp = (tmp*fac)%p;
			}
			
			y/=2;
			fac = (fac*fac)%p;
		}
		
		return tmp;
	}
}
