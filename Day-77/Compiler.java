import java.util.*;
import java.lang.*;
import java.io.*;

class Compiler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			int test_cases = Integer.parseInt(sc.nextLine());
			while(test_cases-- != 0){
				String inp = sc.nextLine();
				int temp = 0;
				int count = 0;
				int ans = 0;
				for(int i=0; i<inp.length(); i++){
					if(inp.charAt(i) == '<')
						count++;
					else
						count--;
					if(count == 0)
						ans = Math.max(ans, i+1);
					else if (count < 0)
						break;
				}
				System.out.println(ans);
			}
		}
	}
}