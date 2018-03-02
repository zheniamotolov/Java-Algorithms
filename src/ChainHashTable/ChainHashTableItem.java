package ChainHashTable;

/**
 * Created by eugene on 10/22/17.
 */
public class ChainHashTableItem {
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private int key;

    public ChainHashTableItem getNext() {
        return next;
    }

    public void setNext(ChainHashTableItem next) {
        this.next = next;
    }

    private ChainHashTableItem next;
    ChainHashTableItem(int key) {
        this.key=key;
    }
}
