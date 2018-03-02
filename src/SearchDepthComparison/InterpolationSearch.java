package SearchDepthComparison;

/**
 * Created by eugene on 10/13/17.
 */
public class InterpolationSearch {


    public int getDepthCounter() {
        int temp = depthCounter;
        depthCounter = 0;
        return temp;
    }

    int depthCounter;

    InterpolationSearch() {
        depthCounter = 0;
    }

    public int interpolationSearch(int[] array, int arrayLength, int numberToFind) {
        return recursiveInterpolationSearch(array, 0, arrayLength - 1, numberToFind);
    }

    public int recursiveInterpolationSearch(int[] array, int downBorder, int upperBorder, int numberToFind) {
        ++depthCounter;
        if (array[downBorder] == numberToFind) return downBorder;
        else if (downBorder == upperBorder || array[downBorder] == array[upperBorder]) return -1;
        int index = downBorder + ((upperBorder - downBorder) / (array[upperBorder] - array[downBorder]) * (numberToFind - array[downBorder]));
        if (array[index] == numberToFind) return index;
        else if (array[index] < numberToFind)
            return recursiveInterpolationSearch(array, index + 1, upperBorder, numberToFind);
        else return recursiveInterpolationSearch(array, downBorder, index - 1, numberToFind);

    }
}