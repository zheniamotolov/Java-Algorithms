package AVLTree;

/**
 * Created by eugene on 10/15/17.
 */

class Node {
    public int key; // Данные, используемые в качестве ключа
    //    public double dData; // Другие данные
    public Node leftChild; // Левый потомок узла
    public Node rightChild;// Правый потомок узла
    public byte height;

    Node() {
        height = 1;
        leftChild=null;
        rightChild=null;
    }

    Node(int key) {
        this.key= key;
        height=1;
        leftChild=null;
        rightChild=null;
    }

    public void displayNode() // Вывод узла
    {
        System.out.print('{');
        System.out.print(key);
//        System.out.print(", ");
//        System.out.print(dData);
        System.out.print("} ");
    }


}

