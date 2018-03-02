package ElegantBinaryTree;

/**
 * Created by eugene on 11/9/17.
 */
public class Node {
    Node leftNode;
    Node rightNode;
    int data;

    public int getData() {
        return data;
    }

    Node(int data) {
        this.data = data;
    }

    //insert find show
    void insert(int newData) {
        if (newData < data) {
            if (leftNode != null) {
                insert(newData);
            } else {
                leftNode = new Node(newData);
            }
        } else if (newData > data) {
            if (rightNode != null) {
                insert(newData);
            } else {
                rightNode = new Node(newData);
            }
        }
    }

    boolean find(int dataToFind) {
        if (dataToFind == data) {
            return true;
        } else if (dataToFind < data) {
            if (leftNode != null) {
                return leftNode.find(dataToFind);
            } else {
                return false;
            }
        } else {
            if (rightNode != null) {
                return rightNode.find(dataToFind);
            } else {
                return false;
            }
        }
    }
    /*
       boolean find(Node node, int dataToFind) {
        if (node == null) {
            return false;
        } else {
            if (dataToFind == data) {
                return true;
            } else {
                if (dataToFind < data) {
                    return find(leftNode, dataToFind);
                } else {
                    return find(rightNode, dataToFind);

                }
            }
        }*/

    void show() {
//        int temp=data;
        if (leftNode != null) {
            leftNode.show();
        }

        System.out.println(leftNode.data);
        if (rightNode != null) {
            rightNode.show();
        }
    }
    boolean check() {
        int temp=data;
        if (leftNode != null) {
            if(temp>leftNode.data){
                return false;
            }
          return leftNode.check();
        }
        if (rightNode != null) {
            if(temp<rightNode.data){
                return false;
            }
            return rightNode.check();
        }
        return true;

//        if (rightNode != null) {
//            rightNode.check();
//        }
    }
}

