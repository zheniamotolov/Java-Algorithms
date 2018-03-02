package InterpolationSearch;

/**
 * Created by eugene on 10/13/17.
 */
public class InterpolationSearch {
    int mid;

    public int interpolationSearch(int[] array, int arrayLength, int numberToFind) {
        return recursiveInterpolationSearch(array, 0, arrayLength - 1, numberToFind);
    }

    public int recursiveInterpolationSearch(int[] array, int downBorder, int upperBorder, int numberToFind) {


        while (array[downBorder] < numberToFind && array[upperBorder] > numberToFind) {

            //{0+(3-0)*()
            mid = downBorder + (  (upperBorder - downBorder) / (array[upperBorder] - array[downBorder]))*(numberToFind - array[downBorder]);
            if (array[mid] < numberToFind) {
                downBorder = mid + 1;
                recursiveInterpolationSearch(array, downBorder, upperBorder, numberToFind);

            } else if (array[mid] > numberToFind) {
                upperBorder = mid - 1;
                recursiveInterpolationSearch(array, downBorder, upperBorder, numberToFind);
            } else {
                return mid;
            }
        }
        if (array[downBorder] == numberToFind) {
            return downBorder;
        } else if (array[upperBorder] == numberToFind) {
            return upperBorder;
        } else {
            return -1;
        }
 }
 /*
  int find(int data) {
   int lo = 0;
   int hi = MAX - 1;
   int mid = -1;
   int comparisons = 1;
   int index = -1;

   while(lo <= hi) {
      printf("\nComparison %d  \n" , comparisons ) ;
      printf("lo : %d, list[%d] = %d\n", lo, lo, list[lo]);
      printf("hi : %d, list[%d] = %d\n", hi, hi, list[hi]);

      comparisons++;

      // probe the mid point
      mid = lo + (((double)(hi - lo) / (list[hi] - list[lo])) * (data - list[lo]));
      printf("mid = %d\n",mid);

      // data found
      if(list[mid] == data) {
         index = mid;
         break;
      } else {
         if(list[mid] < data) {
            // if data is larger, data is in upper half
            lo = mid + 1;
         } else {
            // if data is smaller, data is in lower half
            hi = mid - 1;
         }
      }
   }

   printf("\nTotal comparisons made: %d", --comparisons);
   return index;
}*/
}