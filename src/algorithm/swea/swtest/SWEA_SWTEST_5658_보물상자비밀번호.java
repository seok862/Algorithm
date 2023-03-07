package algorithm.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_SWTEST_5658_보물상자비밀번호 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, K;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			set = new HashSet<>();
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			String st = input.readLine();

			for(int i=0; i<N; i++) {
				
				int startIdx = i;
				String tmp = "";
				for(int j=0; j<N/4; j++) {
					tmp += st.substring(startIdx,startIdx+1);
					startIdx++;
					
					if(startIdx == N) startIdx = 0;
				}
				
				set.add(tmp);
			}
			
			ArrayList<String> list = new ArrayList<>(set);
			
			Collections.sort(list);
			
			output.append("#").append(test_case).append(" ");
			output.append(Integer.parseInt(list.get(list.size()-K),16)).append("\n");
		}
		System.out.println(output);
	}
}
