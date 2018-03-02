package HubridSort;

/**
 * Created by eugene on 9/25/17.
 */
public class QuickSort {
    private int[] unsortedArray;
    private int numberOfElementsInArray;
    public QuickSort() {
    }
    public void display()
    {
        for (int j = 0; j < numberOfElementsInArray; j++)  {
            System.out.println(unsortedArray[j] + " "); }

    }
    public void quickSort(int[] unsortedArray,int numberOfElementsInArray) {
        this.unsortedArray = unsortedArray;
        this.numberOfElementsInArray = numberOfElementsInArray;
        recQuickSort(0, numberOfElementsInArray - 1);
    }
    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else
        {
            int median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }
    public int medianOf3(int left, int right) {
        int center = (left + right) / 2;
        // Упорядочение left и center
        if (unsortedArray[left] > unsortedArray[center])
            swap(left, center);
        // Упорядочение left и right
        if (unsortedArray[left] > unsortedArray[right])
            swap(left, right);
        if (unsortedArray[center] > unsortedArray[right])
            swap(center, right);
        swap(center, right - 1);
        return unsortedArray[right - 1];
    }
    public void swap(int dex1, int dex2)
    {
        int temp = unsortedArray[dex1];
        unsortedArray[dex1] = unsortedArray[dex2];
        unsortedArray[dex2] = temp;
    }
    public int partitionIt(int left, int right, int pivot)
    {
        int leftPtr = left;
        int rightPtr = right - 1;
        while(true)
        {
            while( unsortedArray[++leftPtr] < pivot )
                ;
            while( unsortedArray[--rightPtr] > pivot )
                ;
            if(leftPtr >= rightPtr){
                break;
            }
            else{
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right-1);
        return leftPtr;
    }

    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (unsortedArray[left] > unsortedArray[right])
                swap(left, right);
            return;
        } else
        {
            if (unsortedArray[left] > unsortedArray[right - 1])
            swap(left, right - 1);
            if (unsortedArray[left] > unsortedArray[right])
                swap(left, right);
            if (unsortedArray[right - 1] > unsortedArray[right])
                swap(right - 1, right);

        }
    }
}
