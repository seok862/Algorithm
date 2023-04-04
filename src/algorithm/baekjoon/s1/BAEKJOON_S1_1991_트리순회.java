package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.04
 * @see https://www.acmicpc.net/problem/1991
 * @performance 11600 kb	80 ms
 * @category # 재귀
 * @note
 */

public class BAEKJOON_S1_1991_트리순회 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static Node n = new Node('A', null, null);

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		map = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());

			char mid = tokens.nextToken().charAt(0);
			char left = tokens.nextToken().charAt(0);
			char right = tokens.nextToken().charAt(0);

			insertNode(n, mid, left, right);
		}

		preOrder(n);
		System.out.println();
		inOrder(n);
		System.out.println();
		postOrder(n);
		System.out.println();

	}

	public static void insertNode(Node temp, char root, char left, char right) {

		if (temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (temp.left != null)
				insertNode(temp.left, root, left, right);
			if (temp.right != null)
				insertNode(temp.right, root, left, right);
		}
	}

	public static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}

	public static class Node {
		char value;
		Node left;
		Node right;

		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

}
