package ChainHashTable;

import DoubleHashAdressTable.HashTableItem;

/**
 * Created by eugene on 10/22/17.
 */
public class ChainHashTable {
    private SortedList[] hashArray;
    private int arraySize;

    ChainHashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];  // Создание массива
        for (int j = 0; j < arraySize; j++)          // Заполнение массива
            hashArray[j] = new SortedList();     // списками
    }
    public void displayTable()
    {
        for(int j=0; j<arraySize; j++) // Для каждой ячейки
        {
            System.out.print(j + ". "); // Вывод номера ячейки
            hashArray[j].displayList(); // Вывод списка
        }
    }
    public int hashFunc(int key)      // Хеш-функция
    {
        return key % arraySize;
    }
    public void delete(int key)       // Удаление элемента
    {
        int hashVal = hashFunc(key);   // Хеширование ключа
        hashArray[hashVal].delete(key); // Удаление
    }
    public ChainHashTableItem find(int key){
        int index=hashFunc(key);
        return hashArray[index].find(key);
    }
    public void insert(ChainHashTableItem theLink)  // Вставка элемента
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);   // Хеширование ключа
        hashArray[hashVal].insert(theLink); // Вставка в позиции hashVal
    }
}
