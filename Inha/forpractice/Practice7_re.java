package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice7_re {
	public static void check(ChainHash chainHash, String nums[]) {
		boolean check = false;

		for (String s : nums) {
			check = chainHash.search(s);
			if (check == false) {
				System.out.println("0");
				return;
			}
		}
		System.out.println("1");

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int dict = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int make = Integer.parseInt(st.nextToken());

		ChainHash chainHash = new ChainHash();
		st = new StringTokenizer(bf.readLine());
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			chainHash.add(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		size = st.countTokens();
		String[] nums = new String[make];
		for (int i = 0; i < size; i++) {
			nums[i] = st.nextToken();
		}

		check(chainHash, nums);
	}
}

class ChainHash {
	private Node[] table;

	class Node {
		private String number;
		private Node next;

		public Node(String number, Node next) {
			this.number = number;
			this.next = next;
		}

		public String getnumber() {
			return number;
		}

		public int hashCode() {
			return number.charAt(0) - '0';
		}
	}

	public ChainHash() {
		table = new Node[1000];
	}

	public boolean search(String number) {
		int hash = number.charAt(0) - '0';
		Node p = table[hash];
		while (p != null) {
			if (number.equals(p.getnumber())) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	public void add(String number) {
		int hash = number.charAt(0) - '0';
		Node p = table[hash];
		while (p != null) {
			if (p.getnumber().equals(number))
				return;
			p = p.next;
		}
		Node temp = new Node(number, table[hash]);
		table[hash] = temp;
		return;
	}
}