package recursion3;
import java.util.*;


public class keypad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        ArrayList<String> arr = keypadGenerator(str);
        for(String s: arr){
            System.out.print(s + " ");
        }

        System.out.println();

        int num = Integer.parseInt(str);
        printyourself(num, "");

        sc.close();
    }

    private static void printyourself(int num, String string) {
        if(num ==0 || num ==1){
            System.out.print(string+ " ");
            return;
        }

        int n = num%10;
        String st = getString(n);

        for(int i=0;i<st.length();i++){
            printyourself(num/10, st.charAt(i)+string);
        }
    }

    private static String getString(int n) {
        if(n==2){
            return "abc";
        }else if(n==3){
            return "def";
        }else if(n==4){
            return "ghi";
        }else if(n==5){
            return "jkl";
        }else if(n==6){
            return "mno";
        }else if(n==7){
            return "pqrs";
        }else if(n==8){
            return "tuv";
        }else if(n==9){
            return "wxyz";
        }
        return null;
    }

    private static ArrayList<String> keypadGenerator(String str) {
        int num = Integer.parseInt(str);
        return keypadGenerator(num);
    }

    private static ArrayList<String> keypadGenerator(int num) {
        
        if(num==1 || num == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String> arr = keypadGenerator(num/10);
        int n = num%10;

        ArrayList<String> ans = new ArrayList<>();
        int l = arr.size();
        if(n==2){
            // abc
            set('a', arr, 0, l-1, ans );
            set('b', arr, l, 2*l-1, ans );
            set('c', arr, 2*l, 3*l-1, ans );
        }else if(n==3){
            //def
            set('d', arr, 0, l-1, ans );
            set('e', arr, l, 2*l-1, ans );
            set('f', arr, 2*l, 3*l-1, ans );
        }else if(n==4){
            //ghi
            set('g', arr, 0, l-1, ans );
            set('h', arr, l, 2*l-1, ans );
            set('i', arr, 2*l, 3*l-1, ans );
        }else if(n==5){
            //jkl
            set('j', arr, 0, l-1, ans );
            set('k', arr, l, 2*l-1, ans );
            set('l', arr, 2*l, 3*l-1, ans );
        }else if(n==6){
            //mno
            set('m', arr, 0, l-1, ans );
            set('n', arr, l, 2*l-1, ans );
            set('o', arr, 2*l, 3*l-1, ans );
        }else if(n==7){
            //pqrs
            set('p', arr, 0, l-1, ans );
            set('q', arr, l, 2*l-1, ans );
            set('r', arr, 2*l, 3*l-1, ans );
            set('s', arr, 3*l, 4*l-1, ans );
        }else if(n==8){
            //tuv
            set('t', arr, 0, l-1, ans );
            set('u', arr, l, 2*l-1, ans );
            set('v', arr, 2*l, 3*l-1, ans );
        }else if(n==9){
            //wxyz
            set('w', arr, 0, l-1, ans );
            set('x', arr, l, 2*l-1, ans );
            set('y', arr, 2*l, 3*l-1, ans );
            set('z', arr, 3*l, 4*l-1, ans );
        }

        return ans;

    }

    private static void set(char c, ArrayList<String> arr, int i, int j, ArrayList<String> ans) {
        for(int q=i;q<=j;q++){
            ans.add(arr.get(q-i)+c);
        }
    }
}
