import java.util.*;

class Case {
	
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextLine()){
				StringBuilder inp = new StringBuilder(sc.nextLine());
				String inp2 = sc.nextLine();
				String[] inps = inp2.split(" ");
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for(int i=0; i<inps.length; i++)
					arr.add(Integer.parseInt(inps[i]));
				// while(sc.hasNextInt())
				// 	arr.add(sc.nextInt());
				// System.out.println(Arrays.toString(arr.toArray()));
				for(int j=0; j<arr.size(); j++){
					int index = arr.get(j);
					char cur = inp.charAt(index-1);
					if(cur >= 'A' && cur <= 'Z')
						cur += 32;
					else if(cur >= 'a' && cur <= 'z')
						cur -= 32;
					inp.setCharAt(index-1, cur);
				}
				System.out.println(inp);
			}
		}
		catch(Exception e){

		}
	}
}