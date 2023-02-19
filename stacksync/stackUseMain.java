// functions / methods of Stack:
//  1. size()
//  2. isEmpty();
//  3. push();
//  4. pop();
//  5. peek();     

package stacksync;
import java.util.*;

public class stackUseMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }


        // stack:
        stackArray<Integer> st = new stackArray<>();
        System.out.println(st.size()); 
        for(int i=0;i<n;i++){
            st.push(arr[i]);
        }

        System.out.println(st.size());   
        for(int i=0;i<n;i++){
            System.out.println("Top element: "+ st.peek() + " Deleted element: " + st.pop() + " Size now: " + st.size() + " Empty??: "+ st.isEmpty());
        }


        int m = sc.nextInt();
        char a[] = new char[m];
        for(int i=0;i<m;i++){
            String s = sc.next();
            a[i] = s.charAt(0);
        }

        // stack:
        stackLL<Character> stc = new stackLL<>();
        System.out.println(stc.size()); 
        for(int i=0;i<m;i++){
            stc.push(a[i]);
        }

        System.out.println(stc.size());   
        for(int i=0;i<m;i++){
            System.out.println("Top element: "+ stc.peek() + " Deleted element: " + stc.pop() + " Size now: " + stc.size() + " Empty??: "+ stc.isEmpty());
        }



        sc.close();
    }

}
