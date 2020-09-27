package Inha;

public class HuffmanArr {
	static int[] heap = new int[100];
	static int[] info = new int[100];
	static int n;

	public static void main(String[] args) {
		String text = "aaabb";
		int[] count = new int[100];
		int[] dad = new int[100];
		int[] len = new int[27];
		int[] code = new int[27];
		int j, k, t, t1, t2, x;
		int cnt = 0;
		int M = text.length();
		n = 0;
		int i;
		for (i = 0; i < M; i++)
			count[index(text.charAt(i))]++;

		for (i = 0; i <= 26; i++)
			if (count[i] != 0)
				insert_pq(count[i], i);

		for (int ii : heap)
			System.out.print(ii + " ");
		System.out.println();

		for (; !isEmpty(); i++) {
			t1 = remove_pq();
			System.out.println(t1);
			t2 = remove_pq();
			System.out.println(t2);
			for (int ii : heap)
				System.out.print(ii + " ");
			System.out.println();
			dad[i] = 0;
			dad[t1] = i;
			dad[t2] = -i;
			count[i] = count[t1] + count[t2];
			if (!isEmpty())
				insert_pq(count[i], i);
		}

		for (k = 0; k <= 26; k++) {
			i = 0;
			x = 0;
			j = 1;
			if (count[k] != 0)
				for (t = dad[k]; t > 0; t = dad[t], j += j, i++)
					if (t < 0) {
						x += j;
						t = -t;
					}
			code[k] = x;
			len[k] = i;
		}
		for (int ii : len)
			System.out.print(ii + " ");
		System.out.println();
		for (int ii : code)
			System.out.print(ii + " ");

		// for (j = 0; j <= M; j++) {
		// for (i = len[index(text.charAt(j))]; i > 0; i--) {
		// System.out.println((code[index(text[j])] >> (i - 1)) &
		// 1(code[index(text.charAt(j))] >> (i - 1)) & 1);
		// cnt++;
		// if (cnt % 50 == 0)
		// printf("\n");
		// }
		// }
		// printf("\n");
		// return 0;

	}

	static void insert_pq(int v, int x) {
		int i;
		n++;
		for (i = n;;) {
			if (i == 1)
				break;
			if (v >= heap[i / 2])
				break;
			heap[i] = heap[i / 2];
			info[i] = info[i / 2];
			i /= 2;
		}
		heap[i] = v;
		info[i] = x;
	}

	static int remove_pq() {
		int i, j, x, temp_v, temp_x;
		x = info[1];
		temp_v = heap[n];
		temp_x = info[n];
		n--;
		i = 1;
		j = 2;
		while (j <= n) {
			if (j < n && heap[j] > heap[j + 1])
				j++;
			if (temp_v <= heap[j])
				break;
			heap[i] = heap[j];
			info[i] = info[j];
			i = j;
			j *= 2;
		}
		heap[i] = temp_v;
		info[i] = temp_x;
		return x;
	}

	static boolean isEmpty() {
		if (n == 0)
			return true;
		else
			return false;
	}

	static int index(char c) {
		if (c == 32)
			return 0;
		else
			return (c - 96);
	}
}
