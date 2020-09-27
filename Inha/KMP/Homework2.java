package Inha.KMP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework2 {
	static StringBuilder patternIdx = new StringBuilder();

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Woong/Desktop/textfile.txt");// 파일 클래스로 파일 을 받은다음
		FileReader filereader = new FileReader(file);
		int singleCh = 0;
		StringBuilder stb = new StringBuilder();
		while ((singleCh = filereader.read()) != -1) {
			stb.append((char) singleCh);// stringbuilder 에 read해서 문자를 담아준다.
		}
		filereader.close();
		// System.out.println(stb); // 실행해보면 문자가 stb에 잘담겨온걸 알수 있다.
		System.out.println("12151611 이찬웅  \n-problem 1-");
		System.out.println("특수기호와 숫자를 검색하는것만 보이면 되기 때문에 처음 찾는 위치를 반환하도록 했다.");
		System.out.println("특수기호 \"-\" 찾기");
		int idx = KMP_problem1(stb, "-", initNext("-"));
		System.out.println("KMP_problem1함수가 찾은 idx : " + idx);
		System.out.println("해당 idx의 문자 확인하기 : " + stb.charAt(idx));
		System.out.println("\n특수기호 \"?\" 찾기");
		idx = KMP_problem1(stb, "?", initNext("?"));
		System.out.println("KMP_problem1함수가 찾은 idx : " + idx);
		System.out.println("해당 idx의 문자 확인하기 : " + stb.charAt(idx));
		System.out.println("\n숫자   1  찾기");
		idx = KMP_problem1(stb, "1", initNext("1"));
		System.out.println("KMP_problem1함수가 찾은 idx : " + idx);
		System.out.println("해당 idx의 문자 확인하기 : " + stb.charAt(idx));

		System.out.println("\n-problem 3-");
		System.out.println("해당 위치가 찾고자하는 문자의 시작이 맞는지 확인을 위해 해당위치에서 찾고자하는 pattern 길이만큼더해서  substring으로 확인했다.");
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
		patternIdx = new StringBuilder();// kmp함수에서 시작 idx를 담는 stringbuilder
		cnt = KMP_problem2(stb, pattern, initNext(pattern));// 횟수와 시작 idx를 받아온다.
		System.out.println("\"" + pattern + "\" 문자검색하기");// 해당 pattern 출력
		System.out.println("찾은횟수 : " + cnt);
		System.out.println("찾은 위치 : " + patternIdx);
		System.out.println("해당 위치에서 찾고자 하는 문자인지 각 위치마다 확인");
		String[] str = patternIdx.toString().split(" ");
		for (int i = 0; i < str.length; i++) {
			int start = Integer.parseInt(str[i]);// 해당 idx부터
			int end = start + pattern.length();// 문자의 길이만큼더해
			System.out.print(stb.substring(start, end) + " ");// 전체 문장에서 시작 idx 부터 문자 길이까지 출력
		}
		System.out.println("\n");
	}

	static int[] initNext(String pattern) {// 문자를 비교하다가 틀렸을때 옮기는 위치를 저장하는 next 배열 생성함수
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {// 비교의 시작은 i와 j 로 이루어지는데 i 는 0부터 j는 1부터 시작한다.
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))// j와 i 번째 문자가 틀리면
				j = pi[j - 1];// j-1 틀렸을때의 움직이는 idx로 j를 변경 while문이므로 문자가 틀리면 이를 계속 반보한다.
			if (pattern.charAt(i) == pattern.charAt(j))// 만약 문자가 같으면
				pi[i] = ++j;// i번째 값에 지금의 j 를 저장하고 +1 해준다.
		}
		return pi;
	}

	static int KMP_problem1(StringBuilder text, String pattern, int[] next) {
		int j = 0, plen = pattern.length(), tlen = text.length(); // 각각의 길이를 저장
		int i = 0;

		for (i = 0; i < tlen && j < plen; i++) {// i 는 text의 idx 검사, j는 pattern의 idx검사 각각 길이만큼 for문을 돈다.
			while (text.charAt(i) != pattern.charAt(j) && j > 0)// i와 j의 문자가 틀릴경우 next배열의 j-1 값을 j에 저장한다.
				j = next[j - 1];// while문이므로 틀리면 이를 반복한다.
			if (text.charAt(i) == pattern.charAt(j)) {// 만약 i와 j가 같으면
				if (j == plen - 1) {// j가 pattern 끝가지 검사했다면 해당 패턴이존재
					return i - plen + 1;// i 패턴의 시작위치 idx로 옮긴뒤 return
				} else
					j++;// 패턴의 다음문자를 검사하기위해 이동
			}
		}
		return -1;// 문자를 못찾으면 -1 을 리턴
	}

	static int KMP_problem2(StringBuilder text, String pattern, int[] next) {
		int j = 0, plen = pattern.length(), tlen = text.length();// 각각의 길이를 저장
		int i = 0;
		int cnt = 0;
		for (i = 0; i < tlen && j < plen; i++) {// i 는 text의 idx 검사, j는 pattern의 idx검사 각각 길이만큼 for문을 돈다.
			while (text.charAt(i) != pattern.charAt(j) && j > 0)// i와 j의 문자가 틀릴경우 next배열의 j-1 값을 j에 저장한다.
				j = next[j - 1];// while문이므로 틀리면 이를 반복한다.
			if (text.charAt(i) == pattern.charAt(j)) {// 만약 i와 j가 같으면
				if (j == plen - 1) {// j가 pattern 끝가지 검사했다면 해당 패턴이존재
					patternIdx.append(i - plen + 1).append(" ");// i 패턴의 시작위치 idx로 옮긴뒤 patternIdx에 저장
					j = next[j];// j를 next배열의 j값으로 저장 (이부분은 보고서에서 상세하게 작성할 예정)
					cnt++;// 찾은 횟수를 높여준다.
				} else
					j++;// 패턴의 다음문자를 검사하기위해 이동
			}
		}
		return cnt;// 찾은 횟수 return
	}
}
