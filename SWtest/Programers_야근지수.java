package SummerCoding;


public class Programers_야근지수 {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] { 1, 1 }));
	}
	// 왜 이렇게 한걸까 ......
	// 일단은 가장큰거에서 1씩 빼야하는 정답지도는 완성
	// 구현에서 ㅎㅌㅊ..
	// 정렬한뒤 큰거부터 1씩빼면 어떤걸 빼야할지 또 구현해야됨 ;;
	// 왜 어떤걸빼야하는걸 정하는데 무슨 우선순위가 있길래 그런고민하지 ??
	// 그냥 큰거 랜덤으로 뺴면 안될까 ?? 똑같은건데!!!!!!
	// 
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
