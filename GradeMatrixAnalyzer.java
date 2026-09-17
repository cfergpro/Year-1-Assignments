import java.util.Arrays;
import java.util.Scanner;

public class GradeMatrixAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] rocketids = {1001, 1004, 1002, 1005, 1003};
        double[][] grades = {{88.5, 92.0, 79.0, 85.5},
                            {72.0, 68.5, 75.0, 70.0},
                            {95.0, 98.0, 91.5, 94.0},
                            {61.0, 74.5, 80.0, 69.5},
                            {84.0, 88.5, 82.0, 90.0}};
        for (int i = 0; i < grades.length; i++) {
            System.out.println(Arrays.toString(grades[i]));
        }
        System.out.print("Student final exam averages: " + Arrays.toString(computeStudentAverages(grades)));
        System.out.print("\nClass average for each exam: " + Arrays.toString(computeExamAverages(grades)));
        System.out.print("\nEnter a Rocket ID to search for: ");
        int searchID = input.nextInt();
        if (searchRocketID(rocketids, searchID) == -1) {
            System.out.print("\nInvalid Rocket ID");
        }
        else {
            System.out.print("\nLinear Search: Rocket ID " + searchID + " found at index " + searchRocketID(rocketids, searchID));
        }

        System.out.print("\nSorted Student Averages (Ascending): " + Arrays.toString(selectionSortCopy(computeStudentAverages(grades))));

        System.out.print("\nEnter a score to search for: ");
        double searchScore = input.nextDouble();
        if (binarySearchScore(selectionSortCopy(computeStudentAverages(grades)), searchScore) == -1) {
            System.out.print("\nInvalid Score");
        }
        else {
            System.out.print("\nBinary Search: Score " + searchScore + " found at index " + binarySearchScore(selectionSortCopy(computeStudentAverages(grades)), searchScore));
        }
    }

    public static double[] computeStudentAverages(double[][] matrix) {
        double[] sAverages = new double[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            double sum = 0;
            double avg = 0;
            for (int col = 0; col < matrix[0].length; col++) {
                sum += matrix[row][col];
            }
            avg = sum / matrix[0].length;
            sAverages[row] = avg;
        }
        return sAverages;
    }
    
    public static double[] computeExamAverages(double[][] matrix) {
        double[] eAverages = new double[matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            double sum = 0;
            double avg = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            avg = sum / matrix.length;
            eAverages[col] = avg;
        }
        return eAverages;
    }

    public static int searchRocketID(int[] ids, int targetId) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static double[] selectionSortCopy(double[] list) {
        double[] copy = new double[list.length];
        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        for (int i = 0; i < copy.length; i++) {
            int min = i;

            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[min]) {
                    min = j;
                }
            }

            double temp = copy[i];
            copy[i] = copy[min];
            copy[min] = temp;
            
        }

        return copy;
    }

    public static int binarySearchScore(double[] sortedList, double target) {
        int low = 0;
        int high = sortedList.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sortedList[mid] == target) {
                return mid;
            }
            else if (sortedList[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
