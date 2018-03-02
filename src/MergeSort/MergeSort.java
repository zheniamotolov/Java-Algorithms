package MergeSort;

/**
 * Created by eugene on 10/11/17.
 */
public class MergeSort {
    private int []array;
    public int[] mergeSort(int []array,int arrayLength )           // Вызывается из main()
    {                              // Рабочая область
        this.array=array;
        int[] workSpace = new int[arrayLength];
        recMergeSort(workSpace, 0, arrayLength-1);
        return array;
    }
    //-----------------------------------------------------------
    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)
            return;
        else
        {
            int mid = (lowerBound+upperBound) / 2;
            // Сортировка нижней половины
            recMergeSort(workSpace, lowerBound, mid);
            // Сортировка верхней половины
            recMergeSort(workSpace, mid+1, upperBound);
            // Слияние
            merge(workSpace, lowerBound, mid+1, upperBound);
        } }
    //-----------------------------------------------------------
    private void merge(int[] workSpace, int lowPtr,int highPtr, int upperBound)
    {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1;

        // Индекс в рабочей области
        // Количество элементов
        while(lowPtr <= mid && highPtr <= upperBound)
            if( array[lowPtr] < array[highPtr] )
                workSpace[j++] = array[lowPtr++];
            else            workSpace[j++] = array[highPtr++];
        while(lowPtr <= mid)
            workSpace[j++] = array[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = array[highPtr++];
        for(j=0; j<n; j++)
            array[lowerBound+j] = workSpace[j];
    }
//-------------
}
