import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Telephone { 
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int n = Integer.parseInt(sc.nextLine());
				String inp = sc.nextLine();
				if((inp.length() < 11) || (inp.length() == 11 && inp.charAt(0) != '8'))
					System.out.println("NO");
				else{
					int len = inp.length()-11;
					Boolean found = false;
					for(int i=0; i<=len; i++){
						if(inp.charAt(i) == '8'){
							found = true;
							break;
						}
					}
					if(!found)
						System.out.println("NO");
					else
						System.out.println("YES");
				}
			}
		}
	}
}