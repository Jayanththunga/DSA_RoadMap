package stacksync;
import java.util.*;

class stackArray<T> {
    private ArrayList<T> arr;
    private int size;
    private int ind;

    stackArray(){
        arr = new ArrayList<>();
        size = 0;
        ind = -1;
    }

    // size:
    public int size(){
        return size;
    }

    // isEmpty:
    public boolean isEmpty(){
        return size==0;
    }

    // push:
    public void push(T ele){
        if(size==0){
            arr.add(ele);
            size++;
            ind++;
        }else{
            arr.add(ele);
            ind++;
            size++;
        }
    }

    // pop:
    public T pop(){
        if(size==0){
            return null;
        }else{
            T ans = arr.get(ind);
            ind--;
            size--;
            return ans;
        }
    }

    // peek:
    public T peek(){
        if(size==0){
            return null;
        }else{
            return arr.get(ind);
        }
    }

}
