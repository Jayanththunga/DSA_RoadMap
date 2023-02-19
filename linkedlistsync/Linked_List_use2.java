package linkedlistsync;
import java.util.*;


public class Linked_List_use2 {

    // 1. print recursively:
    public static void printR(myNode<Integer> head){
        // easy by using recursion:
        if(head == null){
            return;
        }

        System.out.print(head.data + " ");
        printR(head.next);
    }

    // 2. insert node recursively:
    public static myNode<Integer> insertR(myNode<Integer> head, int pos, int val){
        if(head == null && pos>0){
            return head;
        }
        
        if(pos == 0){
            myNode<Integer> newnode = new myNode<Integer>(val);
            newnode.next = head;
            return newnode;
        }else{
            head.next = insertR(head.next, pos-1, val);
            return head;
        }

    }

    // some weird alternative printing:
    public static void printalternative(myNode<Integer> start)
    {
      if(start == null)
        return;
      System.out.print(start.data+ " "); 
    
      if(start.next != null )
        printalternative(start.next.next);
      System.out.print(start.data+ " ");
    }

    // 3. delete node recursively:
    public static myNode<Integer> deleteNodeRec(myNode<Integer> head, int pos) {
    	//Your code goes here
        if(head == null){
            return head;
        }
        if(pos == 0){
            return head.next;
        }else{
            head.next = deleteNodeRec(head.next, pos-1);
            return head;
        }
	}

    // 4.
    // 4a. reverse Linked list method 1:  O(n2)
    public static myNode<Integer> reverseLinkedListRec(myNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }

        myNode<Integer> newnode = reverseLinkedListRec(head.next);
        myNode<Integer> tail = newnode;
        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = head;
        head.next = null;
        return newnode;
	}

    // 4b. reverse method 2: pair double:  O(n)
    public static doubleNode pairdouble(myNode<Integer> head){
        doubleNode ans;
        if(head == null || head.next == null){
            ans = new doubleNode(head, head);
            return ans;
        }
        doubleNode smallans = pairdouble(head.next);
        smallans.tail.next = head;
        head.next = null;

        ans = new doubleNode(smallans.head, head);
        return ans;
    }

    // 4c. reverse method 3: iterative O(n)
    public static myNode<Integer> reverseLinkedListRec2(myNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }

        myNode<Integer> newnode = reverseLinkedListRec2(head.next);
        myNode<Integer> tail = head.next;

        tail.next = head;
        head.next = null;
        return newnode;
	}

    // 5. mid point of Linked list
    public static myNode<Integer> findmidpointLL(myNode<Integer> head){
        if(head == null){
            return head;
        }

        myNode<Integer> slow = head;
        myNode<Integer> fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // merging 2 sorted Linked Lists:
    public static myNode<Integer> mergertwosorted(myNode<Integer> head1, myNode<Integer> head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        myNode<Integer> t1 = head1;
        myNode<Integer> t2 = head2;
        myNode<Integer> head = null;
        myNode<Integer> tail = null;

        if(t1.data <= t2.data){
            head = t1;
            tail = t1;
            t1 = t1.next;
        }else{
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }else{
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            tail.next = t1;
        }else{
            tail.next = t2;
        }
        return head;

    }

    // merege sort:
    

    


    public static void main(String[] args) {
        myNode<Integer> ll1 = takeinput2();
        ll1 = insertR(ll1, 0, 10);
        printR(ll1);

        System.out.println();
        myNode<Integer> ll2 = deleteNodeRec(ll1, 2);
        printR(ll2);

        System.out.println();
        myNode<Integer> ll3 = reverseLinkedListRec2(ll2);
        printR(ll3);

        System.out.println();
        doubleNode ll4ans = pairdouble(ll3);
        printR(ll4ans.head);
        
        System.out.println();
        myNode<Integer> ll4 = reverseLinkedListRec2(ll2);
        printR(ll4);

        System.out.println();
        System.out.println(findmidpointLL(ll4).data);

        System.out.println();
        System.out.println();


        // myNode<Integer> ll5 = takeinput2();
        // myNode<Integer> ll6 = takeinput2();
        // myNode<Integer> ansmergerd1 = mergertwosorted(ll5, ll6);
        // printR(ansmergerd1);


    }

    // take input:
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
    
}
