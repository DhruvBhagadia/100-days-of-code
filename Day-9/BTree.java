import java.util.*;

class BTree {

	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
            int test_cases = sc.nextInt();
		    while(test_cases-- != 0){
			    int n1 = sc.nextInt();
			    int n2 = sc.nextInt();
			    String str1 =  Integer.toString(n1,2);
			    String str2 =  Integer.toString(n2,2);
			    int len1 = str1.length();
			    int len2 = str2.length();
			    int i=0;
			    int j=0;
			    int first=0;
			    int second=0;
				while(i < len1 && j < len2) {
					if(str1.charAt(i) != str2.charAt(j))
						break;
					i++;
					j++;
				}
				if(i >= len1){
					first = 0;
					second = (len2-j);
				}
				else if(j >= len2){
					second = 0;
					first = (len1-i);
				}
				else{
					first = (len1-i)
					second = (len2-j);
				}
			    System.out.println(first + second);
		    }   
	}
}