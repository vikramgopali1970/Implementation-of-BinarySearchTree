/** @author
 *  Binary search tree (starter code)
 **/

package vxg180002;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
    static class Entry<T> {
        T element;
        Entry<T> left, right;

        public Entry(T x, Entry<T> left, Entry<T> right) {
            this.element = x;
            this.left = left;
            this.right = right;
        }
    }

    Entry<T> root;
    int size;
    Stack<Entry<T>> stck = new Stack<>();


    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    /**
     * TO DO: Find x in the tree
     * Helper method to find an element x of Object type T, which intern calls another method with required parameters
     * which will return a node containing element x or a node where the method failed to find x as it was not present
     * in the BinarySearchTree.
     *
     * @param   x   a value of object type T to be searched for
     * @return      returns the node at which x was found or failed to be found
     * */
    public Entry<T> find(T x){
        this.stck.push(null);
        return this.find(this.root,x);
    }

    /**
     * TO DO: Find x in the tree
     * Returns the node which contains the element x of Object type T if it is present. In case the element x of Object
     * type T is not present in the BinarySearchTree it will return the node at which the method failed to find the
     * element.
     * As we search through the BinarySearchTree we keep on storing the parent of nodes we travel in a stack.
     *
     * @param   node    root of the BinarySearchTree
     * @param   x       a value of object type T to be searched for
     * @return          returns the node at which x was found or failed to be found
     * */
    public Entry<T> find(Entry<T> node,T x){
        if(node == null || node.element == x){
            return node;
        }
        while(true){
            if (x.compareTo(node.element) < 0){
                if (null == node.left){
                    break;
                }else{
                    this.stck.push(node);
                    node = node.left;
                }
            }else if (x.compareTo(node.element) == 0){
                break;
            }else{
                if(null == node.right){
                    break;
                }else{
                    this.stck.push(node);
                    node = node.right;
                }
            }
        }
        return node;
    }


    /**
     * TO DO: Is x contained in tree?
     * Returns a boolean value true if the element x of Object type T is present
     * int the BinarySearchTree else will return a false.
     *
     * @param   x   a value of object type T that is to checked if contains or not
     * @return      returns boolean value based on whether element x is in the tree or not
     */
    public boolean contains(T x) {
        Entry<T> node = this.find(x);
        if(null == node || node.element.compareTo(x) != 0) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * TO DO: Is there an element that is equal to x in the tree?
     * Returns an element x of object type T if the element is present in the BinarySearchTree or null otherwise.
     *
     * @param   x   a value of object type T
     * @return      element x of object type T if the element is present in the BinarySearchTree else null
     */
    public T get(T x) {
        if(this.contains(x)){
            return x;
        }else{
            return null;
        }
    }


    /**
     * TO DO: Add x to tree.
     * Returns boolean true if the element x of Object Type T was added to the BinarySearchTree, otherwise returns false
     * if the element x is already present by replacing the existing element x in BinarySearchTree.
     *
     * @param   x   a value of Object Type T to be inserted into BinarySearchTree
     * @return      true if new Element is added and false if existing element is replaced
     * */
    public boolean add(T x) {
        if(this.size == 0){
            this.root = new Entry<T>(x,null,null);
            this.size++;
            return true;
        }else{
            Entry<T> node = find(x);
            if(x.compareTo(node.element) == 0){
                node.element = x;
                return false;
            }else{
                if(x.compareTo(node.element) < 0){
                    node.left = new Entry<T>(x,null,null);
                }else{
                    node.right = new Entry<T>(x,null,null);
                }
                this.size++;
                return true;
            }
        }
    }

    /** TO DO: Remove x from tree. 
     * Returns the element x of object type T, if the element x is found in the BinarySearchTree, otherwise returns
     * null.
     *
     * @param   x   a value of Object Type T to be removed from BinarySearchTree
     * @return      element x of object type T if new Element is added and null if element does not exist
     */
    public T remove(T x) {
        if (this.size == 0){
            return null;
        }else{
            Entry<T> node = find(x);
            if(node.element.compareTo(x) != 0){
                return null;
            }
            T removed = node.element;
            if(null == node.left || null == node.right){
                bypass(node);
            }else{
                this.stck.push(node);
                Entry<T> minRight = find(node.right,x);
                node.element = minRight.element;
                bypass(minRight);
            }
            this.size--;
            return removed;
        }
    }

    /** TO DO: Bypass the node to connect node's parent and node's child.
     *
     * @param   node   node that needs to be bypassed in BinarySearchTree
     */
    public void bypass(Entry<T> node){
        Entry<T> parent = this.stck.peek();
        Entry<T> child = (null == node.left)?node.right:node.left;
        if(null == parent){
            this.root = child;
        }else if(parent.left == node){
            parent.left = child;
        }else{
            parent.right = child;
        }
    }

    /**
     *  Returns the minimum element in the BinarySearchTree
     * @return   element x of object type T which is smallest in BinarySearchTree
     */
    public T min() {
        if (this.size == 0){
            return null;
        }
        Entry<T> node = root;
        while(null != node.left){
            node = node.left;
        }
        return node.element;
    }

    /**
     *  Returns the maximum element in the BinarySearchTree
     * @return   element x of object type T which is largest in BinarySearchTree
     */
    public T max() {
        if (this.size == 0){
            return null;
        }
        Entry<T> node = root;
        while(null != node.right){
            node = node.right;
        }
        return node.element;
    }

    //
    /**
     * TODO: Create an array with the elements using in-order traversal of tree
     * returns a comparable array 
     * */
    public Comparable[] toArray() {
        Comparable[] arr = new Comparable[this.size];
        /* write code to place elements in array here */
        Stack<Entry<T>> s = new Stack<>();
        Entry<T> node = this.root;
        int ind = 0;
        while(null != node || s.size()>0){
            while(null != node){
                s.push(node);
                node=node.left;
            }
            node = s.pop();
            arr[ind++] = node.element;
            node=node.right;
        }
        return arr;
    }

// Start of Optional problem 2

    /** Optional problem 2: Iterate elements in sorted order of keys
     Solve this problem without creating an array using in-order traversal (toArray()).
     */
    public Iterator<T> iterator() {
        return null;
    }

    // Optional problem 2.  Find largest key that is no bigger than x.  Return null if there is no such key.
    public T floor(T x) {
        return null;
    }

    // Optional problem 2.  Find smallest key that is no smaller than x.  Return null if there is no such key.
    public T ceiling(T x) {
        return null;
    }

    // Optional problem 2.  Find predecessor of x.  If x is not in the tree, return floor(x).  Return null if there is no such key.
    public T predecessor(T x) {
        return null;
    }

    // Optional problem 2.  Find successor of x.  If x is not in the tree, return ceiling(x).  Return null if there is no such key.
    public T successor(T x) {
        return null;
    }

// End of Optional problem 2

    public void printTree() {
        System.out.print("[" + size + "]");
        printTree(root);
        System.out.println();
    }

    // Inorder traversal of tree
    void printTree(Entry<T> node) {
        if(node != null) {
            printTree(node.left);
            System.out.print(" " + node.element);
            printTree(node.right);
        }
    }

}
/*
Sample input:
1 3 5 7 9 2 4 6 8 10 -3 -6 -3 0

Output:
Add 1 : [1] 1
Add 3 : [2] 1 3
Add 5 : [3] 1 3 5
Add 7 : [4] 1 3 5 7
Add 9 : [5] 1 3 5 7 9
Add 2 : [6] 1 2 3 5 7 9
Add 4 : [7] 1 2 3 4 5 7 9
Add 6 : [8] 1 2 3 4 5 6 7 9
Add 8 : [9] 1 2 3 4 5 6 7 8 9
Add 10 : [10] 1 2 3 4 5 6 7 8 9 10
Remove -3 : [9] 1 2 4 5 6 7 8 9 10
Remove -6 : [8] 1 2 4 5 7 8 9 10
Remove -3 : [8] 1 2 4 5 7 8 9 10
Final: 1 2 4 5 7 8 9 10 

*/