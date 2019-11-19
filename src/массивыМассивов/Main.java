package массивыМассивов;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


	}

	// 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый
	// элемент больше последнего.

	private static void task1(int n, int k) {
		int array[][] = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		for (int i = 0; i < k; i = i + 2) {
			if (array[0][i] > array[n - 1][i]) {

				for (int j = 0; j < n; j++) {
					System.out.print(array[j][i] + " ");
				}

				System.out.println();
			}
		}
	}

	// 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на
	// диагонали.

	private static void task2(int n) {
		int array[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		for (int i = 0; i < n; i++) {
			System.out.println(array[i][i]);
		}

	}

	// 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

	private static void task3(int row, int column) {
		int n = 10;
		int k = 8;
		int array[][] = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		System.out.println("Исходный массив: ");
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
		if (row <= n) {
			System.out.println("n-ая стока: " + Arrays.toString(array[row - 1]));

		}
		System.out.print("к-ый столбец: ");
		if (column <= k) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[j][column - 1] + " ");
			}
		}

	}

	// 4. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):

	private static void task4(int size) {
		int array[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i % 2 == 0) {
					array[i][j] = j + 1;
				} else {
					array[i][j] = size - j;
				}
			}
		}

		System.out.println("Исходный массив: ");
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
	}

	// 5. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):

	private static void task5(int size) {
		int array[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i > size - j - 1) {
					array[i][j] = 0;
				} else {
					array[i][j] = i + 1;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
	}

	// 6. Сформировать квадратную матрицу порядка n по заданному образцу(n -
	// четное):

	private static void task6(int size) {
		int array[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i > size - j - 1 && j > i || i > j && size - j - 1 > i) {
					array[i][j] = 0;

				} else {
					array[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
	}

	// 7. Сформировать квадратную матрицу порядка N по правилу:
	// и подсчитать количество положительных элементов в ней.

	private static void task7(int size) {
		double array[][] = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = Math.sin((i * i + j * j) / size);
			}
		}
		System.out.println("Исходный массив:");

		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
		int counter = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (array[i][j] > 0) {
					counter++;
				}
			}

		}
		System.out.println("Кол-во положительных чисел: " + counter);

	}

	/*
	 * 8. В числовой матрице поменять местами два столбца любых столбца, т. е.
	 * все элементы одного столбца поставить на соответствующие им позиции
	 * другого, а его элементы второго переместить в первый. Номера столбцов
	 * вводит пользователь с клавиатуры.
	 */
	private static void task8(int size) {
		int array[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите 2 числа от 0 до " + (size - 1));
		int[] columns = getColumns(scanner);
		while (columns[0] >= size || columns[1] >= size) {
			System.out.print("Введите правильные аргументы!");
			columns = getColumns(scanner);
		}
		System.out.println(columns[0]);
		System.out.println(columns[1]);
		for (int i = 0; i < size; i++) {
			int buffer = array[i][columns[0]];
			array[i][columns[0]] = array[i][columns[1]];
			array[i][columns[1]] = buffer;
		}
		System.out.println("Измененный массив");
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
	}

	private static int[] getColumns(Scanner scanner) {

		int[] columns = new int[2];
		while (scanner.hasNext()) {
			columns[0] = scanner.nextInt();
			columns[1] = scanner.nextInt();
			break;
		}
		return columns;
	}

	/*
	 * 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в
	 * каждом столбце. Определить, какой столбец содержит максимальную сумму.
	 */
	private static void task9(int size) {
		int array[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
		int sumArray[] = new int[size];
		for (int i = 0; i < size; i++) {
			sumArray[i] = 0;
			for (int j = 0; j < size; j++) {
				sumArray[i] = sumArray[i] + array[j][i];
			}
		}

		System.out.println("Суммы:" + Arrays.toString(sumArray));

		int maxSum = 0;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (maxSum < sumArray[i]) {
				maxSum = sumArray[i];
				index = i;
			}
		}
		System.out.println("Максимальная сумма в " + (index + 1) + " столбце:" + maxSum);
	}

	// 10. Найти положительные элементы главной диагонали квадратной матрицы.

	private static void task10(int size) {
		int array[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = (int) (Math.random() * 100) - 50;
			}
		}
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println("Положительные элементы главной диагонали:");
		for (int i = 0; i < array.length; i++) {
			if (array[i][i] > 0) {
				System.out.print(array[i][i] + " ");
			}
		}
	}

	// 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на
	// экран саму матрицу и номера строк, в
	// которых число 5 встречается три и более раз
	private static void task11() {
		int array[][] = new int[10][20];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				array[i][j] = (int) (Math.random() * 16);
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print((i + 1) + " строка");
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println("Строки с числом 5: ");
		for (int i = 0; i < 10; i++) {
			int counter = 0;
			int index = i;
			for (int j = 0; j < 20; j++) {
				if (array[i][j] == 5) {
					counter++;
				}
			}
			if (counter >= 3) {
				System.out.println((index + 1) + " строка");
			}
		}
	}

	// 12. Отсортировать строки матрицы по возрастанию и убыванию значений
	// элементов.

	private static void task12_13(int size) {
		int array[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = (int) (Math.random() * 100) - 50;
			}
		}
		System.out.println("Исходная матрица");
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));

		}
		System.out.println("По возрастанию в строке");
		for (int i = 0; i < array.length; i++) {
			Arrays.sort(array[i]);
			System.out.println(Arrays.toString(array[i]));

		}

		for (int k = 0; k < size; k++)
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < array[i].length - 1; j++) {
					if (array[i][j] < array[i][j + 1]) {
						int temp = array[i][j];
						array[i][j] = array[i][j + 1];
						array[i][j + 1] = temp;
					}
				}

			}

		System.out.println("По убыванию в строке");

		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));

		}

		// 13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений
		// эементов.

		for (int k = 0; k < size; k++)
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < array[i].length - 1; j++) {
					if (array[j][i] < array[j + 1][i]) {
						int temp = array[j][i];
						array[j][i] = array[j + 1][i];
						array[j + 1][i] = temp;
					}
				}

			}
		System.out.println("По убыванию в столбце");

		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}

		for (int k = 0; k < size; k++)
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < array[i].length - 1; j++) {
					if (array[j][i] > array[j + 1][i]) {
						int temp = array[j][i];
						array[j][i] = array[j + 1][i];
						array[j + 1][i] = temp;
					}
				}

			}
		System.out.println("По возрастанию в столбце");

		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));
		}
	}

	// 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
	// причем в каждом столбце число
	// единиц равно номеру столбца.
	private static void task14(int m, int n) {
		int array[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			int counter = 0;
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(counter + " ");
				if (counter == i) {
					array[i][j] = 1;
				} else {
					array[i][j] = 0;
					counter++;
				}

			}
		}
		System.out.println("Исходная матрица");
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + " строка :");
			System.out.println(Arrays.toString(array[i]));

		}
	}

	// 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы
	// на него.

	private static void task15(int m, int n) {
		int array[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = (int) (Math.random() * 100) - 50;
			}
		}
		System.out.println("Исходная матрица");
		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));

		}

		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		System.out.println("Максимальное: " + max);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j % 2 == 0) {
					array[i][j] = max;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {

			System.out.println(Arrays.toString(array[i]));

		}
	}

}