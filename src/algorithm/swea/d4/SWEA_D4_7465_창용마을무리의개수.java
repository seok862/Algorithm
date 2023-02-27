package algorithm.swea.d4;
/**
 * @author seok
 * @since 2023.02.27
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU&categoryId=AWngfZVa9XwDFAQU&categoryType=CODE&problemTitle=%EC%B0%BD%EC%9A%A9&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 21,536 kb	131 ms
 * @category # 서로소집합
 * @note
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_7465_창용마을무리의개수 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] repres;
	static int N,M;
	static int cnt;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			output.append("#").append(t).append(" ");
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			cnt = N;
			makeSet();
			for(int i=0; i<M; i++) {
				tokens = new StringTokenizer(input.readLine());
				int f1 = Integer.parseInt(tokens.nextToken())-1;
				int f2 = Integer.parseInt(tokens.nextToken())-1;
				if(union(f1,f2)) cnt--;
			}
			output.append(cnt).append("\n");
		}
		
		System.out.println(output.toString());
	}
	
	static void makeSet() {
        repres = new int[N];
        for (int n = 0; n < N; n++) {
            repres[n] = n; 
        }
    }
	
	static int findSet(int a) {
        if (repres[a] == a) {
            return a;
        } else {
            return repres[a] = findSet(repres[a]);
        }
    }
	
	static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b) {
            return false;
        } else {
            repres[a] = b;
            return true;
        }
    }
}
