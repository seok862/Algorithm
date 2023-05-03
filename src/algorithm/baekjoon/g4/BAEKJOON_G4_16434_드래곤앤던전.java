package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.03
 * @see https://www.acmicpc.net/problem/16434
 * @performance 52476 kb	408 ms
 * @category # 구현
 * @note
 */

public class BAEKJOON_G4_16434_드래곤앤던전 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N ;
	static long t,a,h, ATK;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		ATK = Long.parseLong(tokens.nextToken());
		long CurHp = 0;
		long MaxHp = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			t = Integer.parseInt(tokens.nextToken());
			a = Integer.parseInt(tokens.nextToken());
			h = Integer.parseInt(tokens.nextToken());
			if (t == 1) {
				int num = 0;
				if(h%ATK == 0) {
					num = 1;
				}
				CurHp += a* ((h / ATK) - num);
				MaxHp = Math.max(MaxHp, CurHp);
            } else {
                ATK += a;
                CurHp = Math.max(CurHp - h, 0);
            }
		}
		
		System.out.println(MaxHp+1);
	}
}
