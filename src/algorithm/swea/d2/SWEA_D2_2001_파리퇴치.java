package algorithm.swea.d2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리퇴치 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			int max =0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int sum = 0;
					
					for(int a=i; a<i+M; a++) {
						for(int b=j; b<j+M; b++) {
							sum += arr[a][b];
						}
					}
					
					max = Math.max(sum, max);
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
}
