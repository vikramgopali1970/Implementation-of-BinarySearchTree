Compiling the code in IntelliJ Idea:
create a empty project.
->Navigate to 'projectName'->src folder.
->paste the unzipped folder inside the src folder.
->In the above menu select Run->Run...
->select the 'className'



Running the code:
The Driver function works as following:
-> Starts the tree Creation Process.
-> Any positive number we input adds the element into the BST and incase if it already exists it will replace the element;
-> Any Negative number we input removes the element from BST if found else does nothing.
-> inputting 0 would terminate the creation process and would the BST into an array of elements with In-Order Traversal and print the array.




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

Sample Input - 3
0
The Binary Search Tree is Empty
