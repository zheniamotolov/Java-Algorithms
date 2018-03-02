package SearchDepthComparison;

/**
 * Created by eugene on 10/12/17.
 */
public class RecursiveBinarySearch {
    //private int currentElement;
    private int depthCounter;



    RecursiveBinarySearch() {
        depthCounter = 0;
    }

    //    public int recursiveBinarySearch(int[] array, int downBorder, int upperBorder, int numberToFind) {
//       ++depthCounter;
//        currentElement = (upperBorder - downBorder) / 2 + downBorder;
//        if (downBorder > upperBorder) {
//            return -1;
//        }
//        if (array[currentElement] == numberToFind) {
//            return currentElement;
//        }
//
//        if (numberToFind > array[currentElement]) {
//            downBorder = currentElement + 1;
//            return recursiveBinarySearch(array, downBorder, upperBorder, numberToFind);
//
//        } else {
//            upperBorder = currentElement - 1;
//            return recursiveBinarySearch(array, downBorder, upperBorder, numberToFind);
//        }
//
//    }
    public int recursiveBinarySearch(int[] array, int downBorder, int upperBorder, int numberToFind) {
        ++depthCounter;
        if (upperBorder >= 1) {
            int mid = (upperBorder - downBorder) / 2 + downBorder;
            if (array[mid] == numberToFind)
                return mid;
            if (numberToFind < array[mid]) {
                return recursiveBinarySearch(array, downBorder, mid - 1, numberToFind);

            }
            return recursiveBinarySearch(array, mid + 1, upperBorder, numberToFind);
        }
        return -1;
    }
    public int getDepthCounter() {
        int temp=depthCounter;
        depthCounter=0;
        return temp;

    }
}