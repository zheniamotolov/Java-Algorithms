//package HubridSort;
//
//import java.util.Date;
//
///**
// * Created by eugene on 9/26/17.
// */
//public class TransitionNumberFinder {
//    private int transitionNumber;
//    private RandomDataGenerator randomDataGenerator;
//    private QuickSort quickSort;
//    private InsertionSort insertionSort;
//    private int allArrays[][];
//    private int NUMBER_OF_ELEMENTS_IN_ARRAY = 1000;
//    private int NUMBER_OF_ARRAYS = 100000;
//
//    TransitionNumberFinder() {
//        quickSort = new QuickSort();
//        insertionSort = new InsertionSort();
//        randomDataGenerator = new RandomDataGenerator();
//        randomDataGenerator.writeRandomArraysToFile();
//        randomDataGenerator.readFromFile();
//        allArrays = randomDataGenerator.getAllArrays();
//        transitionNumber = 10;
//    }
//
//    public int getTransitionNumber() {
//        return transitionNumber;
//    }
//
//    private long getTimeOfWorkingQuickSort() {
//        Date quickSortStartTime = new Date();
//        for (int i = 0; i < NUMBER_OF_ARRAYS; i++) {
//            quickSort.quickSort(allArrays[i], transitionNumber);
//        }
//        Date quickSortFinishTime = new Date();
//        System.out.print("quick-");
//        System.out.println(quickSortFinishTime.getTime() - quickSortStartTime.getTime());
//        return quickSortFinishTime.getTime() - quickSortStartTime.getTime();
//    }
//    private long getTimeOfWorkingInsertionSort() {
//        Date insertionSortStartTime = new Date();
//        for (int i = 0; i < NUMBER_OF_ARRAYS; i++) {
//            insertionSort.insertionSort(allArrays[i], transitionNumber);
//        }
//        Date insertionSortFinishTime = new Date();
//        System.out.print("insertion-");
//        System.out.println(insertionSortFinishTime.getTime() - insertionSortStartTime.getTime());
//        return insertionSortFinishTime.getTime() - insertionSortStartTime.getTime();
//    }
//
//    public int findTransitionNumber(int tempTransitionNumber) {
//        while ( getTimeOfWorkingQuickSort()-getTimeOfWorkingInsertionSort()  > 0) {
//          tempTransitionNumber++;
//            //System.out.println("908098098098098");
//        }
//       // System.out.println(transitionNumber);
//        return tempTransitionNumber;
//    }
//
//    public void findAverageTransitionNumber() {
//        int averageSum = 0;
//        int i = 0;
//        for (; i < 50; i++) {
//            averageSum += findTransitionNumber(transitionNumber);
//
//        }
//        //transitionNumber = averageSum / i;
//        System.out.println(averageSum / i);
//    }
//}
