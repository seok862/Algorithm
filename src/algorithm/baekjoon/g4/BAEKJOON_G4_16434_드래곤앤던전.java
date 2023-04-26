package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G4_16434_드래곤앤던전 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ATK;
	static int t,a,h;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		ATK = Integer.parseInt(tokens.nextToken());
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			t = Integer.parseInt(tokens.nextToken());
			a = Integer.parseInt(tokens.nextToken());
			h = Integer.parseInt(tokens.nextToken());
			
			if(t==1) {
				
			}else {
				
			}
		}
		
	}
}
