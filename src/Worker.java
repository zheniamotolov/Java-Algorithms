import BinarySearch.BinarySearchNotRecursive;
import InterpolationSearch.InterpolationSearch;
import RecursiveBinarySearch.RecursiveBinarySearch;

import java.util.concurrent.RecursiveAction;

/**
 * Created by eugene on 10/3/17.
 */
public class Worker {
    public static void main(String[] args) {
       int array[] = { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59};
//        InsertionSort insertionSort=new InsertionSort();
//
//        System.out.println(Arrays.toString(insertionSort.insertionsort(array,array.length)));

        InterpolationSearch interpolationSearch =new InterpolationSearch();
        System.out.println(interpolationSearch.interpolationSearch(array,array.length,23));
//        Object k=null;
//        if(!k){
//            System.out.println("lol");
//        }


    }
}
