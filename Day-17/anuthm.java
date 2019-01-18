import java.io.*;
import java.util.*;
class anuthm 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println((double)(n+m-1));
        }
    }
}
