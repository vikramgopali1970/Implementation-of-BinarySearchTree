package vxg180002;

/**
 * Team Members :
 * Vikram Gopali (netId : vxg180002)
 * Sreeram Chittela (netId : sxc180025)
 *
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int x = in.nextInt();
            // adds the element into the BST and if already present it replaces the element.
            if(x > 0) {
                System.out.print("Add " + x + " : ");
                t.add(x);
                t.printTree();
            }
            // removes the element from the BST and if not present in the BST then does nothing.
            else if(x < 0) {
                System.out.print("Remove " + x + " : ");
                t.remove(-x);
                t.printTree();
            }
            // Converts the BST into array in in-order traversal.
            else {
                Comparable[] arr = t.toArray();
                System.out.print("Final: ");
                for(int i=0; i<t.size; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
            }
        }
    }
}


/*
Sample Input - 1:
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



Sample Input - 2
1 8 9 10 12 44 43 2 3 4 5 6 7 -9 -6 0
Add 1 : [1] 1
Add 8 : [2] 1 8
Add 9 : [3] 1 8 9
Add 10 : [4] 1 8 9 10
Add 12 : [5] 1 8 9 10 12
Add 44 : [6] 1 8 9 10 12 44
Add 43 : [7] 1 8 9 10 12 43 44
Add 2 : [8] 1 2 8 9 10 12 43 44
Add 3 : [9] 1 2 3 8 9 10 12 43 44
Add 4 : [10] 1 2 3 4 8 9 10 12 43 44
Add 5 : [11] 1 2 3 4 5 8 9 10 12 43 44
Add 6 : [12] 1 2 3 4 5 6 8 9 10 12 43 44
Add 7 : [13] 1 2 3 4 5 6 7 8 9 10 12 43 44
Remove -9 : [12] 1 2 3 4 5 6 7 8 10 12 43 44
Remove -6 : [11] 1 2 3 4 5 7 8 10 12 43 44
Final: 1 2 3 4 5 7 8 10 12 43 44

*/