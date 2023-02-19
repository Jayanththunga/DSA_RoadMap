package recursion3;

import java.util.*;

public class subsequence {
  private static void printyourself(String str, String s) {
    if(str.length()==0){
      System.out.println(str+s);
      return;
    }

    
    printyourself(str.substring(1), s);
    printyourself(str.substring(1), s + str.charAt(0));

  }

  public static ArrayList<String> subsequences(String str) {
    if (str.length() == 0) {
      ArrayList<String> arr = new ArrayList<>();
      arr.add("");
      return arr;
    }

    ArrayList<String> small = subsequences(str.substring(1));
    ArrayList<String> ans = new ArrayList<>();
    for (int i = 0; i < small.size(); i++) {
      ans.add(small.get(i));
    }

    char c = str.charAt(0);
    for (int i = 0; i < small.size(); i++) {
      String pp = c + small.get(i);
      ans.add(pp);
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    ArrayList<String> arr = subsequences(str);
    System.out.println(arr);

    printyourself(str, "");
    sc.close();

  }
}
