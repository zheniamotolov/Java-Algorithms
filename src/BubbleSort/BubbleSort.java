package BubbleSort;

/**
 * Created by eugene on 10/3/17.
 */
public class BubbleSort {
    public int[] bubbleSort(int array[], int arrayLength){
        for(int i=arrayLength-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j+1]<array[j]){
                    array[j+1]+=array[j];
                    array[j]=array[j+1]-array[j];
                    array[j+1]-=array[j];
                }
            }
        }
        return array;
    }
}
