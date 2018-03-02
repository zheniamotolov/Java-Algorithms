package HubridSort;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import MergeSort.MergeSort;

/**
 * Created by eugene on 9/25/17.
 */
public class RandomDataGenerator {
    private int randomArrayLength;
    private int amountOfArrays;
    private int maxElementValue;
    private int[] array;
    private File file;
    Random rand;

    public RandomDataGenerator(int arrayLength, int amountOfArrays, int maxElementValue) {
        randomArrayLength = arrayLength;
        array = new int[arrayLength];
        rand = new Random();
        this.amountOfArrays = amountOfArrays;
        this.maxElementValue = maxElementValue;
    }

    public void writeArraysToFile() {
        for (int i = 1; i <= amountOfArrays; i++) {
            writeRandomArrayToFile(new File("src/data2/arrayNumber" + i + ".txt"));
        }
    }

    public void writeSortedArraysToFile() {
        for (int i = 1; i <= amountOfArrays; i++) {
            createSortedArray();
            writeSortedRandomArrayToFile(new File("src/data2/arrayNumber" + i + ".txt"));
        }
    }

    private void createSortedArray() {
        for (int i = 0; i < randomArrayLength; i++) {
            array[i] = getRandomNumber();
        }
        sortArray();
    }

    private void sortArray() {
        MergeSort mergeSort = new MergeSort();
        array = mergeSort.mergeSort(array, randomArrayLength);
    }

    //    private void writeSortedRandomArrayToFile(File file) {
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            for (int i = 0; i < randomArrayLength; i++) {
//                if (i == 0) {
//                    fileWriter.write( String.valueOf(array[i]));
//                    continue;
//                }
//
//                fileWriter.write("," + array[i]);
//            }
//        } catch (IOException e) {
//            System.err.println("ошибка открытия потока " + e);
//        }
//    }
    private void writeSortedRandomArrayToFile(File file) {
        try (PrintWriter fileWriter = new PrintWriter(file)) {
            for (int i = 0; i < randomArrayLength; i++) {
                if (i == 0) {
                    fileWriter.println(String.valueOf(array[i]));

                    continue;
                }

                fileWriter.println(array[i]);

            }
        } catch (IOException e) {
            System.err.println("ошибка открытия потока " + e);
        }
    }

    private void writeRandomArrayToFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < randomArrayLength; i++) {
                if (i == 0) {
                    fileWriter.write(String.valueOf(array[i]));
                    continue;
                }
                fileWriter.write("," + getRandomNumber());
            }
        } catch (IOException e) {
            System.err.println("ошибка открытия потока " + e);
        }
    }

//    public int[][] getAllArrays() {
//        return allArrays;
//    }

    //    public int[] readFromFile(File file) {
//        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
//            String tmp = bufferReader.readLine();
//            String[] s = tmp.split(",");
//            array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
////            for(int i=0;i<s.length;i++){
////                array[i]=Integer.parseInt(s[i]);
////            }
//            return array;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
    public int[] readFromFile(File file) {
        try (Scanner input = new Scanner(file)) {
//        String tmp = bufferReader.readLine();
//        String[] s = tmp.split(",");
            int i = 0;
            while (input.hasNext()) {
                 array[i] = input.nextInt();
                i++;
            }
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private int getRandomNumber() {
        return rand.nextInt(maxElementValue);
    }
}

