package одномерные;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		task1(5);
		task2(50);
		task10(20);
	}

	// 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов,
	// которые кратны данному К.

	public static void task1(int k) {
		List<Integer> a = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			a.add(i);
		}
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) % k == 0) {
				sum = sum + a.get(i);
			}

		}
		System.out.println(sum);
	}

	/*
	 * 2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить
	 * все ее члены, большие данного Z, этим числом. Подсчитать количество замен
	 */

	private static void task2(int z) {
		List<Integer> a = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			a.add(i);
		}
		int counter = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > z) {
				a.set(i, z);
				counter++;
			}
		}
		System.out.println(counter);
	}

	/*
	 * 3. Дан массив действительных чисел, размерность которого N. Подсчитать,
	 * сколько в нем отрицательных, положительных и нулевых элементов.
	 */

	private static void task3(int n) {
		double[] a = new double[n];
		int positiveCounter = 0;
		int negativeCounter = 0;
		int nullCounter = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				a[i] = 0;
			} else if (i % 3 == 0) {
				a[i] = -3;
			} else {
				a[i] = i;
			}

		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
			if (a[i] > 0) {
				positiveCounter++;
			} else if (a[i] < 0) {
				negativeCounter++;
			} else {
				nullCounter++;
			}
		}
		System.out.println();
		System.out.println("Положительные числа " + positiveCounter);
		System.out.println("Отрицательные числа " + negativeCounter);
		System.out.println("Нулей " + nullCounter);

	}

	// 4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами
	// наибольший и наименьший элементы

	public static void task4(int n) {
		double[] d = new double[n];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				d[i] = 0;
			} else if (i % 3 == 0) {
				d[i] = -3;
			} else {
				d[i] = i;
			}
		}
		for (double x : d) {
			System.out.print(x + " ");
		}
		double max = d[0];
		int indexMax = 0;
		int indexMin = 0;
		double min = d[0];
		for (int i = 1; i < n; i++) {
			if (max < d[i]) {
				max = d[i];
				indexMax = i;
			}
			if (min > d[i]) {
				min = d[i];
				indexMin = i;
			}
		}
		d[indexMin] = max;
		d[indexMax] = min;
		System.out.println();
		for (double x : d) {
			System.out.print(x + " ");
		}

	}

	// 5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа,
	// для которых аi > i.

	public static void task5(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 10);
			System.out.print(array[i] + "  ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (array[i] > i) {
				System.out.print(array[i] + "  ");
			}
		}
	}

	public static boolean isSimple(int ANum) {
		if (ANum < 2)
			return false;
		for (int i = 2; i < ANum; i++) {
			if (ANum % i == 0)
				return false;
		}
		return true;
	}

	public static double[] initArray(int size) {
		double[] array = new double[size];
		for (int i = 0; i < size; i++) {
			array[i] = (Math.random() * 10);

		}
		return array;
	}

	public static int[] initIntArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * 1000);

		}
		System.out.println("Исходный массив:  " + array.length + " Элементов " + Arrays.toString(array));
		return array;
	}

	/*
	 * 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел,
	 * порядковые номера которых являются простыми числами.
	 */

	public static void task6(int n) {
		double[] array = initArray(n);

		System.out.println();
		int sum = 2;
		for (int i = 3; i < n; i++) {
			if (isSimple(i)) {
				sum = sum + i;
			}
		}

		System.out.println("sum is " + sum);
	}

	// 7 в задании опечатка.
	public static void task7(int n) {
		double[] array = initArray(n);

	}

	/*
	 * 8. Дана последовательность целых чисел . Образовать новую
	 * последовательность, выбросив из исходной те члены, которые равны min
	 */

	public static void task8(int n) {
		int[] array = initIntArray(n);
		Arrays.sort(array);
		array = Arrays.copyOfRange(array, 1, n);
		System.out.println("Новый массив: " + array.length + Arrays.toString(array));
	}

	/*
	 * 9. В массиве целых чисел с количеством элементов n найти наиболее часто
	 * встречающееся число. Если таких чисел несколько, то определить наименьшее
	 * из них.
	 */
	public static void task9(int n) {
		int[] array = initIntArray(n);
		int[] counters = new int[n];
		for (int j = 0; j < n; j++) {
			int counter = 0;
			for (int i = 0; i < n; i++) {

				if (array[j] == array[i]) {
					counter++;
				}
			}
			counters[j] = counter;
		}
		System.out.println("counters: " + counters.length + Arrays.toString(counters));
		int counterMax = counters[0];
		int counterMaxIndex = 0;
		for (int i = 1; i < n; i++) {
			if (counterMax < counters[i]) {
				counterMax = counters[i];
				counterMaxIndex = i;
			}
		}
		int minValue = array[counterMaxIndex];
		for (int i = 0; i < n; i++) {
			if (counters[counterMaxIndex] == counters[i]) {
				if (array[counterMaxIndex] > array[i]) {
					minValue = array[i];
				}

			}
		}
		System.out.println("minvalue: " + minValue);
		System.out.println("counterMaxIndex " + counters[counterMaxIndex] + " times " + array[counterMaxIndex]);
	}

	/*
	 * 10. Дан целочисленный массив с количеством элементов п. Сжать массив,
	 * выбросив из него каждый второй элемент (освободившиеся элементы заполнить
	 * нулями). Примечание. Дополнительный массив не использовать.
	 */

	public static void task10(int n) {
		int[] array = initIntArray(n);
		for (int i = 1; i < n; i = i + 2) {
			array[i] = 0;

		}
		System.out.println(Arrays.toString(array));

	}

}
