package Inha;

import java.util.*;
import java.io.*;

/* 개발자 : 나동빈
 * 작성일자 : 2016-10-06
 * 프로그램 설명 : 허프만 코딩 압축 기법을 이용한 문자열 압축 기법
 */

// 우선순위 큐에 들어갈 노드 클래스 선언
class Node {
	public char character; // 문자 하나를 의미
	public int frequency; // 출현 빈도수를 의미
	public Node left, right; // 왼쪽 노드와 오른쪽 노드
}

// 우선순위 큐의 정렬을 담당하는 빈도수 측정 클래스
class FrequencyComparator implements Comparator<Node> {
	// 빈도수가 낮은 것이 우선순위가 높아 먼저 빠져나올 수 있도록 함
	public int compare(Node a, Node b) {
		int frequencyA = a.frequency;
		int frequencyB = b.frequency;
		return frequencyA - frequencyB;
	}
}

// 메인 클래스 정의
public class Huffamn {

	public static PriorityQueue<Node> queue; // 우선순위 큐 선언
	public static HashMap<Character, String> charToCode = new HashMap<Character, String>(); // 문자에 따른 코드 값 해시 맵 할당

	// 각각의 문자 빈도수에 따라서 트리를 건축하는 메소드
	public static Node huffmanCoding(int n) {

		// 큐에서 2개의 노드를 꺼내 빈도수를 합친 뒤에 우선순위 큐의 형태로 재삽입
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

		// input.txt파일을 읽어 String 형태로 변환
		String text = new Scanner(System.in).next();

		// 각각의 문자에 대한 빈도수를 체크하는 변수 선언
		HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();

		// 전체 문자열의 크기만큼 반복
		for (int i = 0; i < text.length(); i++) {

			// 현재의 문자를 확인하여 temp에 삽입
			char temp = text.charAt(i);

			// 현재 문자가 이미 1번 이상 들어가 있다면 크기를 1 증가
			if (dictionary.containsKey(temp))
				dictionary.put(temp, dictionary.get(temp) + 1);

			// 문자가 처음 들어가는 경우 크기를 1로 설정하여 삽입
			else
				dictionary.put(temp, 1);
		}

		// 모든 노드를 우선순위 큐에 추가함으로써 트리 그룹 형성
		queue = new PriorityQueue<Node>(100, new FrequencyComparator());
		int number = 0;

		// 문자와 그 빈도수가 저장된 각각의 모든 노드들을 우선순위 큐에 삽입
		for (Character c : dictionary.keySet()) {
			Node temp = new Node();
			temp.character = c;
			temp.frequency = dictionary.get(c);
			queue.add(temp); // 우선순위 큐이기 때문에 삽입될 때 빈도 차이에 근거하여 우선순위를 산정 및 트리 구성
			number++;
		}

		// 전체 노드 개수만큼 재배열하여 우선순위 큐 상에서의 노드 재배열
		Node root = huffmanCoding(number);

		// 변수 길이 코드를 생성
		traversal(root, new String());

		// 결과 출력
		String result = new String();
		for (int i = 0; i < text.length(); i++)
			result = result + charToCode.get(text.charAt(i)) + " ";
		System.out.println(result);
	}

	// 순회로 노드를 돌아 코드를 입력
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