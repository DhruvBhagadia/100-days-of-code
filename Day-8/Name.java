import java.util.Scanner;
public class Name{
  public static void main (String[]args){
    Scanner s= new Scanner(System.in);
    if(s.hasNextInt()){
        int testCases= s.nextInt();
    s.nextLine();
    String a=null;
    String b=null;
    for(int x=1; x<=testCases; x++){
      String n1= s.next();
      String n2= (s.nextLine()).trim();
      if(n1.length()>n2.length()){
        a=n1;
        b=n2;
      }
      else if(n2.length()>=n1.length()){
        a=n2;
        b=n1;
      }
      int check=0;
      int z=0;
      for(int y=0; y<b.length(); y++){
        while(z<a.length()){
          if(b.charAt(y)==a.charAt(z)){
            check++;
            z++;
            break;
          }else{
            z++;
          }
        }
      }
      if (check==b.length()){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }   
    }
  }
}