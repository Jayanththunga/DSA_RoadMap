package linkedlistsync;
import java.util.*;

public class LL_assignment_1 {

    // append last n to first
    // palindrome linked list:

    
    // find node in linked list(return its index):
    public static int findnode(myNode<Integer> head, int n){
        if(head == null){
            return -1;
        }
        int i = 0;
        while(head != null){
            if(head.data == n){
                return i;
            }
            i++;
            head = head.next;
        }
        return -1;
    }

    // elemenate duplicates
    public static myNode<Integer> elemenatedupes(myNode<Integer> head){
        if(head == null){
            return head;
        }

        myNode<Integer> nownode = head;

        while(nownode != null && nownode.next != null){
            if(nownode.data == nownode.next.data){
                nownode.next = nownode.next.next;
            }else{
                nownode = nownode.next;
            }
        }
        return head;
    }

    // print reverse linked list (not reversing it only printing reverse):
    
    public static void printreverse(myNode<Integer> head){
        // easy by using recursion:
        if(head == null){
            return;
        }
        printreverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        myNode<Integer> ll1 = takeinput2();
        print(ll1);

        // print reverse
        System.out.println(llsize(ll1));
        printreverse(ll1);

        // delete duplicate elements:
        System.out.println();
        myNode<Integer> ll2 = elemenatedupes(ll1);
        print(ll2);

        // finding node ( returning the index):
        System.out.println(findnode(ll2, 5));
        System.out.println(findnode(ll2, 7));
        System.out.println(findnode(ll2, 0));

    }



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
}
