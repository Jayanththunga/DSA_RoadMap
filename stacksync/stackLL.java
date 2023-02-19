package stacksync;
import linkedlistsync.*;

// how it is implemented:
    // this i simplemented in revrse order i.e, the new node is added before the last node so we dont need to maintain two nodes head and tail...
class stackLL<T>{
    private myNode<T> llhead;
    private int size;

    stackLL(){
        llhead = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void push(T ele){
        myNode<T> node = new myNode<>(ele);
        if(size==0){
            llhead = node;
            size++;
            llhead.next = null;
        }else{
            node.next = llhead;
            size++;
            llhead = node;
        }
    }

    // pop:
    public T pop(){
        if(size==0){
            return null;
        }else{
            myNode<T> temp = llhead;
            llhead = llhead.next;
            size--;
            return temp.data;
        }
    }

    // peek:
    public T peek(){
        if(size==0){
            return null;
        }else{
            return llhead.data;
        }
    }

}