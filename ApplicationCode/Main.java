import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Matrix size variable
        int size = 0;
        // Input size with error checking
        while (true) {
            String sizeInput = JOptionPane.showInputDialog(null, "Enter matrix size:",
                    "Matrix Input", JOptionPane.QUESTION_MESSAGE);
            if (sizeInput == null) {
                return;  // User canceled or closed the dialog
            }
            try {
                size = Integer.parseInt(sizeInput);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Manual matrix input check
        Integer inputMatrix = JOptionPane.showConfirmDialog(null, "Do you want to input the matrix manually?",
                "Matrix Input", JOptionPane.YES_NO_OPTION);
        if(inputMatrix == null || inputMatrix == JOptionPane.CLOSED_OPTION) {
            return;
        }

        // Sum display check
        Integer displaySum = JOptionPane.showConfirmDialog(null, "Do you want to display the sum of elements for each row?",
                "Matrix Input", JOptionPane.YES_NO_OPTION);
        if(displaySum == null || displaySum == JOptionPane.CLOSED_OPTION) {
            return;
        }

        // Sort order check
        Integer isAscending = JOptionPane.showConfirmDialog(null, "Do you want to sort in ascending order?",
                "Matrix Input", JOptionPane.YES_NO_OPTION);
        if(isAscending == null || isAscending == JOptionPane.CLOSED_OPTION) {
            return;
        }

        // Matrix and sum arrays initialization
        int[][] matrix = new int[size][size];
        int[] sum = new int[size];

        // If user inputs matrix manually
        if(inputMatrix == JOptionPane.YES_OPTION){
            for (int i = 0; i < size; i++) {
                while (true) {
                    String lineInput = JOptionPane.showInputDialog(null, "Enter " + size + " numbers for row " + (i+1),
                            "Matrix Input", JOptionPane.QUESTION_MESSAGE);
                    if (lineInput == null) {
                        return;  // User canceled or closed the dialog
                    }
                    String[] line = lineInput.split(" ");
                    if(line.length != size){
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter correct number of elements.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                        sum[i] += matrix[i][j];
                    }
                    break;
                }
            }
        }
        else {
            // Matrix generation
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = rand.nextInt(10);
                    sum[i] += matrix[i][j];
                }
            }
        }

        // Original matrix output
        String originalMatrix = "Original matrix:\n";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                originalMatrix += matrix[i][j] + " ";
            }
            if (displaySum == JOptionPane.YES_OPTION) {
                originalMatrix += "[" + sum[i] + "]";
            }
            originalMatrix += "\n";
        }

        JOptionPane.showMessageDialog(null, originalMatrix, "Matrix", JOptionPane.INFORMATION_MESSAGE);

        // Matrix sorting
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((isAscending == JOptionPane.YES_OPTION && sum[i] > sum[j]) ||
                        (isAscending == JOptionPane.NO_OPTION && sum[i] < sum[j])) {
                    int temp = sum[i];
                    sum[i] = sum[j];
                    sum[j] = temp;

                    int[] tempRow = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = tempRow;
                }
            }
        }

        // Sorted matrix output
        String sortedMatrix = "Matrix after sorting:\n";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sortedMatrix += matrix[i][j] + " ";
            }
            if (displaySum == JOptionPane.YES_OPTION) {
                sortedMatrix += "[" + sum[i] + "]";
            }
            sortedMatrix += "\n";
        }

        JOptionPane.showMessageDialog(null, sortedMatrix, "Matrix", JOptionPane.INFORMATION_MESSAGE);
    }
}
