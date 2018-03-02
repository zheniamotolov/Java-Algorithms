package ChoosingSort;

/**
 * Created by eugene on 10/7/17.
 */
//каждой итерации ищем самого низкого и вставляем в начало
public class ChoosingSort {
    public int [] selectionSort(int array[],int arrayLength) {
        int out, in, min;
        for (out = 0; out < arrayLength; out++) {
            min = out;
            for (in = out + 1; in < arrayLength; in++) // Внутренний цикл
                if (array[in] < array[min])
                    min = in;
            swap(out, min,array);
        }
        return array;
    }
    private void swap(int a,int b,int array[]){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
