package DoubleHashAdressTable;

/**
 * Created by eugene on 10/22/17.
 */
public class DoubleHashTable {

    public void setHashArray(HashTableItem[] hashArray) {
        this.hashArray = hashArray;
    }

    private HashTableItem[] hashArray;
    private int arraySize;
    private HashTableItem nonItem;

    public int getNumOfElemnts() {
        return numOfElemnts;
    }

    private int numOfElemnts;

    public HashTableItem[] getHashArray() {
        return hashArray;
    }

    DoubleHashTable(int size)               // Конструктор
    {
        arraySize = size;
        hashArray = new HashTableItem[arraySize];  // Размер массива должен быть простым по отношению к 5, 4, 3 и 2
        nonItem = new HashTableItem(-1);
        numOfElemnts = 0;
    }

    private void hashTableExtend() {

    }

    public int nextPrime(int n) {
        n += n;
        for (int i = 0; true; i++) {
            if (isPrime(n += i)) {
                return n;
            }
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.println(hashArray[j].getKey() + " ");
            else
                System.out.println("** ");
        }
        System.out.println("");
    }

    private int hashFunc1(int key) {
        return key % arraySize;
    }

    private int hashFunc2(int key) {

        return 5 - key % 5;
    }

    public boolean insert(int key, HashTableItem item)
    {
        int hashVal = hashFunc1(key);  // Хеширование ключа
        int stepSize = hashFunc2(key); // Вычисление смещения
        // Пока не будет найдена
        if (numOfElemnts >= (arraySize * 0.75)) {
            return false;
        }
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)    // пустая ячейка или -1 (Метод предполагает, что таблица не заполнена)
        {
            hashVal += stepSize;// Прибавление смещения
            hashVal %= arraySize;// Возврат к началу
        }
        hashArray[hashVal] = item;// Вставка элемента
        numOfElemnts++;
        return true;

    }

    public HashTableItem delete(int key) {
        int hashVal = hashFunc1(key);      // Хеширование ключа
        int stepSize = hashFunc2(key);    // Вычисление смещения
        while (hashArray[hashVal] != null)  // Пока не найдена пустая ячейка
        {                               // Ключ найден?
            if (hashArray[hashVal].getKey() == key) {
                HashTableItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem;       // Удаление элемента
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public HashTableItem find(int key) {
        int hashVal = hashFunc1(key);      // Хеширование ключа
        int stepSize = hashFunc2(key);     // Вычисление смещения
        while (hashArray[hashVal] != null)  // Пока не найдена пустая ячейка
        {                               // Ключ найден?
            if (hashArray[hashVal].getKey() == key) {// Да, метод возвращает элемент
                System.out.println(hashVal);
                return hashArray[hashVal];
            }
            hashVal += stepSize;// Прибавление смещения
            hashVal %= arraySize;// Возврат к началу
        }
        return null;// Элемент не найден
    }
}
