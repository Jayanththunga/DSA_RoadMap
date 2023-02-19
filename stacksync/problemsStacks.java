package stacksync;
import java.util.*;

// balance brackets:
    // check if the given string containing brackets balanced or not.

// revrese stack:
    // Given an array.. reverse using stack.
// check redundant brackets:
// stack span:
// minimum bracket reversal:                        check codingninjas
public class problemsStacks {
    // balance brackets:
    public static boolean isBalanced(String str){
        Stack<Character> st = new Stack<>();
        int size = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='['){
                st.push(str.charAt(i));
                size++;
            }else{
                if(size<=0){
                    return false;
                }else if(str.charAt(i)=='}'){
                    if(st.pop()!='{'){
                        return false;
                    }else{
                        size--;
                    }
                }else if(str.charAt(i)==']'){
                    if(st.pop()!='['){
                        return false;
                    }else{
                        size--;
                    }
                }else if(str.charAt(i)==')'){
                    if(st.pop()!='('){
                        return false;
                    }else{
                        size--;
                    }
                }
            }
        }

        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    // revrese stack:
    public static void reverseStack(Stack<Integer> st){
        Stack<Integer> helper1 = new Stack<>();
        Stack<Integer> helper2 = new Stack<>();

        int n = st.size();
        for(int i=0;i<n;i++){
            helper1.add(st.pop());
        }

        for(int i=0;i<n;i++){
            helper2.add(helper1.pop());
        }

        for(int i=0;i<n;i++){
            st.add(helper2.pop());
        }

    }
    // check redundant brackets:
    public static boolean redundantbrack(String str){

        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=')'){
                st.push(str.charAt(i));
            }else{
                int count = 0;
                while(st.peek()!='('){
                    st.pop();
                    count++;
                }
                st.pop();
                if(count<=1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(isBalanced(str));
        System.out.println(redundantbrack(str));




        sc.close();
    }
}
