package Inha;

import java.util.*;
import java.io.*;

/* ������ : ������
 * �ۼ����� : 2016-10-06
 * ���α׷� ���� : ������ �ڵ� ���� ����� �̿��� ���ڿ� ���� ���
 */

// �켱���� ť�� �� ��� Ŭ���� ����
class Node {
	public char character; // ���� �ϳ��� �ǹ�
	public int frequency; // ���� �󵵼��� �ǹ�
	public Node left, right; // ���� ���� ������ ���
}

// �켱���� ť�� ������ ����ϴ� �󵵼� ���� Ŭ����
class FrequencyComparator implements Comparator<Node> {
	// �󵵼��� ���� ���� �켱������ ���� ���� �������� �� �ֵ��� ��
	public int compare(Node a, Node b) {
		int frequencyA = a.frequency;
		int frequencyB = b.frequency;
		return frequencyA - frequencyB;
	}
}

// ���� Ŭ���� ����
public class Huffamn {

	public static PriorityQueue<Node> queue; // �켱���� ť ����
	public static HashMap<Character, String> charToCode = new HashMap<Character, String>(); // ���ڿ� ���� �ڵ� �� �ؽ� �� �Ҵ�

	// ������ ���� �󵵼��� ���� Ʈ���� �����ϴ� �޼ҵ�
	public static Node huffmanCoding(int n) {

		// ť���� 2���� ��带 ���� �󵵼��� ��ģ �ڿ� �켱���� ť�� ���·� �����
		for (int i = 0; i < n - 1; i++) {
			Node z = new Node();
			z.right = queue.poll();
			z.left = queue.poll();
			z.frequency = z.right.frequency + z.left.frequency;
			queue.add(z);
		}
		return queue.poll();
	}

	public static void main(String[] args) {

		// input.txt������ �о� String ���·� ��ȯ
		String text = new Scanner(System.in).next();

		// ������ ���ڿ� ���� �󵵼��� üũ�ϴ� ���� ����
		HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();

		// ��ü ���ڿ��� ũ�⸸ŭ �ݺ�
		for (int i = 0; i < text.length(); i++) {

			// ������ ���ڸ� Ȯ���Ͽ� temp�� ����
			char temp = text.charAt(i);

			// ���� ���ڰ� �̹� 1�� �̻� �� �ִٸ� ũ�⸦ 1 ����
			if (dictionary.containsKey(temp))
				dictionary.put(temp, dictionary.get(temp) + 1);

			// ���ڰ� ó�� ���� ��� ũ�⸦ 1�� �����Ͽ� ����
			else
				dictionary.put(temp, 1);
		}

		// ��� ��带 �켱���� ť�� �߰������ν� Ʈ�� �׷� ����
		queue = new PriorityQueue<Node>(100, new FrequencyComparator());
		int number = 0;

		// ���ڿ� �� �󵵼��� ����� ������ ��� ������ �켱���� ť�� ����
		for (Character c : dictionary.keySet()) {
			Node temp = new Node();
			temp.character = c;
			temp.frequency = dictionary.get(c);
			queue.add(temp); // �켱���� ť�̱� ������ ���Ե� �� �� ���̿� �ٰ��Ͽ� �켱������ ���� �� Ʈ�� ����
			number++;
		}

		// ��ü ��� ������ŭ ��迭�Ͽ� �켱���� ť �󿡼��� ��� ��迭
		Node root = huffmanCoding(number);

		// ���� ���� �ڵ带 ����
		traversal(root, new String());

		// ��� ���
		String result = new String();
		for (int i = 0; i < text.length(); i++)
			result = result + charToCode.get(text.charAt(i)) + " ";
		System.out.println(result);
	}

	// ��ȸ�� ��带 ���� �ڵ带 �Է�
	public static void traversal(Node n, String s) {
		if (n == null)
			return;
		traversal(n.left, s + "0");
		traversal(n.right, s + "1");
		if (n.character != '\0') {
			System.out.println(n.character + ": " + s);
			charToCode.put(n.character, s);
		}
	}
}