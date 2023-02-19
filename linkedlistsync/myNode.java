package linkedlistsync;

public class myNode<T> {
    public T data;
    public myNode<T> next;

    public myNode(T data){
        this.data = data;
    }
}

class doubleNode{
    myNode<Integer> head;
    myNode<Integer> tail;

    // doubleNode(){
        
    // }
    
    doubleNode(myNode<Integer> head, myNode<Integer> tail){
        this.tail = tail;
        this.head = head;
    }
}



