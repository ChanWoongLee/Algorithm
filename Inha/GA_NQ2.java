package Inha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GA_NQ2 {
	private static final int POP_SIZE = 30; // �ʱ� ��ü��
	private static final int GENERATION_EPOCHS = 50000; // �����
	private static final double CROSSOVER_RATE = 0.7; // ����Ȯ��
	private static final double MUTATION_RATE = 0.001; // ���� Ȯ��
	private static final int MIN_SELECT = 10; // �귿 �������� �ּ� Ƚ��
	private static final int MAX_SELECT = 50; // �귿 �������� �ִ� Ƚ��
	private static final int OFFSPRING_PER_GENERATION = 20; // �� ���뿡�� ������ ����Ƚ��
	private static final int MINIMUM_SHUFFLES = 8; // shuffle�� ������ �ּ� Ƚ��
	private static final int MAXIMUM_SHUFFLES = 20; // shuffle�� ������ �ִ�Ƚ��
	private static final int BOARD_LENGTH = ; // ü�������� ũ��
	static long startTime;
	static long finishTime;
	private static int epoch = 0; // ���� ����
	private static int childCount = 0; // ���İ���
	private static int nextMutation = 0; // ���� Ȯ��
	private static int mutations = 0; // ���� Ƚ��

	private static ArrayList<Chromosome> population = new ArrayList<Chromosome>(); // ����ü ����

	public static void main(String[] args) {
		System.out.println("12151611 ������ ���� ������Ʈ -GA-");
		int popSize = 0;
		Chromosome thisChromo = null;
		boolean done = false;
		startTime = System.currentTimeMillis(); // ���� �ý��� �ð��� �и������������ ��ȯ
		initializeChromosomes(); // POP_SIZE��ŭ�� ����ü �ʱ⼳��
		mutations = 0;
		// ���� Ȯ���� ���� ���� �������� ����
		nextMutation = getRandomNumber(0, (int) Math.round(1.0 / MUTATION_RATE));
		while (!done) {
			popSize = population.size();
			for (int i = 0; i < popSize; i++) {
				thisChromo = population.get(i);
				// ���� conflict�� 0�̿��� �ùٸ� �ظ� ã�ų� ������� ��á���� �����ش�.
				if ((thisChromo.conflicts() == 0) || epoch == GENERATION_EPOCHS) {
					done = true;
				}
			}
			if (done)// ã���� break;
				break;

			// �� conflict�� ���� fitnees�� ���Ѵ�.
			getFitness();
			// �����ϸ��� ������������ �����Ѵ�.
			scaling();
			// �귿 ���¼��� �̿��� ����ü�� �����Ѵ�.
			rouletteSelection();
			// ���踦�Ѵ�.
			Crossover();
			// �������븦 ���� ���ú����� false��
			prepareNextEpoch();

		}
		finishTime = System.currentTimeMillis();
		System.out.println("N = " + BOARD_LENGTH + " �϶� �ɸ��ð� : " + (finishTime - startTime) + "ms");
		if (epoch == GENERATION_EPOCHS)
			System.out.println("Not Find");
		else {
			// ����� ���� board ��
			String board[][] = new String[BOARD_LENGTH][BOARD_LENGTH];
			// ���� ũ�⸸ŭ board�� string ����
			for (int x = 0; x < BOARD_LENGTH; x++) {
				for (int y = 0; y < BOARD_LENGTH; y++) {
					board[x][y] = "";
				}
			}
			// thisChromo�� row�� ���� ���� Q�� �����Ѵ�.
			for (int x = 0; x < BOARD_LENGTH; x++) {
				board[x][thisChromo.data(x)] = "Q";
			}
			// ã������� ���
			System.out.println("Board:");
			for (int y = 0; y < BOARD_LENGTH; y++) {
				for (int x = 0; x < BOARD_LENGTH; x++) {
					if (board[x][y] == "Q") {
						System.out.print("Q ");
					} else {
						System.out.print(". ");
					}
				}
				System.out.print("\n");
			}
		}
		System.out.println("������ ���� : " + epoch );
		System.out.println("�ڽļ� : " + childCount );
		return;
	}

	private static void getFitness() {
		int popSize = population.size();
		Chromosome thisChromo = null;
		double bestScore = 0;
		double worstScore = 0;
		// �浹Ƚ���� ���� ���� ������ worstscore �̰�
		worstScore = population.get(maximum()).conflicts();
		// �浹Ƚ���� ���� ���� ������ bestscore�̴�
		bestScore = worstScore - population.get(minimum()).conflicts();

		for (int i = 0; i < popSize; i++) {
			// ������ ������ �� ������ bestscore ��� �ۼ�Ʈ�� ���Ѵ�.
			thisChromo = population.get(i);
			thisChromo.fitness((worstScore - thisChromo.conflicts()) * 100.0 / bestScore);
		}

		return;
	}

	// �귿 ������
	private static void rouletteSelection() {
		int j = 0;
		int popSize = population.size();
		double genTotal = 0.0;
		double selTotal = 0.0;
		// ��� �������� ���� MIN_SELECT ~ MAX_SELECT���� ������ ���ڸ� �����Ѵ�.
		int maximumToSelect = getRandomNumber(MIN_SELECT, MAX_SELECT);
		double rouletteSpin = 0.0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		boolean done = false;

		// total �������� ����Ѵ�.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			genTotal += thisChromo.fitness();
		}
		// %�� ���� 0.01�� �����ش�.
		genTotal *= 0.01;

		// �� ����ü�� ����Ȯ���� �������ش�.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			thisChromo.selectionProbability(thisChromo.fitness() / genTotal);
		}
		// ������ ���� ����ŭ ����ü�� �����Ѵ�.
		for (int i = 0; i < maximumToSelect; i++) {
			// �귿 �������̹Ƿ� 0~99 ���� ������ ���ڸ� ����
			rouletteSpin = getRandomNumber(0, 99);
			j = 0;
			selTotal = 0;
			done = false;
			// ������ ���� �����̴�.
			while (!done) {
				// j ��° ����ü�� Ȯ���� ����ؼ� ���Ѵ�.
				thisChromo = population.get(j);
				selTotal += thisChromo.selectionProbability();
				// ���� ��Ȯ���� ������ ���� �귿���ɺ��� Ŀ������ �� ����ü�� ���õǴ°��̴�.
				if (selTotal >= rouletteSpin) {
					if (j == 0) {// ó�� ����ü�� ����
						thatChromo = population.get(j);
					} else if (j >= popSize - 1) {// POP size���� ��Ŀ���� ������ ����ü�� ����
						thatChromo = population.get(popSize - 1);
					} else {// �ش翰��ü�� ���õǴºκ�
						thatChromo = population.get(j - 1);
					}
					// select������ ������ �ٲ��� �����ش�.
					thatChromo.selected(true);
					done = true;
				} else {
					j++;
				}
			}
		}
		return;
	}

	static void scaling() // rank scaling ��� ���
	{
		// fitness�� �������� �������� �������ѵ�
		Collections.sort(population);
		// ������ �°� fitness�� �ٽ� �������ش�.
		for (int i = 0; i < POP_SIZE; i++) {
			population.get(i).fitness(i);
		}
	}

	private static void Crossover() {
		int getRand = 0;
		int parentA = 0;
		int parentB = 0;
		int newIndex1 = 0;
		int newIndex2 = 0;
		Chromosome newChromo1 = null;
		Chromosome newChromo2 = null;
		// �� ���뿡 ������ ���Ѹ�ŭ ����
		for (int i = 0; i < OFFSPRING_PER_GENERATION; i++) {
			parentA = chooseParent();
			// ���踦 ���� ������ Ȯ������ �����Ѵ�.
			getRand = getRandomNumber(0, 100);
			// ������ Ȯ���� üũ
			if (getRand <= CROSSOVER_RATE * 100) {
				parentB = chooseAnotherParent(parentA);
				newChromo1 = new Chromosome();
				newChromo2 = new Chromosome();
				// �ڽ� ����ü�� �ϴ� �־��ش�.
				population.add(newChromo1);
				newIndex1 = population.indexOf(newChromo1);
				population.add(newChromo2);
				newIndex2 = population.indexOf(newChromo2);

				// �ڽĿ���ü���� �θ𿰻�ü���� PMX����� ���� ���踦 �Ѵ�.
				partiallyMappedCrossover(parentA, parentB, newIndex1, newIndex2);

				// ó�� �����ϰ� ������ ���� Ȯ���������� ���Ǹ� �߻���Ų��.
				if (childCount - 1 == nextMutation) {
					exchangeMutation(newIndex1, 1);
				} else if (childCount == nextMutation) {
					exchangeMutation(newIndex2, 1);
				}
				// �浹Ƚ���� �߰���Ű��
				population.get(newIndex1).computeConflicts();
				population.get(newIndex2).computeConflicts();
				// child ���� �÷��ش�.
				childCount += 2;

				// ���� ����Ȯ���� ���� child���� �°� ������ش�.
				if (childCount % (int) Math.round(1.0 / MUTATION_RATE) == 0) {
					nextMutation = childCount + getRandomNumber(0, (int) Math.round(1.0 / MUTATION_RATE));
				}
			}
		}
		return;
	}

	private static void partiallyMappedCrossover(int chromA, int chromB, int child1, int child2) {
		int j = 0;
		int item1 = 0;
		int item2 = 0;
		int pos1 = 0;
		int pos2 = 0;
		// �� ��ü�� ������ ���� �ε����� ����
		Chromosome thisChromo = population.get(chromA);
		Chromosome thatChromo = population.get(chromB);
		Chromosome newChromo1 = population.get(child1);
		Chromosome newChromo2 = population.get(child2);
		// �� ũ�ν� �����͸� �������ش�.
		int crossPoint1 = getRandomNumber(0, BOARD_LENGTH - 1);
		int crossPoint2 = getExclusiveRandomNumber(BOARD_LENGTH - 1, crossPoint1);
		// ū���� ���������� ������ ����
		if (crossPoint2 < crossPoint1) {
			j = crossPoint1;
			crossPoint1 = crossPoint2;
			crossPoint2 = j;
		}
		// �ϴ��� ���ο� ����ü�� �θ𿰻�ü�� ����
		for (int i = 0; i < BOARD_LENGTH; i++) {
			newChromo1.data(i, thisChromo.data(i));
			newChromo2.data(i, thatChromo.data(i));
		}

		// point1 ~ point2 ���� �����Ѵ�.
		for (int i = crossPoint1; i <= crossPoint2; i++) {
			item1 = thisChromo.data(i);
			item2 = thatChromo.data(i);

			// 0���� ������ ã���鼭
			for (j = 0; j < BOARD_LENGTH; j++) {
				// ����Ʈ ���� ���� ã�´�.
				if (newChromo1.data(j) == item1) {
					pos1 = j;
				} else if (newChromo1.data(j) == item2) {
					pos2 = j;
				}
			}
			// ������ ã�� ����Ʈ ���� �ε����� �ٸ� ��� ���� �ٲ��ش�.
			if (item1 != item2) {
				newChromo1.data(pos1, item2);
				newChromo1.data(pos2, item1);
			}

			// ���� �Ȱ��� ������ ���ο� ����ü 2�� �����Ѵ�.
			for (j = 0; j < BOARD_LENGTH; j++) {
				if (newChromo2.data(j) == item2) {
					pos1 = j;
				} else if (newChromo2.data(j) == item1) {
					pos2 = j;
				}
			}
			if (item1 != item2) {
				newChromo2.data(pos1, item1);
				newChromo2.data(pos2, item2);
			}

		}
		return;
	}

	// �ٲܿ���ü�� exchange�� Ƚ���� �Ű������� �Ѿ�´�.
	private static void exchangeMutation(final int index, final int exchanges) {
		int i = 0;
		int tempData = 0;
		Chromosome thisChromo = null;
		int point1 = 0;
		int point2 = 0;
		boolean done = false;

		thisChromo = population.get(index);

		while (!done) {
			// 0 ���� Board_Length-1 ������ ������ ���� �� ����Ʈ��
			point1 = getRandomNumber(0, BOARD_LENGTH - 1);
			// 0 ���� Board_Length-1 ������ ������ ���߿� point1�� ������ ����Ʈ��
			point2 = getExclusiveRandomNumber(BOARD_LENGTH - 1, point1);

			// ������ �����ϰ� ���� �� ����Ʈ ���� �ٲ��ش�.
			tempData = thisChromo.data(point1);
			thisChromo.data(point1, thisChromo.data(point2));
			thisChromo.data(point2, tempData);

			// �������� ������ Ƚ����ŭ ������ �ٲٸ� �����ش�.
			if (i == exchanges) {
				done = true;
			}
			i++;
		}
		// �� ���� Ƚ���� �÷��ش�.
		mutations++;
		return;
	}

	// �귿���� ���õ� ����ü�߿��� �����ϰ� ����ü�� �������� �Լ�
	private static int chooseParent() {
		int parent = 0;
		Chromosome thisChromo = null;
		boolean done = false;

		while (!done) {
			// ���� ����ü�� �����ϰ� �����ؼ�
			parent = getRandomNumber(0, population.size() - 1);
			thisChromo = population.get(parent);
			// �귿�� ���ô��� ����ü��� ���߰� ��ȯ�Ѵ�.
			if (thisChromo.selected() == true) {
				done = true;
			}
		}

		return parent;
	}

	// �귿���� ���õ� ����ü�� �Ǵٸ� ����ü�� �����ϱ����� �Լ�
	private static int chooseAnotherParent(final int parentA) {
		int parent = 0;
		Chromosome thisChromo = null;
		boolean done = false;

		while (!done) {
			// ���� ����ü�߿��� �����ϰ� �����Ѵ�
			parent = getRandomNumber(0, population.size() - 1);
			// ���� ���� ������ ����ü�� �ٸ��� �귿���� ���õ� ����ü ��� wihile�� ���߰� ��ȯ�Ѵ�.
			if (parent != parentA) {
				thisChromo = population.get(parent);
				if (thisChromo.selected() == true) {
					done = true;
				}
			}
		}

		return parent;
	}

	// ������ ��� �����ϱ������Լ�
	private static void prepareNextEpoch() {
		int popSize = 0;
		Chromosome thisChromo = null;
		popSize = population.size();
		// popsize��ŭ ��� select������ false�� �ʱ�ȭ��Ų��.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			thisChromo.selected(false);
		}
		return;
	}

	// low���� hihg������ ������ ���� ����Ѵ�.
	private static int getRandomNumber(final int low, final int high) {
		return (int) Math.round((high - low) * new Random().nextDouble() + low);
	}

	// high �����߿� except�� ������ �����ϴ��� ����Ѵ�.
	private static int getExclusiveRandomNumber(final int high, final int except) {
		boolean done = false;
		int getRand = 0;

		while (!done) {
			getRand = new Random().nextInt(high);
			// ������ ���� �����Ѽ��� except�� �ٸ� ��� ����Ѵ�.
			if (getRand != except) {
				done = true;
			}
		}

		return getRand;
	}

	// low���� high�����߿� except�� ������ ������ ������ ����
	private static int getRandomNumber(int low, int high, int[] except) {
		boolean done = false;
		int getRand = 0;
		// high�� low�� �ٸ���
		if (high != low) {
			while (!done) {
				done = true;
				// �� ���̰��� �����ѵ�
				getRand = (int) Math.round((high - low) * new Random().nextDouble() + low);
				// except�� �ִ��� Ȯ��
				for (int i = 0; i < except.length; i++) {
					// ������ ��ӽ��ؾ��ش�.
					if (getRand == except[i]) {
						done = false;
					}
				}
			}
			// except�� ���� ���϶� ���
			return getRand;
		} else {
			return high;
		}
	}

	// conflit���� �������� ��ü�� �ε����� ��ȯ�Ѵ�.
	private static int minimum() {
		int popSize = 0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		int winner = 0;
		boolean foundNewWinner = false;
		boolean done = false;

		while (!done) {
			// ã���� Ȯ���ϴ� ����
			foundNewWinner = false;
			popSize = population.size();
			// POP_size��ŭ ���鼭 conflict���� ������ ã�´�.
			for (int i = 0; i < popSize; i++) {
				if (i != winner) {
					thisChromo = population.get(i);
					thatChromo = population.get(winner);
					// conflict���� ū ��ü�� ���������
					if (thisChromo.conflicts() < thatChromo.conflicts()) {
						// winner�� �ٲ��ְ� find�� true�� �������ش�.
						winner = i;
						foundNewWinner = true;
					}
				}
			}
			// ���� ó���� ���� Ŭ�ܿ�
			if (foundNewWinner == false) {
				done = true;
			}
		}
		return winner;
	}

	// conflit���� ���帹�� ��ü�� �ε����� ��ȯ�Ѵ�.
	private static int maximum() {
		int popSize = 0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		int winner = 0;
		boolean foundNewWinner = false;
		boolean done = false;

		while (!done) {
			// ã���� Ȯ���ϴ� ����
			foundNewWinner = false;
			popSize = population.size();
			// POP_size��ŭ ���鼭 conflict���� ������ ã�´�.
			for (int i = 0; i < popSize; i++) {
				if (i != winner) { // Avoid self-comparison.
					thisChromo = population.get(i);
					thatChromo = population.get(winner);
					// conflict���� ���� ��ü�� ���������
					if (thisChromo.conflicts() > thatChromo.conflicts()) {
						// winner�� �ٲ��ְ� find�� true�� �������ش�.
						winner = i;
						foundNewWinner = true;
					}
				}
			}
			// ���� ó���� ���� ���
			if (foundNewWinner == false) {
				done = true;
			}
		}
		return winner;
	}

	// �ʱ� ����ü�� �����ϴ´ܰ�
	private static void initializeChromosomes() {
		int shuffles = 0;
		Chromosome newChromo = null;
		int chromoIndex = 0;
		// popsize��ŭ ����ü�� �������ش�.
		for (int i = 0; i < POP_SIZE; i++) {
			newChromo = new Chromosome();
			// ����ü ���ܿ� ���� ����ü�� �־��ش�.
			population.add(newChromo);
			chromoIndex = population.indexOf(newChromo);
			// �� �����ڿ��� �ϴ� �࿡ �ߺ����� �ʴ� ���� ��ġ�����Ƿ�
			// ������ ����ü������ ����ü���� �����ش�.
			shuffles = getRandomNumber(MINIMUM_SHUFFLES, MAXIMUM_SHUFFLES);
			exchangeMutation(chromoIndex, shuffles);

			// ���� ����ü�� ���ؼ� �浹Ƚ��
			population.get(chromoIndex).computeConflicts();

		}
		return;
	}

	// ����ü Ŭ�����̴�. fitness������ �����ϱ����� comparealbe �������̽��� implemets
	public static class Chromosome implements Comparable<Chromosome> {
		// �� �࿡ � ���� ���� �ִ����� ���� �����̴�.
		private int row[] = new int[BOARD_LENGTH];
		// ������
		private double mFitness = 0.0;
		// ���õȰ��� �ƴ��������� ����
		private boolean mSelected = false;
		// ���õ�Ȯ��
		private double mSelectionProbability = 0.0;
		// �⵹Ƚ��
		private int mConflicts = 0;

		public Chromosome() {
			for (int i = 0; i < BOARD_LENGTH; i++) {
				this.row[i] = i;// �����ڷ� �ϴ� ���࿡ ���� �ε����� �־��ش�.
			}
			return;
		}

		public void computeConflicts() {
			int x = 0;
			int y = 0;
			int tempx = 0;
			int tempy = 0;
			String board[][] = new String[BOARD_LENGTH][BOARD_LENGTH];
			int conflicts = 0;
			// �밢�� �������� ������ �� �ִ� ar
			int dx[] = new int[] { -1, 1, -1, 1 };
			int dy[] = new int[] { -1, 1, 1, -1 };
			boolean done = false;
			// �� ���带 �����.
			for (int i = 0; i < BOARD_LENGTH; i++) {
				for (int j = 0; j < BOARD_LENGTH; j++) {
					board[i][j] = "";
				}
			}
			// ���� ��ü�� ��� �������� ��ġ�ѵ�
			for (int i = 0; i < BOARD_LENGTH; i++) {
				board[i][this.row[i]] = "Q";
			}

			for (int i = 0; i < BOARD_LENGTH; i++) {// row��ŭ ���� �ξ������� conflict�� ����Ѵ�.
				x = i;
				y = this.row[i];// row[i] �� col �� ���� �����Ƿ� x,y�� �����ѵ�

				for (int j = 0; j <= 3; j++) {// �밢�� 4�������� �����̸� �浹�ϴ� ���� ã�´�.
					tempx = x;
					tempy = y;
					// ������ ���� ��ġ���� ����������.
					done = false;
					while (!done) {
						tempx += dx[j];
						tempy += dy[j];
						if ((tempx < 0 || tempx >= BOARD_LENGTH) || (tempy < 0 || tempy >= BOARD_LENGTH)) {
							// ���� ����� ����� ���� �������� �����δ�.
							done = true;
						} else {
							// ���� ���� �ִٸ� �浹 Ƚ���� �÷��ش�.
							if (board[tempx][tempy].compareToIgnoreCase("Q") == 0) {
								conflicts++;
							}
						}
					}
				}
			}
			// �ش� ��ä�� �浹Ƚ���� �����Ѵ�.
			this.mConflicts = conflicts;
		}

		// conflit�����Լ�
		public void conflicts(int value) {
			this.mConflicts = value;
			return;
		}

		// conflict ��ȯ�Լ�
		public int conflicts() {
			return this.mConflicts;
		}

		// ����Ȯ����ȯ�Լ�
		public double selectionProbability() {
			return mSelectionProbability;
		}

		// ����Ȯ�� �����Լ�
		public void selectionProbability(final double SelProb) {
			mSelectionProbability = SelProb;
			return;
		}

		// ���� �Ǿ����� ��ȯ
		public boolean selected() {
			return mSelected;
		}

		// ���� ���� �����Լ�
		public void selected(final boolean sValue) {
			mSelected = sValue;
			return;
		}

		// ������ ����Լ�
		public double fitness() {
			return mFitness;
		}

		// ������ �����Լ�
		public void fitness(final double score) {
			mFitness = score;
			return;
		}

		// ���� ���� ��ġ ��� ���
		public int data(final int index) {
			return row[index];
		}

		// ���� ���� ��ġ ����� index ���� value�� �ٲٴ��Լ�
		public void data(final int index, final int value) {
			row[index] = value;
			return;
		}

		// fitness�� �迭������� compare�Լ�
		@Override
		public int compareTo(Chromosome o) {
			return Double.compare(this.mFitness, o.mFitness);
		}
	}

}