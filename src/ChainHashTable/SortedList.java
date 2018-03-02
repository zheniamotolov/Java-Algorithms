package ChainHashTable;

/**
 * Created by eugene on 10/24/17.
 */
class SortedList {

    private ChainHashTableItem first;           // Ссылка на первый элемент списка


    public void SortedList()          // Конструктор
    {
        first = null;
    }


    public void insert(ChainHashTableItem theLink)  // Вставка в порядке сортировки
    {
        int key = theLink.getKey();
        ChainHashTableItem previous = null;          // Начиная с первого элемента
        ChainHashTableItem current = first;
        // До конца списка
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            first = theLink;
        else
            previous.setNext(theLink);
        theLink.setNext(current);

    }
    public void delete(int key) {
        ChainHashTableItem previous = null;
        ChainHashTableItem current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            first = first.getNext();

        else
            previous.setNext(current.getNext()); // удалить текущий элемент
    }  // end delete()


    public ChainHashTableItem find(int key) {
// Поиск элемента с заданным ключом
        ChainHashTableItem current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key)
                return current;
            current = current.getNext();
        }
        return null;

    }
    public void displayList() {
        System.out.print("-> ");
        ChainHashTableItem current = first;
        while (current != null) {
            System.out.print(current.getKey()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}

