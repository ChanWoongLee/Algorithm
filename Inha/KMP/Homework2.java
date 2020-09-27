package Inha.KMP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework2 {
	static StringBuilder patternIdx = new StringBuilder();

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Woong/Desktop/textfile.txt");// ���� Ŭ������ ���� �� ��������
		FileReader filereader = new FileReader(file);
		int singleCh = 0;
		StringBuilder stb = new StringBuilder();
		while ((singleCh = filereader.read()) != -1) {
			stb.append((char) singleCh);// stringbuilder �� read�ؼ� ���ڸ� ����ش�.
		}
		filereader.close();
		// System.out.println(stb); // �����غ��� ���ڰ� stb�� �ߴ�ܿ°� �˼� �ִ�.
		System.out.println("12151611 ������  \n-problem 1-");
		System.out.println("Ư����ȣ�� ���ڸ� �˻��ϴ°͸� ���̸� �Ǳ� ������ ó�� ã�� ��ġ�� ��ȯ�ϵ��� �ߴ�.");
		System.out.println("Ư����ȣ \"-\" ã��");
		int idx = KMP_problem1(stb, "-", initNext("-"));
		System.out.println("KMP_problem1�Լ��� ã�� idx : " + idx);
		System.out.println("�ش� idx�� ���� Ȯ���ϱ� : " + stb.charAt(idx));
		System.out.println("\nƯ����ȣ \"?\" ã��");
		idx = KMP_problem1(stb, "?", initNext("?"));
		System.out.println("KMP_problem1�Լ��� ã�� idx : " + idx);
		System.out.println("�ش� idx�� ���� Ȯ���ϱ� : " + stb.charAt(idx));
		System.out.println("\n����   1  ã��");
		idx = KMP_problem1(stb, "1", initNext("1"));
		System.out.println("KMP_problem1�Լ��� ã�� idx : " + idx);
		System.out.println("�ش� idx�� ���� Ȯ���ϱ� : " + stb.charAt(idx));

		System.out.println("\n-problem 3-");
		System.out.println("�ش� ��ġ�� ã�����ϴ� ������ ������ �´��� Ȯ���� ���� �ش���ġ���� ã�����ϴ� pattern ���̸�ŭ���ؼ�  substring���� Ȯ���ߴ�.");
		print(stb, "aba");
		print(stb, "aa");
		System.out.println("\n-problem 4-");
		print(stb, "similar");
		print(stb, "satisfy");
		print(stb, "refer");
		print(stb, "representation");
		print(stb, "connection");

	}

	static void print(StringBuilder stb, String pattern) {
		int cnt;
		patternIdx = new StringBuilder();// kmp�Լ����� ���� idx�� ��� stringbuilder
		cnt = KMP_problem2(stb, pattern, initNext(pattern));// Ƚ���� ���� idx�� �޾ƿ´�.
		System.out.println("\"" + pattern + "\" ���ڰ˻��ϱ�");// �ش� pattern ���
		System.out.println("ã��Ƚ�� : " + cnt);
		System.out.println("ã�� ��ġ : " + patternIdx);
		System.out.println("�ش� ��ġ���� ã���� �ϴ� �������� �� ��ġ���� Ȯ��");
		String[] str = patternIdx.toString().split(" ");
		for (int i = 0; i < str.length; i++) {
			int start = Integer.parseInt(str[i]);// �ش� idx����
			int end = start + pattern.length();// ������ ���̸�ŭ����
			System.out.print(stb.substring(start, end) + " ");// ��ü ���忡�� ���� idx ���� ���� ���̱��� ���
		}
		System.out.println("\n");
	}

	static int[] initNext(String pattern) {// ���ڸ� ���ϴٰ� Ʋ������ �ű�� ��ġ�� �����ϴ� next �迭 �����Լ�
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {// ���� ������ i�� j �� �̷�����µ� i �� 0���� j�� 1���� �����Ѵ�.
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))// j�� i ��° ���ڰ� Ʋ����
				j = pi[j - 1];// j-1 Ʋ�������� �����̴� idx�� j�� ���� while���̹Ƿ� ���ڰ� Ʋ���� �̸� ��� �ݺ��Ѵ�.
			if (pattern.charAt(i) == pattern.charAt(j))// ���� ���ڰ� ������
				pi[i] = ++j;// i��° ���� ������ j �� �����ϰ� +1 ���ش�.
		}
		return pi;
	}

	static int KMP_problem1(StringBuilder text, String pattern, int[] next) {
		int j = 0, plen = pattern.length(), tlen = text.length(); // ������ ���̸� ����
		int i = 0;

		for (i = 0; i < tlen && j < plen; i++) {// i �� text�� idx �˻�, j�� pattern�� idx�˻� ���� ���̸�ŭ for���� ����.
			while (text.charAt(i) != pattern.charAt(j) && j > 0)// i�� j�� ���ڰ� Ʋ����� next�迭�� j-1 ���� j�� �����Ѵ�.
				j = next[j - 1];// while���̹Ƿ� Ʋ���� �̸� �ݺ��Ѵ�.
			if (text.charAt(i) == pattern.charAt(j)) {// ���� i�� j�� ������
				if (j == plen - 1) {// j�� pattern ������ �˻��ߴٸ� �ش� ����������
					return i - plen + 1;// i ������ ������ġ idx�� �ű�� return
				} else
					j++;// ������ �������ڸ� �˻��ϱ����� �̵�
			}
		}
		return -1;// ���ڸ� ��ã���� -1 �� ����
	}

	static int KMP_problem2(StringBuilder text, String pattern, int[] next) {
		int j = 0, plen = pattern.length(), tlen = text.length();// ������ ���̸� ����
		int i = 0;
		int cnt = 0;
		for (i = 0; i < tlen && j < plen; i++) {// i �� text�� idx �˻�, j�� pattern�� idx�˻� ���� ���̸�ŭ for���� ����.
			while (text.charAt(i) != pattern.charAt(j) && j > 0)// i�� j�� ���ڰ� Ʋ����� next�迭�� j-1 ���� j�� �����Ѵ�.
				j = next[j - 1];// while���̹Ƿ� Ʋ���� �̸� �ݺ��Ѵ�.
			if (text.charAt(i) == pattern.charAt(j)) {// ���� i�� j�� ������
				if (j == plen - 1) {// j�� pattern ������ �˻��ߴٸ� �ش� ����������
					patternIdx.append(i - plen + 1).append(" ");// i ������ ������ġ idx�� �ű�� patternIdx�� ����
					j = next[j];// j�� next�迭�� j������ ���� (�̺κ��� �������� ���ϰ� �ۼ��� ����)
					cnt++;// ã�� Ƚ���� �����ش�.
				} else
					j++;// ������ �������ڸ� �˻��ϱ����� �̵�
			}
		}
		return cnt;// ã�� Ƚ�� return
	}
}
