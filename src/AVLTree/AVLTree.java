package AVLTree;


import java.util.Stack;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by eugene on 10/16/17.
 */
public class AVLTree {


    private Node root;
    private Node p;
    private int key;

    public Node getRoot() {
        return root;
    }// first node of BinaryTree

    public AVLTree()                  // Конструктор
    {
        root = null;
    }            // Пока нет ни одного узла

    public byte height(Node p) {
        if (p != null) {
            return p.height;
        } else {
            return 0;
        }
    }

    public int bfactor(Node p) {
        return height(p.rightChild) - height(p.leftChild);
    }

    public void fixheight(Node p) {
        byte leftNodeHeight = height(p.leftChild);
        byte rightNodeHeight = height(p.rightChild);
        p.height = (byte) (((leftNodeHeight > rightNodeHeight) ? leftNodeHeight : rightNodeHeight) + 1);
    }

    public Node rotateRight(Node p) {
        Node q = p.leftChild;
        p.leftChild = q.rightChild;
        q.rightChild = p;
        fixheight(p);
        fixheight(q);
        return q;
    }

    public Node rotateLeft(Node q) {
        Node p = q.rightChild;
        q.rightChild = p.leftChild;
        p.leftChild = q;
        fixheight(q);
        fixheight(p);
        return p;
    }

    Node balance(Node p) // балансировка узла p
    {
        fixheight(p);
        if (bfactor(p) == 2) {
            if (bfactor(p.rightChild) < 0)
                p.rightChild = rotateRight(p.rightChild);
            return rotateLeft(p);
        }
        if (bfactor(p) == -2) {
            if (bfactor(p.leftChild) > 0)
                p.leftChild = rotateLeft(p.leftChild);
            return rotateRight(p);
        }
        return p; // балансировка не нужна
    }

    //    node* insert(node* p, int k) // вставка ключа k в дерево с корнем p
//    {
//        if( !p ) return new node(k);
//        if( k<p->key )
//            p->left = insert(p->left,k);
//        else
//            p->right = insert(p->right,k);
//        return balance(p);
//    }
    public Node insert(Node p, int key) {
        if (root == null) {
            root = new Node(key);
            return null;
        }
        if (p == null) {
            return new Node(key);

        } // Корневой узел не существует

        if (key < p.key) {
            p.leftChild = insert(p.leftChild, key);

        } else {
            p.rightChild = insert(p.rightChild, key);
            //    50
            //   25     75
            // 12   37
            //30   33 43
        }
        root = balance(p);
        return root;
    }

    public Node find(int key) // Поиск узла с заданным ключом
    // (предполагается, что дерево не пустое)
    {
        Node current = root;     // Начать с корневого узла
        while (current.key != key)  // Пока не найдено совпадение
        {
            if (key < current.key) // Двигаться налево?
                current = current.leftChild;
            else        // Или направо?
                current = current.rightChild;
            if (current == null)     // поиск завершился неудачей
                return null;
        }
        return current;
    }

    Node findmin(Node p) // поиск узла с минимальным ключом в дереве p
    {
        if (p.leftChild != null) {
            return findmin(p.leftChild);
        } else {
            return p;
        }
//        return p.leftChild?findmin(p->left):p;
    }

    Node removemin(Node p) // удаление узла с минимальным ключом из дерева p
    {
        if (p.leftChild == null)
            return p.rightChild;
        p.leftChild = removemin(p.leftChild);
        root = balance(p);
        return root;
    }

    Node remove(Node p, int k) // удаление ключа k из дерева p
    {
        if (p == null) {
            return null;
        } ;
        if (k < p.key)
            p.leftChild = remove(p.leftChild, k);
        else if (k > p.key)
            p.rightChild = remove(p.rightChild, k);
        else //  k == p->key
        {
            Node q = p.leftChild;
            Node r = p.rightChild;
            p=null;
            if (r==null) return q;
            Node min = findmin(r);
            min.rightChild = removemin(r);
            min.leftChild = q;
            return balance(min);
        }
        root=balance(p);
        return root;
    }


    public boolean delete(int key) // Удаление узла с заданным ключом
    { // (предполагается, что дерево не пусто)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.key != key)// Поиск узла
        {
            parent = current;
            if (key < current.key) // Двигаться налево?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)             // Конец цепочки
                return false;                // Узел не найден
        }
// Удаляемый узел найден
// Если узел не имеет потомков, он просто удаляется.
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)        // Если узел является корневым,
                root = null;  // дерево очищается
            else if (isLeftChild)    // Узел отсоединяется
                // от родителя
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }


// Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
// Если нет левого потомка, узел заменяется правым поддеревом
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else  // Два потомка, узел заменяется преемником
        {
            Node successor = getSuccessor(current);
            // Родитель current связывается с посредником
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // Преемник связывается с левым потомком current
            // Признак успешного завершения
        }
        return true;
    }

    // Метод возвращает узел со следующим значением после delNode.
    // Для этого он сначала переходит к правому потомку, а затем
    // отслеживает цепочку левых потомков этого узла.
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
// Переход к правому потомку
// Пока остаются левые потомки
// Переход к левому потомку
        // Если преемник не является
        if (successor != delNode.rightChild)  // правым потомком,
        {                                 // создать связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.key + " ");
        }
    }

    public void displayBinaryTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                "......................................................");
    }
}
