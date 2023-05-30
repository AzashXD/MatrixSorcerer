import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrix size variable / Переменная размера матрицы
        int size = 0;
        // Input size with error checking / Ввод размера с проверкой ошибок
        while (true) {
            try {
                System.out.println("Enter matrix size / Введите размер матрицы:");
                size = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number / Неверный ввод. Пожалуйста, введите число цифрами.");
            }
        }

        // Manual matrix input check / Проверка ручного ввода матрицы
        String userInput = "";
        while (true) {
            System.out.println("Do you want to input the matrix manually? / Хотите ввести матрицу вручную? (yes/no or +/-)");
            userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("+") || userInput.equals("yes") || userInput.equals("-") || userInput.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Sum display check / Проверка отображения суммы
        String displaySumInput = "";
        while (true) {
            System.out.println("Do you want to display the sum of elements for each row? / Хотите показать сумму элементов каждой строки? (yes/no or +/-)");
            displaySumInput = scanner.nextLine().toLowerCase();
            if (displaySumInput.equals("+") || displaySumInput.equals("yes") || displaySumInput.equals("-") || displaySumInput.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Sort order check / Проверка порядка сортировки
        String sortOrder = "";
        while (true) {
            System.out.println("Do you want to sort in ascending order? / Хотите сортировать по возрастанию? (yes/no or +/-)");
            sortOrder = scanner.nextLine().toLowerCase();
            if (sortOrder.equals("+") || sortOrder.equals("yes") || sortOrder.equals("-") || sortOrder.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter valid option / Неверный ввод. Пожалуйста, выберите допустимый вариант.");
            }
        }

        // Parsing user inputs / Парсинг ввода пользователя
        boolean inputMatrix = userInput.equals("+") || userInput.equals("yes");
        boolean displaySum = displaySumInput.equals("+") || displaySumInput.equals("yes");
        boolean isAscending = sortOrder.equals("+") || sortOrder.equals("yes");

        // Matrix and sum arrays initialization / Инициализация массивов матрицы и суммы
        int[][] matrix = new int[size][size];
        int[] sum = new int[size];

        // If user inputs matrix manually / Если пользователь вводит матрицу вручную
        if(inputMatrix){
            for (int i = 0; i < size; i++) {
                System.out.println("Enter row " + (i+1) + " / Введите строку " + (i+1) + ":");
                String[] line = scanner.nextLine().split(" ");
                if(line.length != size){
                    System.out.println("Invalid input. Please enter correct number of elements / Неверный ввод. Пожалуйста, введите правильное количество элементов.");
                    i--;
                    continue;
                }
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    sum[i] += matrix[i][j];
                }
            }
        }
        else {
            // Matrix generation / Генерация матрицы
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = rand.nextInt(10);
                    sum[i] += matrix[i][j];
                }
            }
        }

        // Original matrix output / Вывод исходной матрицы
        System.out.println("Original matrix / Исходная матрица:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            if (displaySum) {
                System.out.print("[" + sum[i] + "]");
            }
            System.out.println();
        }

        // Matrix sorting / Сортировка матрицы
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((isAscending && sum[i] > sum[j]) || (!isAscending && sum[i] < sum[j])) {
                    int temp = sum[i];
                    sum[i] = sum[j];
                    sum[j] = temp;

                    int[] tempRow = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = tempRow;
                }
            }
        }

        // Sorted matrix output / Вывод отсортированной матрицы
        System.out.println("Matrix after sorting / Матрица после сортировки:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            if (displaySum) {
                System.out.print("[" + sum[i] + "]");
            }
            System.out.println();
        }
    }
}