package сортировки;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		task7(7, 8);
	}

	/*
	 * 1. Заданы два одномерных массива с различным количеством элементов и
	 * натуральное число k. Объединить их в один массив, включив второй массив
	 * между k-м и (k+1) - м элементами первого, при этом не используя
	 * дополнительный массив.
	 */
	public static void task1() {
		int k = 3;
		int array1[] = new int[7];
		int arrayBufferLength = array1.length;
		int array2[] = new int[9];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 100);
		}
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		array1 = Arrays.copyOf(array1, array1.length + array2.length);
		System.out.println(array1.length);
		for (int i = k - 1; i < arrayBufferLength; i++) {
			array1[i + array2.length] = array1[i];
		}
		System.out.println(Arrays.toString(array1));
		int counter = 0;
		for (int i = k - 1; i < k - 1 + array2.length; i++) {
			array1[i] = array2[counter];
			counter++;
		}
		System.out.println(Arrays.toString(array1));
	}

	/*
	 * 2. Даны две последовательности . Образовать из них новую
	 * последовательность чисел так, чтобы она тоже была неубывающей.
	 * Примечание. Дополнительный массив не использовать.
	 */
	public static void task2(int n, int m) {
		int array1[] = new int[n];
		int array2[] = new int[m];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = 2 * i;

		}
		for (int i = 0; i < array2.length; i++) {
			array2[i] = 3 * i;

		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));

		array1 = Arrays.copyOf(array1, array1.length + array2.length);
		int counter = 0;
		for (int i = array1.length - array2.length; i < array1.length; i++) {
			array1[i] = array2[counter];
			counter++;
		}
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));

	}

	/*
	 * 3. Сортировка выбором. Дана последовательность чисел . Требуется
	 * переставить элементы так, чтобы они были расположены по убыванию. Для
	 * этого в массиве, начиная с первого, выбирается наибольший элемент и
	 * ставится на первое место, а первый - на место наибольшего. Затем, начиная
	 * со второго, эта процедура повторяется. Написать алгоритм сортировки
	 * выбором.
	 */

	public static void task3(int n) {
		int array1[] = new int[n];

		for (int i = 0; i < array1.length; i++) {
			array1[i] = 2 * i;

		}
		System.out.println(Arrays.toString(array1));

		/*  Для проверки нужное раскомментировать
		 * 
		 * for (int k = 0; k < array1.length; k++) { int max = array1[k]; int
		 * index = k; for (int i = k + 1; i < array1.length; i++) { if
		 * (array1[i] > max) { index = i; max = array1[i]; } } int buffer =
		 * array1[k]; array1[k] = max; array1[index] = buffer; }
		 * 
		 * System.out.println(Arrays.toString(array1));
		 */

		/*
		 * 4. Сортировка обменами. Дана последовательность чисел. Требуется
		 * переставить числа в порядке возрастания. Для этого сравниваются два
		 * соседних числа .Если ai > ai+1 , то делается перестановка. Так
		 * продолжается до тех пор, пока все элементы не станут расположены в
		 * порядке возрастания. Составить алгоритм сортировки, подсчитывая при
		 * этом количества перестановок.
		 * 
		 * a
		 */
		/*
		 * int counter = 0; for (int k = 0; k < array1.length; k++) {
		 * 
		 * for (int i = 0; i < array1.length - k - 1; i++) { if (array1[i]
		 * <array1[i + 1]){
		 *
		 * counter++; int buffer = array1[i]; array1[i] =array1[i + 1]; array1[i
		 * + 1] = buffer;
		 * 
		 * } } }
		 * 
		 * System.out.println(Arrays.toString(array1) + " Кол-во перестановок: "
		 * + counter);
		 */

		// 5. Сортировка вставками.
		for (int k = 0; k < array1.length; k++) {
			for (int i = 0; i < array1.length; i++) {

				int value = array1[i];

				int middleIndex = binarySearch(array1, value, k);
				if (middleIndex != (-1)) {
					array1[i] = array1[middleIndex];
					array1[middleIndex] = value;
				}
			}
		}
		System.out.println(Arrays.toString(array1));

	}

	//6 Сортировка Шелла.
	public static void task6(int n) {
		double array[] = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = Math.random() * 10;
		}
		System.out.println(Arrays.toString(array));

		for (int i = 0; i < n;) {
			if (i == n - 1) {
				break;
			}
			if (array[i] > array[i + 1]) {
				double buffer = array[i];
				array[i] = array[i + 1];
				array[i + 1] = buffer;
				if (i != 0) {
					i--;
				} else {
					i++;
				}

			} else {
				i++;
			}
		}
		System.out.println("сортировка Шелла: " + Arrays.toString(array));
	}

	/*
	 * 7. Пусть даны две неубывающие последовательности действительных чисел
	 * Требуется указать те места, на которые нужно вставлять элементы второй
	 * последовательности в первую последовательность так, чтобы новая
	 * последовательность оставалась возрастающей.
	 */
	public static void task7(int n, int m) {
		double array1[] = new double[n];
		double array2[] = new double[m];
		for (int i = 0; i < n; i++) {
			array1[i] = 2 * i;
		}
		for (int i = 0; i < m; i++) {
			array2[i] = 3 * i;
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));

		array1 = Arrays.copyOf(array1, n + m);
		for (int i = n; i < n + m; i++) {
			array1[i] = array2[i - n];
		}
		Arrays.sort(array1);

		System.out.println(Arrays.toString(array1));
		int indexArray[] = new int[m];
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if (array2[i] == array1[j]) {
					indexArray[i] = j + 1;

				}
			}
		}
		System.out.println("Индексы вставки: " + Arrays.toString(indexArray));

	}

	// 8.Даны дроби. Составить программу, которая приводит эти дроби к общему
	// знаменателю и упорядочивает их в порядке возрастания.
	public static void task8(int n) {

		// Выполнено в пакете декомпозиция

	}

	public static int binarySearch(int arr[], int elementToSearch, int firstIndex) {

		int lastIndex = arr.length - 1;

		int middleIndex = (firstIndex + lastIndex) / 2;
		if (arr[middleIndex] > elementToSearch) {
			return middleIndex;

		}
		return -1;

	}
}
