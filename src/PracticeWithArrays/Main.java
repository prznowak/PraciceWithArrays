package PracticeWithArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //int[] myArray = getIntegers(10);
        //printArray(myArray);
        //sortOurArrayBySelectionSort(myArray);

//        int[] myArray = {21,32,23,1,32,1,2,9,0,2,123,4231,434,232,23,7,87,66,55, 11, 32323,4343,10000,37,42,12,67,89,43,12,34,56,78,978,31,34,56,78,43,12,34,565};
//        int[] myArray2 = {21,32,23,1,32,1,2,9,0,2,123,4231,434,232,23,7,87,66,55, 11, 32323,4343,10000,37,42,12,67,89,43,12,34,56,78,978,31,34,56,78,43,12,34,565};

        int[] myArray = randomFillArray(10000);
        int[] myArray2 = Arrays.copyOf(myArray,myArray.length);
        // int[] myArray2 = randomFillArray(18989);


        printArray(myArray);
        System.out.println("----------------------------------------");
        System.out.println("Selection sort:");
        long startTime = System.nanoTime();
        printArray(sortOurArrayBySelectionSort(myArray));
        long endTime = System.nanoTime();
        long timeDiff = endTime - startTime;
        double duration = (timeDiff / 1000000.0);
        System.out.println("Duration of sort (nanoseconds):");
        System.out.println(timeDiff);
        System.out.println("Duration of sort (milliseconds):");
        System.out.printf("%.6f", duration);

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Bubble sort:");
        long startTime2 = System.nanoTime();
        printArray(sortOurArrayByBubbleSort(myArray2));
        long endTime2 = System.nanoTime();
        long timeDiff2 = endTime2 - startTime2;
        double duration2 = (timeDiff2 / 1000000.0);
        System.out.println("Duration of sort (nanoseconds):");
        System.out.println(timeDiff2);
        System.out.println("Duration of sort (milliseconds):");
        String.valueOf(System.out.printf("%.6f", duration2));
        System.out.println();
        System.out.println("Comparison: Selection Sort(milliseconds):");
        String.valueOf(System.out.printf("%.6f", duration));
        System.out.println();
        System.out.println("Comparison: Bubble Sort(milliseconds):");
        String.valueOf(System.out.printf("%.6f", duration2));
        System.out.println();
    }


    public static int[] sortOurArrayByBubbleSort(int[] array){
        int[] sortedArray = Arrays.copyOf(array,array.length);

        boolean flag = true;
        int temp;

        while(flag){
            flag = false;

            for (int i = 0; i <sortedArray.length-1 ; i++) {
                if(sortedArray[i]<sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }

            }

        }



        return sortedArray;
    }


    public static int[] sortOurArrayBySelectionSort(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            int index = i;
            for (int j = i + 1; j < array.length; j++) {

                if (array[j] > array[index]) {
                    index = j;
                }
            }

            int biggestNumber = array[index];
            array[index] = array[i];
            array[i] = biggestNumber;
            sortedArray[i] = biggestNumber;
        }

        return sortedArray;
    }


    public static int[] getIntegers(int number) {
        System.out.println("type in " + number + " numbers to fill in Array");
        int[] newArray = new int[number];

        for (int i = 0; i < number; i++) {
            newArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return newArray;

    }

    public static int[] randomFillArray(int number){
        System.out.println("there will be " + number + "elements in Array");
        int[] newArray = new int[number];

        for (int i = 0; i < number ; i++) {
            newArray[i] = (int) (Math.random()*number) +1;
        }

        return newArray;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("element #" + i + " is " + array[i]);
        }
    }
}
