package HubridSort;

/**
 * Created by eugene on 9/25/17.
 */
public class InsertionSort {
    private int[] unsortedArray;
    private int numberOfElementsInArray;
    public InsertionSort() {

    }
    public void display()
    {
        for(int j=0; j<numberOfElementsInArray; j++){
            System.out.println(unsortedArray[j] + " ");}
    }
    public void insertionSort(int[] unsortedArray,int numberOfElementsInArray)
    {
        this.unsortedArray = unsortedArray;
        this.numberOfElementsInArray = numberOfElementsInArray;
        int in, out;
        for(out=1; out<numberOfElementsInArray; out++)
        {
            int temp = unsortedArray[out];
            in = out;
            while(in>0 && unsortedArray[in-1] >= temp)
            {
                unsortedArray[in] = unsortedArray[in-1];
                --in;
            }

            unsortedArray[in] = temp;
        } }
}

