package Inha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Inha.GA_NQ2.Chromosome;

public class test {
	static int POP_SIZE = 30; // 개체수
	static int CHROMO_LENGTH = 8; // 염색체의 길이(=물건 갯수)
	static double CROSSOVER_RATE_RATE = 90; // 교차율
	static double MUTATION_RATE = 0.1; // 돌연변이 확률
	static int GENERATION_NUMBER = 5000; // 세대 수(계산반복횟수)
	static int MAX_WIEGHT = 100; // 배낭에 담을 수 있는 최대 무게
	static int[][] board;
	static double[] fitness_save;
	static int[] POP_CONFLICT;
	static int best_fit = 0, worst_fit = 0; // 염색체의 가장 나쁜 적응도와 가장 좋은 적응도
	static double sumvalue = 0; // 총 염색체 적응도의 합
	static Random rand = new Random();// 100 아래의 임의의수를 생성하는 rand
	static int parent1, parent2;
	static int dx[] = new int[] { -1, 1, -1, 1 };
	static int dy[] = new int[] { -1, 1, 1, -1 };

	public static void main(String[] args) {
		board = new int[POP_SIZE][CHROMO_LENGTH + 1];
		fitness_save = new double[POP_SIZE];
		POP_CONFLICT = new int[POP_SIZE];
		int r, best = 0;

		encoding(); // CHROMO_LENGTH만큼의 염색체 생성 (랜덤하게 만든 퀸 배치도의 개수)
		for (int i = 0; i < POP_SIZE; i++) {
			computeConflicts(i);
		}
		Allfitness();

		for (int i = 0; i < GENERATION_NUMBER; i++) {
			for (best = 0; best < POP_SIZE; best++) {
				if (POP_CONFLICT[best] == 0) {
					System.out.println("종료");
				}
			}
			System.out.println("현재 세대수 : " + (i + 1));
			System.out.print("충돌횟수 : ");
			for (int f = 0; f < POP_SIZE; f++)
				System.out.print(POP_CONFLICT[f] + " ");
			System.out.println();
			scaling(); // 개체를 선택하기 전에 적응도에 대해 스케일링 진행
			System.out.print("스케일링후 fitness : ");
			for (int f = 0; f < POP_SIZE; f++)
				System.out.print(fitness_save[f] + " ");
			System.out.println();
			parent1 = -1;
			parent1 = selection_roulette(); // 룰렛 휠 방식으로 부모 염색체1 선택
			parent2 = parent1;
			while (parent1 == parent2) // point2는 point1과 다르도록 만든다.
				parent2 = selection_roulette();
			worst_fit = worst_fitness(); // 나쁜 적용도의 염색체 선택
			if ((double) rand.nextInt(10000) / 100 <= CROSSOVER_RATE_RATE) {
				worst_fit = crossover(parent1, parent2); // 두 개의 부모 염색체를 교차한 후
			}
			if ((double) rand.nextInt(10000) / 100 <= MUTATION_RATE) {
				mutation(worst_fit); // 염색체를 변이
				System.out.println("4");
			}
		}
		best_fit = best_Conflict();
		String[][] show = new String[CHROMO_LENGTH + 1][CHROMO_LENGTH + 1];
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			for (int j = 1; j <= CHROMO_LENGTH; j++) {
				show[i][j] = ".";
			}
		}
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			show[i][board[best_fit][i]] = "Q";
		}
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			for (int j = 1; j <= CHROMO_LENGTH; j++) {
				System.out.print(show[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void encoding()// 문제의 답이 될 수 있는 후보들(염색체)을 생성
	{
		// 유전자의 표현은 binary encoding기법을 사용하였다.(0과 1을 사용)
		// 0은 해당 아이템이 들어가지 않은 것을 의미
		// 1은 해당 아이템이 들어간 것을 의미
		Random rand = new Random();
		for (int i = 0; i < POP_SIZE; i++) {// 앞에서 정의한 POP_SIZE 갯수만큼 염색체 생성
			for (int j = 1; j <= CHROMO_LENGTH; j++)// 염색체의 길이는 앞에서 정의한 CHROMO_LENGTH 길이 만큼
			{
				board[i][j] = rand.nextInt(CHROMO_LENGTH) + 1;
			}
		}

	}

	static public void computeConflicts(int index) {
		int x = 0;
		int y = 0;
		int tempx = 0;
		int tempy = 0;
		String toCompute[][] = new String[CHROMO_LENGTH + 1][CHROMO_LENGTH + 1];
		int conflicts = 0;

		boolean done = false;
		// 빈 보드를 만든다.
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			for (int j = 1; j <= CHROMO_LENGTH; j++) {
				toCompute[i][j] = "";
			}
		}
		// 현재 개체에 담긴 퀸정보를 배치한뒤
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			toCompute[i][board[index][i]] = "Q";
		}

		for (int i = 1; i <= CHROMO_LENGTH; i++) {// row만큼 퀸을 두었을때의 conflict를 계산한다.
			x = i;
			y = board[index][i];// row[i] 는 col 의 값이 있으므로 x,y를 설정한뒤

			for (int j = 0; j <= 3; j++) {// 대각선 4방향으로 움직이며 충돌하는 퀸을 찾는다.
				tempx = x;
				tempy = y;
				done = false;
				while (!done) {
					tempx += dx[j];
					tempy += dy[j];
					if ((tempx < 1 || tempx > CHROMO_LENGTH) || (tempy < 1 || tempy > CHROMO_LENGTH)) {
						// 만약 사이즈를 벗어나면 다음 방향으로 움직인다.
						done = true;
					} else {
						// 만약 퀸이 있다면 충돌 횟수를 올려준다.
						if (toCompute[tempx][tempy].compareToIgnoreCase("Q") == 0) {
							conflicts++;
						}
					}
				}
			}
		}
		// 해당 개채의 충돌횟수를 지정한다.
		POP_CONFLICT[index] = conflicts;
	}

	static void Allfitness()// 해당 염색체(POP_SIZE 중 i번째)의 적응도를 구하는 함수
	{
		double bestScore = 0;
		double worstScore = 0;
		worstScore = worst_Conflict();
		bestScore = best_Conflict();

		for (int i = 0; i < POP_SIZE; i++) {
			fitness_save[i] = ((worstScore - POP_CONFLICT[i]) * 100.0 / bestScore);
		}

		return;
	}

	static void Setfitness(int index)// 해당 염색체(POP_SIZE 중 i번째)의 적응도를 구하는 함수
	{
		computeConflicts(index);
		double bestScore = 0;
		double worstScore = 0;
		worstScore = worst_Conflict();
		bestScore = best_Conflict();
		fitness_save[index] = ((worstScore - POP_CONFLICT[index]) * 100.0 / bestScore);
	}

	static int selection_roulette() {
		// 룰렛 방식의 경우 룰렛의 전체 구간을 100이라고 가정하고 각 해들을 룰렛의 구간에 배치시킨다.
		// 이때 배치시킬 때 해당 해가 차지하는 구간의 크기는(자신의 품질을 N으로 나눈 값 X 100) % 이다.
		// 따라서 품질이 더 좋은 해는 뽑힐 확률이 더 높아지고 품질이 안좋은 해는 뽑힐 확률이 낮아진다.
		double randomNum = 0;
		double prob = 0;
		boolean toggle = true;
		for (int i = 0; i < POP_SIZE; i++) {
			sumvalue = sumvalue + fitness_save[i];
			// 개체의 적응도 값을 모두 더하여 룰렛 휠을 만든다.
		}
		int i = 1;
		double sum = 0;
		while (toggle) {
			randomNum = rand.nextInt(100); // 0~99 까지 랜덤한 수
			for (i = 0; i < POP_SIZE; i++) {// 모든 염색체에 대해 룰렛적용
				if (parent1 != -1 && i == parent1)
					continue;

				// 여기서 prob는 sumvalue에서 자신의 fitness_save만큼 지분을 갖는다 즉 fitness가 크면 뽑힐확률이 크다.
				prob = (double) ((double) fitness_save[i] / (double) sumvalue) * 100;
				randomNum = randomNum - prob;
				// prob를 randnum을 빼면서 0이 되면 해당 염색체를 선택후 멈춘다.
				if (randomNum <= 0) {
					toggle = false;
					break;
				}
			}
		}
		return i;// 선택된 염색체 index 반환
	}

	static int crossover(int parent1, int parent2) {
		int cut;
		// singlr point crossover로 어디서부터 값을 교환할지 정한다.
		cut = rand.nextInt(100) % (CHROMO_LENGTH - 1) + 1;
		// 변수 cut부터 끝까지 반복하며 parent1과 parnet2의 유전자를 교환하여 새로운 염색체를 만들음.
		for (int k = cut; k < CHROMO_LENGTH; k++) {
			int temp = board[parent1][k];
			board[parent1][k] = board[parent2][k];
			board[parent2][k] = temp;
		}
		// fitness를 다시 구해준다.
		Setfitness(parent1);
		Setfitness(parent2);

		// 변이를 위해 염색체 둘 중 한개를 랜덤하게 반환
		if (rand.nextInt(2) == 0)
			return parent1;
		else
			return parent2;

	}

	static void scaling() // rank scaling 기법 사용
	{
		double[] rank = new double[POP_SIZE];
		for (int i = 0; i < POP_SIZE; i++)
			rank[i] = fitness_save[i];
		Arrays.sort(rank);
		boolean[] rankCheck = new boolean[POP_SIZE];

		for (int i = 0; i < POP_SIZE; i++) {
			double target = fitness_save[i];
			for (int j = 0; j < POP_SIZE; j++) {
				if (rankCheck[j] == false && target == rank[j]) {
					rankCheck[j] = true;
					fitness_save[i] = j;
					break;
				}
			}
		}
	}

	// static void scaling() // sigma scaling 기법 사용
	// {
	// double mean = (double) (sumvalue / POP_SIZE);// 평균
	// double var = 0.0; // 분산
	// double stdev = 0.0;// 표준편차
	//
	// // 분산을 구함
	// for (int i = 0; i < POP_SIZE; i++) {
	// var = var + ((double) fitness_save[i] - mean) * ((double) fitness_save[i] -
	// mean);
	// }
	// var = var / (double) POP_SIZE;
	//
	// // 표준편차를 구함
	// stdev = Math.sqrt(var);
	//
	// for (int i = 0; i < POP_SIZE; i++) {
	// // 각 염색체의 적응도에 대해 sigma scaling기법을 사용하여 적응도 scaling
	// fitness_save[i] = (fitness_save[i] - mean) / (2 * stdev);
	// ///fitness_save[i] = Math.round(fitness_save[i] * 1000) / 1000.0; // 소수점
	// 3번째까지반올림
	// System.out.println(fitness_save[i]);
	// }
	// }

	static void mutation(int i) {
		// point1 에서 point2로 유전자를 옮길 랜덤한 위치를 정한다.
		int point1 = rand.nextInt(1000) % CHROMO_LENGTH;
		int point2 = point1;
		while (point1 == point2) // point2는 point1과 다르도록 만든다.
			point2 = rand.nextInt(1000) % CHROMO_LENGTH;

		int[] temp = new int[CHROMO_LENGTH + 1];
		int save = board[i][point1];
		int index = 0;
		for (int j = 0; j < CHROMO_LENGTH; j++) {
			if (j == point2) { // point2자리일때 save한값넣어주기
				temp[j] = save;
				continue;
			}
			if (index == point1)// point1자리일때 옮길수이니까 넘어가기
				index++;
			temp[j] = board[i][index++];
		}
		board[i] = temp;
		Setfitness(i);// fitness 다시 계산
	}

	static int best_fitness() // 최대 적응도를 구하는 함수
	{
		double max = fitness_save[0];
		int j = 0;
		for (int i = 0; i < CHROMO_LENGTH; i++)
			if (fitness_save[i] > max) {
				max = fitness_save[i];
				j = i;
			}
		return j; // 최대 적응도를 가지는 염색체의 index 반환
	}

	static int worst_fitness() // 최소 적응도를 구하는 함수
	{
		double min = fitness_save[0];
		int j = 0;
		for (int i = 0; i < CHROMO_LENGTH; i++)
			if (fitness_save[i] < min) {
				min = fitness_save[i];
				j = i;
			}
		return j; // 최소 적응도를 가지는 염색체의 index 반환
	}

	static int worst_Conflict() // 최대 적응도를 구하는 함수
	{
		int max = POP_CONFLICT[0];
		int j = 0;
		for (int i = 0; i < POP_SIZE; i++)
			if (POP_CONFLICT[i] > max) {
				max = POP_CONFLICT[i];
				j = i;
			}
		return max; // 최대 적응도를 가지는 염색체의 index 반환
	}

	static int best_Conflict() // 최소 적응도를 구하는 함수
	{
		int min = POP_CONFLICT[0];
		int j = 0;
		for (int i = 0; i < POP_SIZE; i++)
			if (POP_CONFLICT[i] < min) {
				min = POP_CONFLICT[i];
				j = i;
			}
		return min; // 최소 적응도를 가지는 염색체의 index 반환
	}

}
