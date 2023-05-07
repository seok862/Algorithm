import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Floyd{
	private static char[] arr = {'a','b','c','d','e'};
	
	public static void main(String[] args) throws IOException {
//		makePermutation(0, new boolean[arr.length], new char[4]);
//		makeCombination(0, new char[4], 0);
		powerSetDupPer(0, new boolean[4]);
	}
	
	static void makePermutation(int lv, boolean[] visited, char[] choosed) {
		if(lv==4) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[lv] = arr[i];
				makePermutation(lv+1, visited, choosed);
				visited[i] = false;
			}
		}
	}
	
	static void makeCombination(int lv, char[] choosed, int startIdx) {
		if(lv == 4) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=startIdx; i<arr.length; i++) {
			choosed[lv] = arr[i];
			makeCombination(lv+1, choosed, startIdx);
		}
	}
	
	static void powerSetDupPer(int lv, boolean[] visited) {
		if(lv == visited.length) {
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			
			return;
		}
		
		visited[lv] = true;
		powerSetDupPer(lv+1, visited);
		visited[lv] = false;
		powerSetDupPer(lv+1, visited);
	}
}