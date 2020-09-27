package Inha.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.sound.midi.Sequence;

public class KMP {

	public static void main(String[] args) throws IOException {
		String str = "AAAAA";
		int[] a = InitNext(str);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}

	static int[] InitNext(String p) {
		int i, j = 0, M = p.length();
		int[] next = new int[M];
		next[0] = -1;
		for (i = 1, j = 0; i < M; i++, j++) {
			//next[i] =j;
			next[i] = (p.charAt(i) == p.charAt(j)) ? next[j] : j;
			while ((j >= 0) && p.charAt(i) != p.charAt(j))
				j = next[j];
		}

		return next;

	}

	static int KMP(String p, String t) {// KMP
		int i, j, M = p.length(), N = t.length();
		int next[] = InitNext(p);
		for (i = 0, j = 0; j < M && i < N; i++, j++)
			while ((j >= 0) && (t.charAt(i) != p.charAt(j)))
				j = next[j];
		if (j == M)
			return i - M;
		else {
			return i;
		}
	}
}

class StringSeq implements Comparable<StringSeq> {
	String str;
	int seq;

	public StringSeq(String str, int seq) {
		this.seq = seq;
		this.str = str;
	}

	@Override
	public int compareTo(StringSeq arg0) {
		if (this.seq > arg0.seq)
			return 1;
		else if (this.seq < arg0.seq)
			return -1;
		else
			return 0;
	}
}