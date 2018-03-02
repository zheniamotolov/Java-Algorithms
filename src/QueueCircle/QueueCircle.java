package QueueCircle;

/**
 * Created by eugene on 10/7/17.
 */
//front - lower bound, rear - apper bound
public class QueueCircle {

        private int maxSize;
        private long[] queArray;
        private int front;
        private int rear;
        private int nItems;

//--------------------------------------------------------------
   public QueueCircle(int s)          // Конструктор
        {
            maxSize = s;
            queArray = new long[maxSize];
            front = 0;
            rear = -1;
            nItems = 0;
        }
//--------------------------------------------------------------
    public void insert(long j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
// Вставка элемента в конец очереди
        // Циклический перенос
        // Увеличение rear и вставка
        // Увеличение количества элементов
    }
    //--------------------------------------------------------------
    public long remove()         // Извлечение элемента в начале очереди
    {
        long temp = queArray[front++]; // Выборка и увеличение front
        if(front == maxSize)           // Циклический перенос
            front = 0;
        nItems--;                      // Уменьшение количества элементов
        return temp;
    }
    //--------------------------------------------------------------
    public long peekFront()      // Чтение элемента в начале очереди
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true, если очередь пуста
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull()
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size()           // Количество элементов в очереди
    {
        return nItems;
    }// true, если очередь заполнена
}
