package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17273 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Card[] card = new Card[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			card[i] = new Card(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < N; j++) {
				if(card[j].value <= num)
					card[j].change();
			}
		}
		int result = 0;
		for(Card c : card) {
			result += c.value;
		}
		System.out.println(result);
	}

	static class Card {
		int front;
		int back;
		int value;

		public Card(int f, int c) {
			front = f;
			back = c;
			value = f;
		}

		public void change() {
			if (value == front)
				value = back;
			else
				value = front;
		}
	}
}
