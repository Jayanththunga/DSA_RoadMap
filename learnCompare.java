import java.util.*;

public class learnCompare{
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      List<nibba> lst = new ArrayList<>();
      for(int i=0;i<7;i++){
        lst.add(new nibba(sc.nextInt()));
      }
      
      for(int i=0;i<7;i++){
        System.out.print(lst.get(i).a + " ");
      }
      
      System.out.println();
      Collections.sort(lst);
      for(int i=0;i<7;i++){
        System.out.print(lst.get(i).a + " ");
      }
      sc.close();
  }
}

class nibba implements Comparable<nibba>{
  int a;
  nibba(int a){
    this.a = a;
  }
  
  public int compareTo(nibba n){
    if(this.a>n.a) return 1;
    else if(this.a<n.a) return -1;
    else return 0;
  } 
}


