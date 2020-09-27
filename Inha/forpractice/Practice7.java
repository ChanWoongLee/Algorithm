package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.naming.ldap.HasControls;

public class Practice7 {
	static ArrayList<String>[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int dict = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int make = Integer.parseInt(st.nextToken());
		data = new ArrayList[59];
		for (int i = 0; i < data.length; i++)
			data[i] = new ArrayList();

		st = new StringTokenizer(bf.readLine());
		int size = st.countTokens();

		for (int i = 0; i < size; i++) {
			put(st.nextToken(), i);
		}
		st = new StringTokenizer(bf.readLine());
		size = st.countTokens();

		for (int i = 0; i < size; i++) {
			if (get(st.nextToken()) == -1) {
				System.out.println("0");
				return;
			}
		}
		System.out.println("1");
	}

	static int convertToIndex(int hashCode) {
		return hashCode;
	}

	static void put(String key, int value) {

		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		data[index].add(key);
	}

	static int get(String key) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		if (data[index].contains(key))
			return 1;
		else
			return -1;
	}

	static int getHashCode(String key) {
		int hashCode = key.charAt(0) - 'A';
		hashCode = Math.abs(hashCode);
		return hashCode;
	}

}

class Item {
	String key;
	int value;

	public Item(String key, int value) {
		this.key = key;
		this.value = value;
	}
}
