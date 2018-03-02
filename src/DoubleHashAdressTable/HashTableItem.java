package DoubleHashAdressTable;

/**
 * Created by eugene on 10/22/17.
 */
public class   HashTableItem {
    private int iData;                // Данные (ключ)

    public HashTableItem(int ii)           // Конструктор
    { iData = ii; }

    public int getKey()
    { return iData; }
}
