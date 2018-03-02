package RecursiveBinarySearch;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by eugene on 10/12/17.
 */
public class RecursiveBinarySearch {
    private int currentElement;




    public int binarySearch(int[] array, int arrayLength, int numberToFind) {
        return recursiveBinarySearch(array, 0, arrayLength - 1, numberToFind);
    }
    public int recursiveBinarySearch(int[] array, int downBorder, int upperBorder, int numberToFind) {

        currentElement = (upperBorder - downBorder) / 2 + downBorder;
        if (downBorder > upperBorder) {
            return -1;
        }
        if (array[currentElement] == numberToFind) {
            return currentElement;
        }

        if (numberToFind > array[currentElement]) {
            downBorder = currentElement + 1;
            return recursiveBinarySearch(array, downBorder, upperBorder, numberToFind);

        } else {
            upperBorder = currentElement - 1;
            return recursiveBinarySearch(array, downBorder, upperBorder, numberToFind);
        }

    }

}
