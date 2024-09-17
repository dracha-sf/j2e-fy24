/*
Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can
slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
top of an even larger one).
You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last and print the moves
*/
package salesforce.recursion;

public class problem4 {
    public static void moveDisks(int n, int form, int to, int aux) {
        if (n > 0) {
            // Move n-1 disks from the source to auxiliary tower
            moveDisks(n - 1, form, aux, to);

            // Move the nth disk from the source to the destination tower
            System.out.println("Move disk from rod " + form + " to rod " + to);

            // Move the n-1 disks from auxiliary tower to destination tower
            moveDisks(n - 1, aux, to, form);
        }
    }

    public static void main(String[] args) {
        int N = 3;
        moveDisks(N, 1, 3, 2);
    }
}

