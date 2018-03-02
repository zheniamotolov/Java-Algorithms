package DoubleHashAdressTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eugene on 10/22/17.
 */
public class DoubleHashTableApp {
    public static void main(String[] args) throws IOException {
        {
            int aKey;
            HashTableItem aDataItem;
            int size, n;
            // Ввод размеров
            System.out.print("Enter size of hash table: ");
            size = getInt();
            System.out.print("Enter initial number of items: ");
            n = getInt();
// Создание таблицы
            DoubleHashTable theHashTable = new DoubleHashTable(size);
            for (int j = 0; j < n; j++)      // Вставка данных
            {
                aKey = (int) (java.lang.Math.random() * 2 * size);
                aDataItem = new HashTableItem(aKey);
               if(! theHashTable.insert(aKey, aDataItem)){
                   int newArrayDemention = theHashTable.nextPrime(size);

                   DoubleHashTable doubleHashTablenew = new DoubleHashTable(newArrayDemention);

                   for (HashTableItem hashTableItem : theHashTable.getHashArray()) {
                       if(hashTableItem!=null){
                           doubleHashTablenew.insert(hashTableItem.getKey(), hashTableItem);
                       }

                   }
                   theHashTable = doubleHashTablenew;
                   theHashTable.insert(aKey, aDataItem);
               };
            }
            while (true)                 // Взаимодействие с пользователем
            {
                System.out.print("Enter first letter of ");
                System.out.print("show, insert, delete, or find: ");
                char choice = getChar();
                switch (choice) {
                    case 's':
                        theHashTable.displayTable();
                        break;
                    case 'i':
                        System.out.print("Enter key value to insert: ");
                        aKey = getInt();
                        aDataItem = new HashTableItem(aKey);
                        if (!theHashTable.insert(aKey, aDataItem)) {
                            int newArrayDemention = theHashTable.nextPrime(size);

                            DoubleHashTable doubleHashTablenew = new DoubleHashTable(newArrayDemention);

                            for (HashTableItem hashTableItem : theHashTable.getHashArray()) {
                                if(hashTableItem!=null){
                                    doubleHashTablenew.insert(hashTableItem.getKey(), hashTableItem);
                                }

                            }
                            theHashTable = doubleHashTablenew;
                            theHashTable.insert(aKey, aDataItem);
                        }

                        break;
                    case 'd':
                        System.out.print("Enter key value to delete: ");
                        aKey = getInt();
                        theHashTable.delete(aKey);
                        break;
                    case 'f':
                        System.out.print("Enter key value to find: ");
                        aKey = getInt();
                        aDataItem = theHashTable.find(aKey);
                        if (aDataItem != null)
                            System.out.println("Found " + aKey);
                        else
                            System.out.println("Could not find " + aKey);
                        break;
                    default:
                        System.out.print("Invalid entry\n");
                }
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }


    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
