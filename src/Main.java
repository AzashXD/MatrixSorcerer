import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrix size variable / Переменная размера матрицы
        int size = 0;
        // Input size with error checking / Ввод размера с проверкой ошибок
        while (true) { // Бесконечный цикл для ввода размера матрицы
            try { // Начало блока обработки исключений
                System.out.println("Enter matrix size / Введите размер матрицы:");
                size = Integer.parseInt(scanner.nextLine()); // Читаем строку ввода, преобразуем её в число и присваиваем переменной size
                break; // Если размер матрицы был введён корректно, выходим из цикла
            } catch (NumberFormatException e) { // Обработка исключения при некорректном вводе
                System.out.println("Invalid input. Please enter a number / Неверный ввод. Пожалуйста, введите число цифрами.");
            }
        }

        // Manual matrix input check / Проверка ручного ввода матрицы
        String userInput = ""; // Объявляем строковую переменную для хранения ввода пользователя
        while (true) { // Бесконечный цикл для ввода решения о ручном вводе матрицы
            System.out.println("Do you want to input the matrix manually? / Хотите ввести матрицу вручную? (yes/no or +/-)");
            userInput = scanner.nextLine().toLowerCase(); // Читаем строку ввода и приводим её к нижнему регистру
            if (userInput.equals("+") || userInput.equals("yes") || userInput.equals("-") || userInput.equals("no")) { // Если введено допустимое значение, то
                break; // выходим из цикла
            } else { // Обработка исключения при некорректном вводе
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Sum display check / Проверка отображения суммы
        String displaySumInput = ""; // Объявляем строковую переменную для хранения ввода пользователя о отображении суммы
        while (true) { // Бесконечный цикл для ввода решения о отображении суммы
            System.out.println("Do you want to display the sum of elements for each row? / Хотите показать сумму элементов каждой строки? (yes/no or +/-)");
            displaySumInput = scanner.nextLine().toLowerCase(); // Читаем строку ввода и приводим её к нижнему регистру
            if (displaySumInput.equals("+") || displaySumInput.equals("yes") || displaySumInput.equals("-") || displaySumInput.equals("no")) {
                break; // выходим из цикла
            } else { // Обработка исключения при некорректном вводе
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Sort order check / Проверка порядка сортировки
        String sortOrder = ""; // Объявляем строковую переменную для хранения ввода пользователя о порядке сортировки
        while (true) { // Бесконечный цикл для ввода решения о порядке сортировки
            System.out.println("Do you want to sort in ascending order? / Хотите сортировать по возрастанию? (yes/no or +/-)");
            sortOrder = scanner.nextLine().toLowerCase(); // Читаем строку ввода и приводим её к нижнему регистру
            if (sortOrder.equals("+") || sortOrder.equals("yes") || sortOrder.equals("-") || sortOrder.equals("no")) {
                break; // выходим из цикла
            } else { // Обработка исключения при некорректном вводе
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Parsing user inputs / Парсинг ввода пользователя
        boolean inputMatrix = userInput.equals("+") || userInput.equals("yes"); // Значение true, если пользователь решил вводить матрицу вручную
        boolean displaySum = displaySumInput.equals("+") || displaySumInput.equals("yes"); // Значение true, если пользователь решил отображать сумму
        boolean isAscending = sortOrder.equals("+") || sortOrder.equals("yes"); // Значение true, если пользователь решил сортировать по возрастанию

        // Matrix and sum arrays initialization / Инициализация массивов матрицы и суммы
        int[][] matrix = new int[size][size]; // Двумерный массив для хранения матрицы
        int[] sum = new int[size]; // Одномерный массив для хранения суммы элементов в каждой строке

        // If user inputs matrix manually / Если пользователь вводит матрицу вручную
        if(inputMatrix){
            for (int i = 0; i < size; i++) { // Цикл по строкам матрицы
                System.out.println("Enter row " + (i+1) + " / Введите строку " + (i+1) + ":"); // Приглашение для ввода строки матрицы
                String[] line = scanner.nextLine().split(" "); // Разбиваем введенную строку на элементы
                if(line.length != size){ // Проверяем, что количество элементов в строке соответствует размеру матрицы
                    System.out.println("Invalid input. Please enter correct number of elements / Неверный ввод. Пожалуйста, введите правильное количество элементов.");
                    i--; // Уменьшаем счетчик цикла, чтобы повторно запросить ввод строки
                    continue; // Пропускаем оставшуюся часть цикла
                }
                for (int j = 0; j < size; j++) { // Цикл по элементам строки матрицы
                    matrix[i][j] = Integer.parseInt(line[j]); // Преобразуем строку в число и сохраняем в матрице
                    sum[i] += matrix[i][j]; // Прибавляем значение элемента к сумме строки
                }
            }
        }
        else {
            // Matrix generation / Генерация матрицы
            Random rand = new Random(); // Создаем генератор случайных чисел
            for (int i = 0; i < size; i++) { // Цикл по строкам матрицы
                for (int j = 0; j < size; j++) { // Цикл по элементам строки матрицы
                    matrix[i][j] = rand.nextInt(10); // Генерируем случайное число от 0 до 9 и сохраняем в матрице
                    sum[i] += matrix[i][j]; // Прибавляем значение элемента к сумме строки
                }
            }
        }

        // Original matrix output / Вывод исходной матрицы
        System.out.println("Original matrix / Исходная матрица:");
        for (int i = 0; i < size; i++) { // Цикл по строкам матрицы
            for (int j = 0; j < size; j++) { // Цикл по элементам строки матрицы
                System.out.print(matrix[i][j] + " "); // Выводим значение элемента и пробел после него
            }
            if (displaySum) { // Если пользователь решил отображать сумму
                System.out.print("[" + sum[i] + "]"); // Выводим сумму в квадратных скобках
            }
            System.out.println(); // Переходим на новую строку после вывода каждой строки матрицы
        }

        // Matrix sorting / Сортировка матрицы
        for (int i = 0; i < size; i++) { // Цикл по строкам матрицы
            for (int j = i + 1; j < size; j++) { // Внутренний цикл для сортировки элементов
                if ((isAscending && sum[i] > sum[j]) || (!isAscending && sum[i] < sum[j])) { // Если порядок сортировки возрастающий и сумма в строке i больше суммы в строке j, или если порядок сортировки убывающий и сумма в строке i меньше суммы в строке j
                    int temp = sum[i]; // Временная переменная для хранения суммы в строке i
                    sum[i] = sum[j]; // Заменяем сумму в строке i на сумму в строке j
                    sum[j] = temp; // Заменяем сумму в строке j на сумму в строке i (из временной переменной)

                    int[] tempRow = matrix[i]; // Временная переменная для хранения строки матрицы i
                    matrix[i] = matrix[j]; // Заменяем строку матрицы i на строку матрицы j
                    matrix[j] = tempRow; // Заменяем строку матрицы j на строку матрицы i (из временной переменной)
                }
            }
        }

        // Sorted matrix output / Вывод отсортированной матрицы
        System.out.println("Matrix after sorting / Матрица после сортировки:");
        for (int i = 0; i < size; i++) { // Цикл по строкам матрицы
            for (int j = 0; j < size; j++) { // Цикл по строкам матрицы
                System.out.print(matrix[i][j] + " "); // Выводим значение элемента и пробел после него
            }
            if (displaySum) { // Если пользователь решил отображать сумму
                System.out.print("[" + sum[i] + "]"); // Выводим сумму в квадратных скобках
            }
            System.out.println(); // Переходим на новую строку после вывода каждой строки матрицы
        }
    }
}
