package BFS;

/**
 * Created by eugene on 10/24/17.
 */
public class Queue {
    private int SIZE = 10;
    private int head;
    private int itemCount;
    private int tale;
    private int array[];

    Queue() {
         array = new int[SIZE];
        head = 0;//front
        tale = -1;//rear

        itemCount = 0;
    }

    public boolean isEmpty() {
        if (itemCount == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return itemCount == SIZE - 1;
    }

    public void insert(int num) {
        if (isFull()) {
            return;
        }
        if (tale == SIZE - 1) {
            tale = -1;
        }
        array[++tale] = num;
        itemCount++;
    }

    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int temp = array[head++];
        if (head == SIZE - 1) {
            head = 0;
        }
        itemCount--;
        return temp;
    }
}
