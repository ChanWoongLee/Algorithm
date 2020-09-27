package Inha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GA_NQ2 {
	private static final int POP_SIZE = 30; // 초기 개체수
	private static final int GENERATION_EPOCHS = 50000; // 세대수
	private static final double CROSSOVER_RATE = 0.7; // 교배확률
	private static final double MUTATION_RATE = 0.001; // 변이 확률
	private static final int MIN_SELECT = 10; // 룰렛 셀렉션의 최소 횟수
	private static final int MAX_SELECT = 50; // 룰렛 셀렉션의 최대 횟수
	private static final int OFFSPRING_PER_GENERATION = 20; // 한 세대에서 진행할 교배횟수
	private static final int MINIMUM_SHUFFLES = 8; // shuffle을 진행할 최소 횟수
	private static final int MAXIMUM_SHUFFLES = 20; // shuffle을 진행할 최대횟수
	private static final int BOARD_LENGTH = ; // 체스보드의 크기
	static long startTime;
	static long finishTime;
	private static int epoch = 0; // 현재 세대
	private static int childCount = 0; // 차식개수
	private static int nextMutation = 0; // 변이 확률
	private static int mutations = 0; // 변이 횟수

	private static ArrayList<Chromosome> population = new ArrayList<Chromosome>(); // 염색체 집합

	public static void main(String[] args) {
		System.out.println("12151611 이찬웅 설계 프로젝트 -GA-");
		int popSize = 0;
		Chromosome thisChromo = null;
		boolean done = false;
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로 반환
		initializeChromosomes(); // POP_SIZE만큼의 염색체 초기설정
		mutations = 0;
		// 변이 확률에 대한 값을 랜덤으로 생성
		nextMutation = getRandomNumber(0, (int) Math.round(1.0 / MUTATION_RATE));
		while (!done) {
			popSize = population.size();
			for (int i = 0; i < popSize; i++) {
				thisChromo = population.get(i);
				// 만약 conflict가 0이여서 올바른 해를 찾거나 세대수가 다찼으면 멈춰준다.
				if ((thisChromo.conflicts() == 0) || epoch == GENERATION_EPOCHS) {
					done = true;
				}
			}
			if (done)// 찾으면 break;
				break;

			// 각 conflict에 대한 fitnees를 구한다.
			getFitness();
			// 스케일링을 통해적응도를 가공한다.
			scaling();
			// 룰렛 셀력션을 이용해 염색체를 선택한다.
			rouletteSelection();
			// 교배를한다.
			Crossover();
			// 다음새대를 위해 선택변수를 false로
			prepareNextEpoch();

		}
		finishTime = System.currentTimeMillis();
		System.out.println("N = " + BOARD_LENGTH + " 일때 걸린시간 : " + (finishTime - startTime) + "ms");
		if (epoch == GENERATION_EPOCHS)
			System.out.println("Not Find");
		else {
			// 출력을 위한 board 판
			String board[][] = new String[BOARD_LENGTH][BOARD_LENGTH];
			// 먼저 크기만큼 board를 string 선언
			for (int x = 0; x < BOARD_LENGTH; x++) {
				for (int y = 0; y < BOARD_LENGTH; y++) {
					board[x][y] = "";
				}
			}
			// thisChromo의 row의 값인 열에 Q를 대입한다.
			for (int x = 0; x < BOARD_LENGTH; x++) {
				board[x][thisChromo.data(x)] = "Q";
			}
			// 찾은결과를 출력
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
		System.out.println("진행한 세대 : " + epoch );
		System.out.println("자식수 : " + childCount );
		return;
	}

	private static void getFitness() {
		int popSize = population.size();
		Chromosome thisChromo = null;
		double bestScore = 0;
		double worstScore = 0;
		// 충돌횟수가 가장 많은 점수가 worstscore 이고
		worstScore = population.get(maximum()).conflicts();
		// 충돌횟수가 가장 적은 점수가 bestscore이다
		bestScore = worstScore - population.get(minimum()).conflicts();

		for (int i = 0; i < popSize; i++) {
			// 위에서 설정한 두 값으로 bestscore 대비 퍼센트를 구한다.
			thisChromo = population.get(i);
			thisChromo.fitness((worstScore - thisChromo.conflicts()) * 100.0 / bestScore);
		}

		return;
	}

	// 룰렛 셀렉션
	private static void rouletteSelection() {
		int j = 0;
		int popSize = population.size();
		double genTotal = 0.0;
		double selTotal = 0.0;
		// 몇번 셀렉션을 할지 MIN_SELECT ~ MAX_SELECT에서 랜덤한 숫자를 생성한다.
		int maximumToSelect = getRandomNumber(MIN_SELECT, MAX_SELECT);
		double rouletteSpin = 0.0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		boolean done = false;

		// total 적응도를 계산한다.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			genTotal += thisChromo.fitness();
		}
		// %를 위해 0.01을 곱해준다.
		genTotal *= 0.01;

		// 각 염색체의 선택확률을 정의해준다.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			thisChromo.selectionProbability(thisChromo.fitness() / genTotal);
		}
		// 위에서 정한 수만큼 염색체를 선택한다.
		for (int i = 0; i < maximumToSelect; i++) {
			// 룰렛 셀렉션이므로 0~99 에서 랜덤한 숫자를 생성
			rouletteSpin = getRandomNumber(0, 99);
			j = 0;
			selTotal = 0;
			done = false;
			// 선택을 위한 구현이다.
			while (!done) {
				// j 번째 염색체의 확률을 계속해서 더한다.
				thisChromo = population.get(j);
				selTotal += thisChromo.selectionProbability();
				// 만약 그확률이 위에서 정한 룰렛스핀보다 커졌을때 그 염색체가 선택되는것이다.
				if (selTotal >= rouletteSpin) {
					if (j == 0) {// 처음 염색체가 선택
						thatChromo = population.get(j);
					} else if (j >= popSize - 1) {// POP size보다 더커질때 마지막 염색체가 선택
						thatChromo = population.get(popSize - 1);
					} else {// 해당염색체가 선택되는부분
						thatChromo = population.get(j - 1);
					}
					// select변수를 참으로 바꾼후 멈춰준다.
					thatChromo.selected(true);
					done = true;
				} else {
					j++;
				}
			}
		}
		return;
	}

	static void scaling() // rank scaling 기법 사용
	{
		// fitness를 기준으로 오름차순 정렬을한뒤
		Collections.sort(population);
		// 순서에 맞게 fitness를 다시 정의해준다.
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
		// 한 새대에 위에서 정한만큼 교배
		for (int i = 0; i < OFFSPRING_PER_GENERATION; i++) {
			parentA = chooseParent();
			// 교배를 위한 랜덤한 확률값을 생성한다.
			getRand = getRandomNumber(0, 100);
			// 교배할 확률을 체크
			if (getRand <= CROSSOVER_RATE * 100) {
				parentB = chooseAnotherParent(parentA);
				newChromo1 = new Chromosome();
				newChromo2 = new Chromosome();
				// 자식 염색체를 일단 넣어준다.
				population.add(newChromo1);
				newIndex1 = population.indexOf(newChromo1);
				population.add(newChromo2);
				newIndex2 = population.indexOf(newChromo2);

				// 자식염색체에게 부모염색체에서 PMX기법을 통해 교배를 한다.
				partiallyMappedCrossover(parentA, parentB, newIndex1, newIndex2);

				// 처음 랜덤하게 생성한 변이 확률값에의해 변의를 발생시킨다.
				if (childCount - 1 == nextMutation) {
					exchangeMutation(newIndex1, 1);
				} else if (childCount == nextMutation) {
					exchangeMutation(newIndex2, 1);
				}
				// 충돌횟수를 추가시키고
				population.get(newIndex1).computeConflicts();
				population.get(newIndex2).computeConflicts();
				// child 수를 올려준다.
				childCount += 2;

				// 다음 변이확률을 현재 child수에 맞게 계산해준다.
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
		// 각 객체에 위에서 받은 인덱스로 지정
		Chromosome thisChromo = population.get(chromA);
		Chromosome thatChromo = population.get(chromB);
		Chromosome newChromo1 = population.get(child1);
		Chromosome newChromo2 = population.get(child2);
		// 두 크로스 포인터를 지정해준다.
		int crossPoint1 = getRandomNumber(0, BOARD_LENGTH - 1);
		int crossPoint2 = getExclusiveRandomNumber(BOARD_LENGTH - 1, crossPoint1);
		// 큰값과 작은값으로 나누는 과정
		if (crossPoint2 < crossPoint1) {
			j = crossPoint1;
			crossPoint1 = crossPoint2;
			crossPoint2 = j;
		}
		// 일단은 새로운 염색체에 부모염색체를 복사
		for (int i = 0; i < BOARD_LENGTH; i++) {
			newChromo1.data(i, thisChromo.data(i));
			newChromo2.data(i, thatChromo.data(i));
		}

		// point1 ~ point2 까지 진행한다.
		for (int i = crossPoint1; i <= crossPoint2; i++) {
			item1 = thisChromo.data(i);
			item2 = thatChromo.data(i);

			// 0부터 끝까지 찾으면서
			for (j = 0; j < BOARD_LENGTH; j++) {
				// 포인트 사이 값을 찾는다.
				if (newChromo1.data(j) == item1) {
					pos1 = j;
				} else if (newChromo1.data(j) == item2) {
					pos2 = j;
				}
			}
			// 위에서 찾은 포인트 사이 인덱스가 다를 경우 값을 바꿔준다.
			if (item1 != item2) {
				newChromo1.data(pos1, item2);
				newChromo1.data(pos2, item1);
			}

			// 위와 똑같은 과정을 새로운 염색체 2에 실행한다.
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

	// 바꿀염색체와 exchange할 횟수가 매개변수로 넘어온다.
	private static void exchangeMutation(final int index, final int exchanges) {
		int i = 0;
		int tempData = 0;
		Chromosome thisChromo = null;
		int point1 = 0;
		int point2 = 0;
		boolean done = false;

		thisChromo = population.get(index);

		while (!done) {
			// 0 부터 Board_Length-1 사이의 랜덤한 값을 한 포인트로
			point1 = getRandomNumber(0, BOARD_LENGTH - 1);
			// 0 부터 Board_Length-1 사이의 랜덤한 값중에 point1을 제외한 포인트로
			point2 = getExclusiveRandomNumber(BOARD_LENGTH - 1, point1);

			// 위에서 랜덤하게 정한 두 포인트 값을 바꿔준다.
			tempData = thisChromo.data(point1);
			thisChromo.data(point1, thisChromo.data(point2));
			thisChromo.data(point2, tempData);

			// 랜덤으로 정해진 횟수만큼 값들을 바꾸면 멈춰준다.
			if (i == exchanges) {
				done = true;
			}
			i++;
		}
		// 총 변이 횟수를 올려준다.
		mutations++;
		return;
	}

	// 룰렛에서 선택된 염색체중에서 랜덤하게 염색체를 가져오는 함수
	private static int chooseParent() {
		int parent = 0;
		Chromosome thisChromo = null;
		boolean done = false;

		while (!done) {
			// 현재 염색체중 랜덤하게 선택해서
			parent = getRandomNumber(0, population.size() - 1);
			thisChromo = population.get(parent);
			// 룰렛에 선택당한 염색체라면 멈추고 반환한다.
			if (thisChromo.selected() == true) {
				done = true;
			}
		}

		return parent;
	}

	// 룰렛에서 선택된 염색체와 또다른 염색체를 선택하기위한 함수
	private static int chooseAnotherParent(final int parentA) {
		int parent = 0;
		Chromosome thisChromo = null;
		boolean done = false;

		while (!done) {
			// 현재 염색체중에서 랜덤하게 선택한다
			parent = getRandomNumber(0, population.size() - 1);
			// 만약 원래 선택한 염색체와 다르고 룰렛에서 선택된 염색체 라면 wihile을 멈추고 반환한다.
			if (parent != parentA) {
				thisChromo = population.get(parent);
				if (thisChromo.selected() == true) {
					done = true;
				}
			}
		}

		return parent;
	}

	// 선택을 모두 제거하기위한함수
	private static void prepareNextEpoch() {
		int popSize = 0;
		Chromosome thisChromo = null;
		popSize = population.size();
		// popsize만큼 모든 select변수를 false로 초기화시킨다.
		for (int i = 0; i < popSize; i++) {
			thisChromo = population.get(i);
			thisChromo.selected(false);
		}
		return;
	}

	// low부터 hihg까지중 랜덤한 수를 출력한다.
	private static int getRandomNumber(final int low, final int high) {
		return (int) Math.round((high - low) * new Random().nextDouble() + low);
	}

	// high 까지중에 except를 제외한 랜덤하누를 출력한다.
	private static int getExclusiveRandomNumber(final int high, final int except) {
		boolean done = false;
		int getRand = 0;

		while (!done) {
			getRand = new Random().nextInt(high);
			// 위에서 구한 랜덤한수가 except와 다를 경우 출력한다.
			if (getRand != except) {
				done = true;
			}
		}

		return getRand;
	}

	// low부터 high까지중에 except에 담긴수를 제외한 랜덤값 생성
	private static int getRandomNumber(int low, int high, int[] except) {
		boolean done = false;
		int getRand = 0;
		// high랑 low가 다를때
		if (high != low) {
			while (!done) {
				done = true;
				// 그 사이값을 생성한뒤
				getRand = (int) Math.round((high - low) * new Random().nextDouble() + low);
				// except에 있는지 확인
				for (int i = 0; i < except.length; i++) {
					// 있으면 계속실해애준다.
					if (getRand == except[i]) {
						done = false;
					}
				}
			}
			// except에 없는 값일때 출력
			return getRand;
		} else {
			return high;
		}
	}

	// conflit수가 가장적은 객체의 인덱스를 반환한다.
	private static int minimum() {
		int popSize = 0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		int winner = 0;
		boolean foundNewWinner = false;
		boolean done = false;

		while (!done) {
			// 찾은걸 확인하는 변수
			foundNewWinner = false;
			popSize = population.size();
			// POP_size만큼 돌면서 conflict수가 많은걸 찾는다.
			for (int i = 0; i < popSize; i++) {
				if (i != winner) {
					thisChromo = population.get(i);
					thatChromo = population.get(winner);
					// conflict수가 큰 객체가 나왓을경우
					if (thisChromo.conflicts() < thatChromo.conflicts()) {
						// winner를 바꿔주고 find를 true로 변경해준다.
						winner = i;
						foundNewWinner = true;
					}
				}
			}
			// 가장 처음게 제일 클겨우
			if (foundNewWinner == false) {
				done = true;
			}
		}
		return winner;
	}

	// conflit수가 가장많은 객체의 인덱스를 반환한다.
	private static int maximum() {
		int popSize = 0;
		Chromosome thisChromo = null;
		Chromosome thatChromo = null;
		int winner = 0;
		boolean foundNewWinner = false;
		boolean done = false;

		while (!done) {
			// 찾은걸 확인하는 변수
			foundNewWinner = false;
			popSize = population.size();
			// POP_size만큼 돌면서 conflict수가 적은걸 찾는다.
			for (int i = 0; i < popSize; i++) {
				if (i != winner) { // Avoid self-comparison.
					thisChromo = population.get(i);
					thatChromo = population.get(winner);
					// conflict수가 작은 객체가 나왓을경우
					if (thisChromo.conflicts() > thatChromo.conflicts()) {
						// winner를 바꿔주고 find를 true로 변경해준다.
						winner = i;
						foundNewWinner = true;
					}
				}
			}
			// 가장 처음게 작을 경우
			if (foundNewWinner == false) {
				done = true;
			}
		}
		return winner;
	}

	// 초기 염색체를 생성하는단계
	private static void initializeChromosomes() {
		int shuffles = 0;
		Chromosome newChromo = null;
		int chromoIndex = 0;
		// popsize만큼 염색체를 생선해준다.
		for (int i = 0; i < POP_SIZE; i++) {
			newChromo = new Chromosome();
			// 염색체 집단에 만든 염색체를 넣어준다.
			population.add(newChromo);
			chromoIndex = population.indexOf(newChromo);
			// 위 생성자에서 일단 행에 중복되지 않는 퀸을 배치했으므로
			// 랜덤한 염색체를위해 염색체끼리 섞어준다.
			shuffles = getRandomNumber(MINIMUM_SHUFFLES, MAXIMUM_SHUFFLES);
			exchangeMutation(chromoIndex, shuffles);

			// 썩인 염색체에 대해서 충돌횟수
			population.get(chromoIndex).computeConflicts();

		}
		return;
	}

	// 염색체 클래스이다. fitness순으로 정렬하기위해 comparealbe 인터페이스를 implemets
	public static class Chromosome implements Comparable<Chromosome> {
		// 각 행에 어떤 열에 퀸이 있는지에 대한 정보이다.
		private int row[] = new int[BOARD_LENGTH];
		// 적응도
		private double mFitness = 0.0;
		// 선택된건지 아닌지에대한 변수
		private boolean mSelected = false;
		// 선택될확률
		private double mSelectionProbability = 0.0;
		// 출돌횟수
		private int mConflicts = 0;

		public Chromosome() {
			for (int i = 0; i < BOARD_LENGTH; i++) {
				this.row[i] = i;// 생성자로 일단 각행에 열의 인덱스를 넣어준다.
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
			// 대각선 방향으로 움직일 수 있는 ar
			int dx[] = new int[] { -1, 1, -1, 1 };
			int dy[] = new int[] { -1, 1, 1, -1 };
			boolean done = false;
			// 빈 보드를 만든다.
			for (int i = 0; i < BOARD_LENGTH; i++) {
				for (int j = 0; j < BOARD_LENGTH; j++) {
					board[i][j] = "";
				}
			}
			// 현재 개체에 담긴 퀸정보를 배치한뒤
			for (int i = 0; i < BOARD_LENGTH; i++) {
				board[i][this.row[i]] = "Q";
			}

			for (int i = 0; i < BOARD_LENGTH; i++) {// row만큼 퀸을 두었을때의 conflict를 계산한다.
				x = i;
				y = this.row[i];// row[i] 는 col 의 값이 있으므로 x,y를 설정한뒤

				for (int j = 0; j <= 3; j++) {// 대각선 4방향으로 움직이며 충돌하는 퀸을 찾는다.
					tempx = x;
					tempy = y;
					// 위에서 정한 위치부터 움직여본다.
					done = false;
					while (!done) {
						tempx += dx[j];
						tempy += dy[j];
						if ((tempx < 0 || tempx >= BOARD_LENGTH) || (tempy < 0 || tempy >= BOARD_LENGTH)) {
							// 만약 사이즈를 벗어나면 다음 방향으로 움직인다.
							done = true;
						} else {
							// 만약 퀸이 있다면 충돌 횟수를 올려준다.
							if (board[tempx][tempy].compareToIgnoreCase("Q") == 0) {
								conflicts++;
							}
						}
					}
				}
			}
			// 해당 개채의 충돌횟수를 지정한다.
			this.mConflicts = conflicts;
		}

		// conflit변경함수
		public void conflicts(int value) {
			this.mConflicts = value;
			return;
		}

		// conflict 반환함수
		public int conflicts() {
			return this.mConflicts;
		}

		// 선택확률반환함수
		public double selectionProbability() {
			return mSelectionProbability;
		}

		// 선택확률 변경함수
		public void selectionProbability(final double SelProb) {
			mSelectionProbability = SelProb;
			return;
		}

		// 선택 되었는지 반환
		public boolean selected() {
			return mSelected;
		}

		// 선택 변수 변경함수
		public void selected(final boolean sValue) {
			mSelected = sValue;
			return;
		}

		// 적응도 출력함수
		public double fitness() {
			return mFitness;
		}

		// 적응도 변경함수
		public void fitness(final double score) {
			mFitness = score;
			return;
		}

		// 현재 퀸의 위치 어레이 출력
		public int data(final int index) {
			return row[index];
		}

		// 현재 퀸의 위치 어레이의 index 값을 value로 바꾸는함수
		public void data(final int index, final int value) {
			row[index] = value;
			return;
		}

		// fitness로 배열허기위한 compare함수
		@Override
		public int compareTo(Chromosome o) {
			return Double.compare(this.mFitness, o.mFitness);
		}
	}

}