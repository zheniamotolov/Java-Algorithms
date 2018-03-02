package SearchDepthComparison;

import BinarySearch.BinarySearchNotRecursive;
import HubridSort.RandomDataGenerator;

import java.io.File;
import java.util.Arrays;

/**
 * Created by eugene on 10/14/17.
 */
public class SearchDepthComparison {
    private final static int AMOUNT_OF_ARRAYS = 5;
    private final static int ARRAY_LENGTH = 100_000_000;

    public static void main(String[] args) {

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator(ARRAY_LENGTH, AMOUNT_OF_ARRAYS, 40_000_000);
        //randomDataGenerator.writeSortedArraysToFile();
        searchDepthTable(randomDataGenerator);
    }

    private static void searchDepthTable(RandomDataGenerator randomDataGenerator) {
        int array[];
        System.out.println("Number of array : BinarySearch : InterpolationSearch :Position of element");
        // System.out.println("Array number  BinarySearch InterpolationSearch");
        //  for (int i = 0; i < AMOUNT_OF_ARRAYS; i++) {
        //  array = randomDataGenerator.readFromFile(new File("src/data/arrayNumber" + i + ".txt"));
//            array = randomDataGenerator.readFromFile(new File("src/data/test.txt"));
//            RecursiveBinarySearch recursiveBinarySearch=new RecursiveBinarySearch();
//        System.out.println(recursiveBinarySearch.binarySearch(array,array.length,8));
//        System.out.println(recursiveBinarySearch.getDepthCounter());
//            System.out.println(Arrays.toString(array));
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        RecursiveBinarySearch recursiveBinarySearch = new RecursiveBinarySearch();
//       int []array1={12,34,45,56,67,78,234,256,345,546,657,678,809};
//        System.out.println(recursiveBinarySearch.binarySearch(array1,array1.length,256));
//        for (int i = 1; i <= 1; i++) {
        int b = 0;
        int i = 0;
//        for (int i = 1; i < AMOUNT_OF_ARRAYS; i++) {
//            array = randomDataGenerator.readFromFile(new File("src/data2/arrayNumber" + i + ".txt"));
//            System.out.print(i + "                      ");
//             recursiveBinarySearch.recursiveBinarySearch(array, 0, array.length - 1, 39660);//72576
//            System.out.print(recursiveBinarySearch.getDepthCounter());
//            i = interpolationSearch.interpolationSearch(array, array.length, 39660);
//            System.out.print("                 ");
//            System.out.print(interpolationSearch.getDepthCounter());
//
//            System.out.println();
//        }
    }
}
