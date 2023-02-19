package linkedlistsync;

import java.util.Scanner;

public class Linked_List_use1 {

    // take input

    public static myNode<Integer> takeinput1() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        myNode<Integer> head = null;
        while (data != -1) {
            myNode<Integer> nownode = new myNode<>(data);
            if (head == null) {
                head = nownode;
            } else {
                myNode<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = nownode;
            }

            data = sc.nextInt();
        }

        sc.close();
        return head;
    }

    // optimistic way to take input

    public static myNode<Integer> takeinput2() {
        Scanner sc = new Scanner(System.in);
        myNode<Integer> head = null;
        myNode<Integer> tail = null;
        int data = sc.nextInt();

        while (data != -1) {
            myNode<Integer> nownode = new myNode<Integer>(data);
            if (head == null) {
                head = nownode;
                tail = nownode;
            } else {
                tail.next = nownode;
                tail = tail.next;
            }

            data = sc.nextInt();
        }
        sc.close();
        return head;
    }

    // print1

    public static void print(myNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // find length of linked list

    public static int llsize(myNode<Integer> head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    // increment every element

    public static myNode<Integer> incremental(myNode<Integer> head) {
        myNode<Integer> temp = head;
        while (temp != null) {
            temp.data++;
            temp = temp.next;
        }
        return head;
    }

    // insert node

    public static myNode<Integer> insertnode(myNode<Integer> head, int n, int x) {

        if (head == null) {
            return head;
        }

        if (n == 0) {
            myNode<Integer> newnode = new myNode<Integer>(x);
            newnode.next = head;
            head = newnode;
            return head;
        }

        myNode<Integer> newnode = new myNode<Integer>(x);
        myNode<Integer> nownode = head;
        myNode<Integer> prevnode = head;
        for(int i=0;i<n-1;i++){
            if(prevnode == null){
                return head;
            }
            prevnode = prevnode.next;
        }

        nownode = prevnode.next;
        prevnode.next = newnode;
        newnode.next = nownode;

        return head;
    }

    // delete node

    public static myNode<Integer> deletenode(myNode<Integer> head, int n) {
        if (head == null) {
            return head;
        }

        if (n == 0) {
            head = head.next;
            return head;
        }

        myNode<Integer> prevnode = head;
        for (int i = 0; i < n - 1; i++) {
            if (prevnode.next.next == null) {
                return head;
            }
            prevnode = prevnode.next;
        }

        prevnode.next = prevnode.next.next;
        return head;
    }

    public static void main(String[] args) {
        myNode<Integer> ll1 = takeinput1();
        print(ll1);
        System.out.println(llsize(ll1));

        // new incremented node:
        myNode<Integer> ll2 = incremental(ll1);
        print(ll2);

        // delete node
        myNode<Integer> ll3 = deletenode(ll2, 100);
        print(ll3);

        // insert node
        myNode<Integer> ll4 = insertnode(ll1, 5, 100);
        print(ll4);
    }

}