import java.util.*;

class ShortName {
	
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			String inp = sc.nextLine();
			String[] inps = inp.split(" ");
			StringBuilder ans = new StringBuilder();
			for(int i=0; i<inps.length-1; i++){
				ans.append(inps[i].charAt(0));
				ans.append(". ");
			}
			ans.append(inps[inps.length-1]);
			System.out.println(ans);
		}
		catch(Exception e){

		}
	}
}