import java.util.Arrays;

public class ex {

	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
//		makePermutation(0, new char[3], new boolean[src.length]);
		makeCombination(0, new char[3], 0);
	}

	static void makePermutation(int lv, char[] choosed, boolean[] visited) {
		if (lv == choosed.length) {
			System.out.println(Arrays.toString(choosed));
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[lv] = src[i];
				makePermutation(lv + 1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	
	 static void makeCombination(int nthChoice, char[] choosed, int startIdx) {
	        if (nthChoice == choosed.length) {
	            System.out.println(Arrays.toString(choosed));
	            return;
	        }
	        for (int i = startIdx; i < src.length; i++) {
	            choosed[nthChoice] = src[i];
	            makeCombination(nthChoice + 1, choosed, i + 1);
	        }
	    }

}