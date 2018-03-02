package BinarySearch;


public class BinarySearchNotRecursive {

    public int binarySearach(int[] array, int arrayLength, int numberToFind) {
        int upperBorder = arrayLength - 1;
        int currentElement = 0;
        int downBorder = 0;

        while (true) {
            currentElement = (upperBorder-downBorder)/2 + downBorder;
            if (array[currentElement] == numberToFind) {
                return currentElement;
            } else if (downBorder >  upperBorder) {
                return -1;
            } else {
                if (numberToFind > array[currentElement]) {
                    downBorder = currentElement + 1;

                } else {
                      upperBorder = currentElement - 1;

                }
            }
        }
    }
}
//0,1,2
//12 23 44