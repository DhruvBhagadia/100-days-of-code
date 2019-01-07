import java.util.*;

class Distinct {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
		    int n = sc.nextInt();
    		int m = sc.nextInt();
    		ArrayList<Integer> a = new ArrayList<Integer>();
    		ArrayList<Integer> b = new ArrayList<Integer>();
    		ArrayList<Integer> arrlist = new ArrayList<Integer>();
    		int count=0;
    		Boolean flag = false;
    		for(int i=0; i<n; i++)
    			a.add(sc.nextInt());
    		for(int i=0; i<m; i++)
    			b.add(sc.nextInt());
    		for(int i=0; i<n; i++){
    			for(int j=0; j<m; j++){
    				if(count++ >= (n+m-1)){
    					flag = true;
    					break;
    				}
    				if(!arrlist.contains(a.get(i)+b.get(j))){
    					System.out.println(i + " " + j);
    					arrlist.add(a.get(i)+b.get(j));
    				}
    			}
    			if(flag)
    				break;
    		}
		}
	}
}