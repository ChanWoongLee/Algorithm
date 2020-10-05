package SummerCoding;


public class Programers_야근지수 {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] { 1, 1 }));
	}
	// 왜 이렇게 한걸까 ......
	// 일단은 가장큰거에서 1씩 빼야하는 정답지도는 완성
	// 구현에서 ㅎㅌㅊ..

	static public long solution(int n, int[] works) {
		long answer = 0;
		while (n != 0) {
			int max = 0;
			for (int i = 0; i < works.length; i++) {
				max = max < works[i] ? works[i] : max;
			}
			if (max == 0)
				return 0;
			for (int i = 0; i < works.length; i++) {
				if (max == works[i] && n>0) {
					works[i]--;
					n--;
				}
			}
		}
		for(int i = 0; i < works.length; i++)
			answer += works[i]*works[i];

		return answer;
	}
}
