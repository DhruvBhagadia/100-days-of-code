import java.util.*;
import java.lang.*;
import java.io.*;

class Street {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			while(true){
				String first = sc.nextLine();
				if(first.equals("0"))
					break;
				int n = Integer.parseInt(first);
				int[] arr = new int[n];
				for(int i=0; i<n; i++)
					arr[i] = sc.nextInt();
				sc.nextLine();
				int counter = 1;
				Stack<Integer> stack = new Stack<Integer>();
				for(int i=0; i<n; i++){
					int current = arr[i];
					if(current != counter){
						if ((!stack.isEmpty()) && ((int)stack.peek() == counter)) {
							stack.pop();
							counter++;
							i--;
						}
						else
							stack.push(current);
					}
					else
						counter++;
				}
				Boolean flag = true;
				while(!stack.isEmpty()){
					if(stack.peek() == counter){
						stack.pop();
						counter++;
					}
					else{
						flag = false;
						break;
					}
				}
				counter--;
				if(counter != n || !flag)
					System.out.println("no");
				else
					System.out.println("yes");
			}
		}
	}
}