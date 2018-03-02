package AVLTree;

import BinaryTree.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eugene on 10/16/17.
 */
public class AVLTreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        AVLTree tree = new AVLTree();
        tree.insert(tree.getRoot(), 50);
        tree.insert(tree.getRoot(), 25);
        tree.insert(tree.getRoot(), 75);
        tree.insert(tree.getRoot(), 12);
        tree.insert(tree.getRoot(), 37);
        tree.insert(tree.getRoot(), 43);
        tree.insert(tree.getRoot(), 30);
        tree.insert(tree.getRoot(), 33);
        tree.insert(tree.getRoot(), 87);
        tree.insert(tree.getRoot(), 93);
        tree.insert(tree.getRoot(), 97);
        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    tree.displayBinaryTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(tree.getRoot(), value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
                case 'd':
                    System.out.println("Enter key to delete node ");
                    value = getInt();
                    if (tree.delete(value)) {
                        System.out.println("element succesfully deleted");
                    }
                    else{
                    System.out.println("elemnt not found");
                }
                case 't':
                    System.out.println("Enter type of traverse ");
                    value = getInt();
                    tree.traverse(value);
                case 'r':
                    System.out.println("Enter key of node to remove ");
                    value = getInt();
                   tree.remove(tree.getRoot(),value);
            }

        }
    }


// -------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
