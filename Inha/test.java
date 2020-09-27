package Inha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Inha.GA_NQ2.Chromosome;

public class test {
	static int POP_SIZE = 30; // ��ü��
	static int CHROMO_LENGTH = 8; // ����ü�� ����(=���� ����)
	static double CROSSOVER_RATE_RATE = 90; // ������
	static double MUTATION_RATE = 0.1; // �������� Ȯ��
	static int GENERATION_NUMBER = 5000; // ���� ��(���ݺ�Ƚ��)
	static int MAX_WIEGHT = 100; // �賶�� ���� �� �ִ� �ִ� ����
	static int[][] board;
	static double[] fitness_save;
	static int[] POP_CONFLICT;
	static int best_fit = 0, worst_fit = 0; // ����ü�� ���� ���� �������� ���� ���� ������
	static double sumvalue = 0; // �� ����ü �������� ��
	static Random rand = new Random();// 100 �Ʒ��� �����Ǽ��� �����ϴ� rand
	static int parent1, parent2;
	static int dx[] = new int[] { -1, 1, -1, 1 };
	static int dy[] = new int[] { -1, 1, 1, -1 };

	public static void main(String[] args) {
		board = new int[POP_SIZE][CHROMO_LENGTH + 1];
		fitness_save = new double[POP_SIZE];
		POP_CONFLICT = new int[POP_SIZE];
		int r, best = 0;

		encoding(); // CHROMO_LENGTH��ŭ�� ����ü ���� (�����ϰ� ���� �� ��ġ���� ����)
		for (int i = 0; i < POP_SIZE; i++) {
			computeConflicts(i);
		}
		Allfitness();

		for (int i = 0; i < GENERATION_NUMBER; i++) {
			for (best = 0; best < POP_SIZE; best++) {
				if (POP_CONFLICT[best] == 0) {
					System.out.println("����");
				}
			}
			System.out.println("���� ����� : " + (i + 1));
			System.out.print("�浹Ƚ�� : ");
			for (int f = 0; f < POP_SIZE; f++)
				System.out.print(POP_CONFLICT[f] + " ");
			System.out.println();
			scaling(); // ��ü�� �����ϱ� ���� �������� ���� �����ϸ� ����
			System.out.print("�����ϸ��� fitness : ");
			for (int f = 0; f < POP_SIZE; f++)
				System.out.print(fitness_save[f] + " ");
			System.out.println();
			parent1 = -1;
			parent1 = selection_roulette(); // �귿 �� ������� �θ� ����ü1 ����
			parent2 = parent1;
			while (parent1 == parent2) // point2�� point1�� �ٸ����� �����.
				parent2 = selection_roulette();
			worst_fit = worst_fitness(); // ���� ���뵵�� ����ü ����
			if ((double) rand.nextInt(10000) / 100 <= CROSSOVER_RATE_RATE) {
				worst_fit = crossover(parent1, parent2); // �� ���� �θ� ����ü�� ������ ��
			}
			if ((double) rand.nextInt(10000) / 100 <= MUTATION_RATE) {
				mutation(worst_fit); // ����ü�� ����
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

	static void encoding()// ������ ���� �� �� �ִ� �ĺ���(����ü)�� ����
	{
		// �������� ǥ���� binary encoding����� ����Ͽ���.(0�� 1�� ���)
		// 0�� �ش� �������� ���� ���� ���� �ǹ�
		// 1�� �ش� �������� �� ���� �ǹ�
		Random rand = new Random();
		for (int i = 0; i < POP_SIZE; i++) {// �տ��� ������ POP_SIZE ������ŭ ����ü ����
			for (int j = 1; j <= CHROMO_LENGTH; j++)// ����ü�� ���̴� �տ��� ������ CHROMO_LENGTH ���� ��ŭ
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
		// �� ���带 �����.
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			for (int j = 1; j <= CHROMO_LENGTH; j++) {
				toCompute[i][j] = "";
			}
		}
		// ���� ��ü�� ��� �������� ��ġ�ѵ�
		for (int i = 1; i <= CHROMO_LENGTH; i++) {
			toCompute[i][board[index][i]] = "Q";
		}

		for (int i = 1; i <= CHROMO_LENGTH; i++) {// row��ŭ ���� �ξ������� conflict�� ����Ѵ�.
			x = i;
			y = board[index][i];// row[i] �� col �� ���� �����Ƿ� x,y�� �����ѵ�

			for (int j = 0; j <= 3; j++) {// �밢�� 4�������� �����̸� �浹�ϴ� ���� ã�´�.
				tempx = x;
				tempy = y;
				done = false;
				while (!done) {
					tempx += dx[j];
					tempy += dy[j];
					if ((tempx < 1 || tempx > CHROMO_LENGTH) || (tempy < 1 || tempy > CHROMO_LENGTH)) {
						// ���� ����� ����� ���� �������� �����δ�.
						done = true;
					} else {
						// ���� ���� �ִٸ� �浹 Ƚ���� �÷��ش�.
						if (toCompute[tempx][tempy].compareToIgnoreCase("Q") == 0) {
							conflicts++;
						}
					}
				}
			}
		}
		// �ش� ��ä�� �浹Ƚ���� �����Ѵ�.
		POP_CONFLICT[index] = conflicts;
	}

	static void Allfitness()// �ش� ����ü(POP_SIZE �� i��°)�� �������� ���ϴ� �Լ�
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

	static void Setfitness(int index)// �ش� ����ü(POP_SIZE �� i��°)�� �������� ���ϴ� �Լ�
	{
		computeConflicts(index);
		double bestScore = 0;
		double worstScore = 0;
		worstScore = worst_Conflict();
		bestScore = best_Conflict();
		fitness_save[index] = ((worstScore - POP_CONFLICT[index]) * 100.0 / bestScore);
	}

	static int selection_roulette() {
		// �귿 ����� ��� �귿�� ��ü ������ 100�̶�� �����ϰ� �� �ص��� �귿�� ������ ��ġ��Ų��.
		// �̶� ��ġ��ų �� �ش� �ذ� �����ϴ� ������ ũ���(�ڽ��� ǰ���� N���� ���� �� X 100) % �̴�.
		// ���� ǰ���� �� ���� �ش� ���� Ȯ���� �� �������� ǰ���� ������ �ش� ���� Ȯ���� ��������.
		double randomNum = 0;
		double prob = 0;
		boolean toggle = true;
		for (int i = 0; i < POP_SIZE; i++) {
			sumvalue = sumvalue + fitness_save[i];
			// ��ü�� ������ ���� ��� ���Ͽ� �귿 ���� �����.
		}
		int i = 1;
		double sum = 0;
		while (toggle) {
			randomNum = rand.nextInt(100); // 0~99 ���� ������ ��
			for (i = 0; i < POP_SIZE; i++) {// ��� ����ü�� ���� �귿����
				if (parent1 != -1 && i == parent1)
					continue;

				// ���⼭ prob�� sumvalue���� �ڽ��� fitness_save��ŭ ������ ���´� �� fitness�� ũ�� ����Ȯ���� ũ��.
				prob = (double) ((double) fitness_save[i] / (double) sumvalue) * 100;
				randomNum = randomNum - prob;
				// prob�� randnum�� ���鼭 0�� �Ǹ� �ش� ����ü�� ������ �����.
				if (randomNum <= 0) {
					toggle = false;
					break;
				}
			}
		}
		return i;// ���õ� ����ü index ��ȯ
	}

	static int crossover(int parent1, int parent2) {
		int cut;
		// singlr point crossover�� ��𼭺��� ���� ��ȯ���� ���Ѵ�.
		cut = rand.nextInt(100) % (CHROMO_LENGTH - 1) + 1;
		// ���� cut���� ������ �ݺ��ϸ� parent1�� parnet2�� �����ڸ� ��ȯ�Ͽ� ���ο� ����ü�� ������.
		for (int k = cut; k < CHROMO_LENGTH; k++) {
			int temp = board[parent1][k];
			board[parent1][k] = board[parent2][k];
			board[parent2][k] = temp;
		}
		// fitness�� �ٽ� �����ش�.
		Setfitness(parent1);
		Setfitness(parent2);

		// ���̸� ���� ����ü �� �� �Ѱ��� �����ϰ� ��ȯ
		if (rand.nextInt(2) == 0)
			return parent1;
		else
			return parent2;

	}

	static void scaling() // rank scaling ��� ���
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

	// static void scaling() // sigma scaling ��� ���
	// {
	// double mean = (double) (sumvalue / POP_SIZE);// ���
	// double var = 0.0; // �л�
	// double stdev = 0.0;// ǥ������
	//
	// // �л��� ����
	// for (int i = 0; i < POP_SIZE; i++) {
	// var = var + ((double) fitness_save[i] - mean) * ((double) fitness_save[i] -
	// mean);
	// }
	// var = var / (double) POP_SIZE;
	//
	// // ǥ�������� ����
	// stdev = Math.sqrt(var);
	//
	// for (int i = 0; i < POP_SIZE; i++) {
	// // �� ����ü�� �������� ���� sigma scaling����� ����Ͽ� ������ scaling
	// fitness_save[i] = (fitness_save[i] - mean) / (2 * stdev);
	// ///fitness_save[i] = Math.round(fitness_save[i] * 1000) / 1000.0; // �Ҽ���
	// 3��°�����ݿø�
	// System.out.println(fitness_save[i]);
	// }
	// }

	static void mutation(int i) {
		// point1 ���� point2�� �����ڸ� �ű� ������ ��ġ�� ���Ѵ�.
		int point1 = rand.nextInt(1000) % CHROMO_LENGTH;
		int point2 = point1;
		while (point1 == point2) // point2�� point1�� �ٸ����� �����.
			point2 = rand.nextInt(1000) % CHROMO_LENGTH;

		int[] temp = new int[CHROMO_LENGTH + 1];
		int save = board[i][point1];
		int index = 0;
		for (int j = 0; j < CHROMO_LENGTH; j++) {
			if (j == point2) { // point2�ڸ��϶� save�Ѱ��־��ֱ�
				temp[j] = save;
				continue;
			}
			if (index == point1)// point1�ڸ��϶� �ű���̴ϱ� �Ѿ��
				index++;
			temp[j] = board[i][index++];
		}
		board[i] = temp;
		Setfitness(i);// fitness �ٽ� ���
	}

	static int best_fitness() // �ִ� �������� ���ϴ� �Լ�
	{
		double max = fitness_save[0];
		int j = 0;
		for (int i = 0; i < CHROMO_LENGTH; i++)
			if (fitness_save[i] > max) {
				max = fitness_save[i];
				j = i;
			}
		return j; // �ִ� �������� ������ ����ü�� index ��ȯ
	}

	static int worst_fitness() // �ּ� �������� ���ϴ� �Լ�
	{
		double min = fitness_save[0];
		int j = 0;
		for (int i = 0; i < CHROMO_LENGTH; i++)
			if (fitness_save[i] < min) {
				min = fitness_save[i];
				j = i;
			}
		return j; // �ּ� �������� ������ ����ü�� index ��ȯ
	}

	static int worst_Conflict() // �ִ� �������� ���ϴ� �Լ�
	{
		int max = POP_CONFLICT[0];
		int j = 0;
		for (int i = 0; i < POP_SIZE; i++)
			if (POP_CONFLICT[i] > max) {
				max = POP_CONFLICT[i];
				j = i;
			}
		return max; // �ִ� �������� ������ ����ü�� index ��ȯ
	}

	static int best_Conflict() // �ּ� �������� ���ϴ� �Լ�
	{
		int min = POP_CONFLICT[0];
		int j = 0;
		for (int i = 0; i < POP_SIZE; i++)
			if (POP_CONFLICT[i] < min) {
				min = POP_CONFLICT[i];
				j = i;
			}
		return min; // �ּ� �������� ������ ����ü�� index ��ȯ
	}

}
