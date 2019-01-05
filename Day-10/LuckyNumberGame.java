/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class LuckyNumberGame
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    Scanner sc = new Scanner(System.in);
    		if(sc.hasNextInt()){
    		    int test_cases = sc.nextInt();
        		while(test_cases-- != 0){
        			int n = sc.nextInt();
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int[] arr = new int[n];
                    //int[] visited
                    for (int i=0; i<n; i++) {
                        arr[i] = sc.nextInt();
                    }
                    int bob_no = 0;
                    int alice_no = 0;
                    int intersection = 0;
                    for (int i=0; i<n; i++) {
                        if(arr[i] % a == 0)
                            bob_no++;
                        if(arr[i] % b == 0)
                            alice_no++;
                        if(arr[i] % a == 0 && arr[i] % b == 0)
                            intersection++;
                    }
                    if(a == b){
                        if(bob_no > 0)
                            System.out.println("BOB");
                        else
                            System.out.println("ALICE");
                    }
                    else {
                        if(intersection != 0){
                            int left_with_alice = alice_no - intersection;
                            int left_with_bob = (bob_no - intersection)+1;
                            if(left_with_alice == 0 || left_with_bob > left_with_alice) 
                                System.out.println("BOB");
                            else if(left_with_alice >= left_with_bob)
                                System.out.println("ALICE");
                        }
                        else{
                            if(bob_no > alice_no)
                                System.out.println("BOB");
                            else
                                System.out.println("ALICE");
                        }
                    }
        		}
    		}
		} catch(Exception e) {
		} 
	}
}
