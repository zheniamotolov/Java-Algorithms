package Insertionsort;

/**
 * Created by eugene on 10/3/17.
 */
public class InsertionSort {
    public int[] insertionsort(int[] array, int arrayLength) {
        for(int i=1;i<arrayLength;i++)
            for(int j=i;j>0 && array[j-1]>array[j];j--) // пока j>0 и элемент j-1 > j, x-массив int
                swap(j-1,j,array);
        return array;
    }
    private void swap(int a,int b,int array[]){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
