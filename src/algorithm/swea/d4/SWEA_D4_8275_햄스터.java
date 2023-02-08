package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D4_8275_햄스터 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] choosed;
	static int N,X,M;
	static int a,b,c;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());	// 우리 갯수
			X = Integer.parseInt(tokens.nextToken());	// 최대 햄스터 수
			M = Integer.parseInt(tokens.nextToken());	// 기록 갯수

			choosed = new int[N];
			list = new ArrayList<>();
			make(0,0);
			
			for(int i=0; i<M; i++) {
				tokens = new StringTokenizer(input.readLine());
				a = Integer.parseInt(tokens.nextToken());	// 우리의 no start
				b = Integer.parseInt(tokens.nextToken());	// 우리의 no end
				c = Integer.parseInt(tokens.nextToken());	// 햄스터 마리 수
				
				
				for(int j=list.size()-1; j>=0; j--){
					int sum = 0;
					for(int k=a-1; k<b; k++) {
						sum += list.get(j)[k];
					}
					if(sum != c) {
						list.remove(j);
					}
				}
				
			}
			output.append("#").append(t).append(" ");
			if(list.isEmpty()) {
				output.append("-1");
			}else {
				int max = 0;
				for(int j=0; j<list.get(0).length; j++){
					max += list.get(0)[j];
				}
				
				
				for(int j=list.size()-1; j>=0; j--){
					int tmp = 0;
					for(int k=0; k<list.get(j).length; k++){
						tmp += list.get(j)[k];
					}
					
					if(tmp > max) {
						max = tmp;
					}else if(tmp < max){
						list.remove(j);
					}
				}
				
				for(int j=0; j<list.get(0).length; j++) {
					output.append(list.get(0)[j]).append(" ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	public static void make(int lv, int idx) {
		if(lv == choosed.length) {
			int[] tmp = new int[choosed.length];
			for(int i=0; i<choosed.length; i++) {
				tmp[i] = choosed[i];
			}
			list.add(tmp);
			return;
		}
		
		for(int i=0; i<X+1; i++) {
			choosed[lv] = i;
			make(lv+1, i);
		}
	}
}
