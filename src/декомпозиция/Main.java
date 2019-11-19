package декомпозиция;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		System.out.println(findNod(66, 33));
		System.out.println(task1(66, 20));
		System.out.println(task2(78, 294, 570, 36));
		task6(3, 6, 5);
		task8(5);
		task9(1, 2, 3, 4);
		task11(12321442, 2321499);
		task12(20, 5);
		task13(7);
		task17(50);
		task0(10);
	}

	// задание 8 из темы сортировки
	// Даны дроби. Составить программу, которая приводит эти дроби к общему
	// знаменателю и упорядочивает их в порядке возрастания.
	public static void task0(int size) {
		int numerators[] = new int[size];
		int denominators[] = new int[size];
		for (int i = 0; i < size; i++) {
			numerators[i] = 1 + (int) (Math.random() * 10);
			denominators[i] = 1 + (int) (Math.random() * 10);
		}
		System.out.println("Исходные массивы");
		System.out.println(Arrays.toString(numerators));
		System.out.println(Arrays.toString(denominators));
		for (int i = 0; i < size - 1; i++) {
			int nok = task1(denominators[i], denominators[i + 1]);
			int dev1 = nok / denominators[i];
			int dev2 = nok / denominators[i + 1];
			numerators[i] = numerators[i] * dev1;
			numerators[i + 1] = numerators[i + 1] * dev2;
			denominators[i] = nok;
			denominators[i + 1] = nok;

		}

		System.out.println("Числители после приведения");

		System.out.println(Arrays.toString(numerators));
		System.out.println("Общий знаменатель: " + denominators[denominators.length - 1]);

		Arrays.sort(numerators);
		System.out.println("Числители по возрастанию:" + Arrays.toString(numerators));
	}

	// Task1
	/*
	 * 1. Написать метод(методы) для нахождения наибольшего общего делителя и
	 * наименьшего общего кратного двух натуральных чисел:
	 */
	public static int task1(int a, int b) {
		return a * b / findNod(a, b);
	}

	// Task2
	// 2. Написать метод(методы) для нахождения наибольшего общего делителя
	// четырех натуральных чисел.
	public static int task2(int a, int b, int c, int d) {
		int nodAB = findNod(a, b);
		int nodC = findNod(c, nodAB);
		return findNod(d, nodC);
	}

	// Task3
	// 3. Вычислить площадь правильного шестиугольника со стороной а, используя
	// метод вычисления площади треугольника.
	public static int task3(int a) {
		return findTriagnleSquare(a) * 6;
	}

	// Task4
	// 4. На плоскости заданы своими координатами n точек. Написать
	// метод(методы), определяющие, между какими из пар точек самое большое
	// расстояние. Указание. Координаты точек занести в массив.
	public static void task4(int size) {
		Dot dots[] = new Dot[size];
		for (int i = 0; i < size; i++) {
			dots[i] = new Dot((int) (Math.random() * 100), (int) (Math.random() * 100));
		}
		System.out.println(Arrays.toString(dots));

		Map<String, Double> distance = new HashMap<>();
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				System.out.println(i + " " + j);
				distance.put(i + " " + j, Dot.getDistance(dots[i], dots[j]));
			}
		}

		double max = 0;
		String key = "";
		for (Map.Entry<String, Double> entry : distance.entrySet()) {
			double val = entry.getValue();

			System.out.println(val + " " + entry.getKey());
			if (val > max) {
				max = val;
				key = entry.getKey();

			}

		}
		System.out.println("Максимальный отрезок между индексами " + key + " равен " + max);

	}

	// Task5
	// 5. Составить программу, которая в массиве A[N] находит второе по величине
	// число (вывести на печать число, которое меньше максимального элемента
	// массива, но больше всех других элементов).
	public static void task5(int size) {
		int array[] = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

		System.out.println("Второе маккимальное: " + array[array.length - 2]);

	}

	// Task6
	// 6. Написать метод(методы), проверяющий, являются ли данные три числа
	// взаимно простыми.
	public static void task6(int a, int b, int c) {
		int nodAB = findNod(a, b);
		int nodC = findNod(c, nodAB);
		if (nodC == 1) {
			System.out.println("Числа взаимно простые");
		} else {
			System.out.println("Числа не взаимно простые");

		}

	}

	// Task7
	// 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных
	// чисел от 1 до 9.
	public static void task7() {
		int sum = 0;
		for (int i = 1; i <= 9; i = i + 2) {
			sum = sum + calculateFactorial(i);
		}
		System.out.println("Сумма факториалов = " + sum);
	}

	// Task8
	/*
	 * 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] +
	 * D[4] + D[5]; D[4] +D[5] +D[6]. Пояснение. Составить метод(методы) для
	 * вычисления суммы трех последовательно расположенных элементов массива с
	 * номерами от k до m.
	 */
	public static void task8(int size) {
		int array[] = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length - 2; i++) {
			System.out.print("Сумма трех чисел: ");

			System.out.println(array[i] + array[i + 1] + array[i + 2]);
		}
	}

	// Task9
	// 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать
	// метод(методы) вычисления его площади, если угол между сторонами длиной X
	// и Y— прямой.
	public static void task9(int x, int y, int z, int t) {
		int p = (x + y + z + t) / 2;
		double square = Math.sqrt((p - x) * (p - y) * (p - z) * (p - t));
		System.out.println("Площадь четырехугольника: " + square);
	}

	// Task10
	// 10. Дано натуральное число N. Написать метод(методы) для формирования
	// массива, элементами которого являются цифры числа N.
	public static void task10(int n) {
		String s = "" + n;
		char array[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
		}
		System.out.println(Arrays.toString(array));
	}

	public static int findTriagnleSquare(int a) {
		return (int) (a * a * Math.sqrt(3) / 4);
	}

	// Task11
	// 11. Написать метод(методы), определяющий, в каком из данных двух чисел
	// больше цифр.
	public static void task11(int number1, int number2) {
		String s1 = "" + number1;
		String s2 = "" + number2;
		if (s2.length() > s1.length()) {
			System.out.println("Во втором числе больше цифр!");
		} else if (s2.length() < s1.length()) {
			System.out.println("В первом числе больше цифр!");

		} else {
			System.out.println("Числа имеют равное кол-во цифр!");
		}

	}

	// Task12
	// 12. Даны натуральные числа К и N. Написать метод(методы) формирования
	// массива А, элементами которого являются числа, сумма цифр которых равна К
	// и которые не большее N.
	public static void task12(int k, int n) {

		long array[] = new long[10];
		for (int j = 0; j < 10;) {
			String s = "";
			int result = 0;
			for (int i = 0; i < 100; i++) {
				if (result == k) {
					break;
				}
				int val = (int) (Math.random() * n);
				result = result + val;
				if (result < k) {
					s = s + val;
				} else if (result > k) {
					s = s + (k - (result - val));
					array[j] = Long.parseLong(s);
					j++;
					break;
				}
			}

		}

		System.out.println("Сумма цифр = " + k + Arrays.toString(array));
	}

	// Task13
	// 13. Два простых числа называются «близнецами», если они отличаются друг
	// от друга на 2 (например, 41 и 43). Найти и напечатать все пары
	// «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше
	// 2. Для решения задачи использовать декомпозицию.
	public static void task13(int n) {
		int array[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			array[i] = i + n;
		}
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length - 2; i++) {
			if (isTwinNumber(array[i], array[i + 2])) {
				System.out.println("Близнецы: " + array[i] + " " + array[i + 2]);
			}
		}
	}

	// Task14
	// 14. Натуральное число, в записи которого n цифр, называется числом
	// Армстронга, если сумма его цифр, возведенная в степень n, равна самому
	// числу. Найти все числа Армстронга от 1 до k. Для решения задачи
	// использовать декомпозицию.
	public static void task14() {
		int array[] = new int[1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		for (int i = 0; i < array.length; i++) {
			if (isArmstrongNumber(array[i])) {
				System.out.println("Число Армстронга:" + array[i] + " ");
			}
		}

	}

	// Task15
	// 15. Найти все натуральные n-значные числа, цифры в которых образуют
	// строго возрастающую последовательность (например, 1234, 5789). Для
	// решения задачи использовать декомпозицию
	public static void task15() {
		int array[] = new int[150];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		System.out.println("Числа с возрастающим порядком: ");

		for (int i = 0; i < array.length; i++) {
			if (isIncreasingNumber(array[i])) {
				System.out.print(array[i] + " ");
			}
		}

	}

	// Task16
	// 16. Написать программу, определяющую сумму n - значных чисел, содержащих
	// только нечетные цифры. Определить также, сколько четных цифр в найденной
	// сумме. Для решения задачи использовать декомпозицию.
	public static void task16() {
		int array[] = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (isOddNumber(array[i])) {

				sum = sum + array[i];
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Сумма чисел состоящих из нечетных цифр: " + sum);

		System.out.println("Кол-во четных цифр в сумме: " + countEvenNumbers(sum));
	}

	// Task17
	// 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли
	// сумму его цифр и т.д. Сколько таких действий надо произвести, чтобы
	// получился нуль? Для решения задачи использовать декомпозицию.
	public static void task17(int number) {
		int counter = 0;
		while (number != 0) {
			number = subtract(number);
			counter++;
		}
		System.out.println(counter + " вычитаний.");
	}

	public static int subtract(int number) {
		int nums[] = decomposeNumber(number);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		return number - sum;
	}

	public static int[] decomposeNumber(int number) {
		String s = number + "";
		int nums[] = new int[s.length()];
		int counter = 0;
		while (number != 0) {
			nums[counter] = number % 10;
			number /= 10;
			counter++;
		}
		return nums;
	}

	public static Boolean isIncreasingNumber(int number) {
		int nums[] = decomposeNumber(number);

		Boolean val = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] <= nums[i + 1]) {
				val = false;
				break;
			} else {
				val = true;

			}
		}
		return val;

	}

	public static int countEvenNumbers(int number) {
		int nums[] = decomposeNumber(number);
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				result++;
			}
		}
		return result;

	}

	public static Boolean isOddNumber(int number) {
		int nums[] = decomposeNumber(number);

		System.out.println(Arrays.toString(nums));

		Boolean val = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				val = false;
				break;

			} else {
				val = true;
			}
		}
		System.out.println(val);

		return val;

	}

	public static Boolean isArmstrongNumber(int number) {
		int nums[] = decomposeNumber(number);
		int value = number;

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + (int) Math.pow(nums[i], nums.length);
		}
		if (sum == value) {
			return true;
		} else {
			return false;
		}

	}

	public static Boolean isTwinNumber(int a, int b) {
		if (a == (b + 2) || b == (a + 2)) {
			return true;
		} else {
			return false;
		}
	}

	public static int calculateFactorial(int n) {
		int result = 1;
		if (n == 0 || n == 1) {
			return 1;
		} else {
			for (int i = 2; i <= n; i++) {
				result = result * i;
			}
			return result;
		}

	}

	public static int findNod(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

}
