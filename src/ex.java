import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex{
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr= {'a','b','c','d','e'};
	public static void main(String[] args) {
		makePermutation(0,new char[3], new boolean[arr.length]);
		
//		makeCombination(0, new char[3], 0);
		
//		powerSet(0, new boolean[arr.length]);
	}
	
	static void makePermutation(int lv, char[] choosed, boolean[] check) {
		if(lv==choosed.length) {
			System.out.println(Arrays.toString(choosed));
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				
			}
		}
	}
}