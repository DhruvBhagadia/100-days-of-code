import java.util.*;

class Many{
	static StringBuilder str;

	public static Boolean continuousFourQMs(int index){
		for(int i=index+1; i<(index+4) && i < str.length(); i++)
			if(str.charAt(i) != '?')
				return false;
		return true;
	}

	public static Boolean continuousThreeQMs(int index){
		for(int i=index+1; i<(index+3) && i < str.length(); i++)
			if(str.charAt(i) != '?')
				return false;
		return true;
	}

	public static Boolean oneQMBefore(int index){
		if((index-1) >= 0 && str.charAt(index-1) == '?')
			return true;
		else
			return false;
	}

	public static Boolean twoQMsAfter(int index){
		if((index+2) < str.length() && str.charAt(index+1) == '?' && str.charAt(index+2) == '?')
			return true;
		else
			return false;
	}

	public static Boolean oneQMAfter(int index){
		if((index+1) < str.length() && str.charAt(index+1) == '?')
			return true;
		else
			return false;
	}

	public static Boolean twoQMsBefore(int index){
		if((index-2) >= 0 && str.charAt(index-1) == '?' && str.charAt(index-2) == '?')
			return true;
		else
			return false;
	}

	public static Boolean threeQMsBefore(int index){
		if((index-3) >= 0 && str.charAt(index-3) == '?' && str.charAt(index-1) == '?' && str.charAt(index-2) == '?')
			return true;
		else
			return false;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				String in = sc.nextLine();
				str = new StringBuilder(in);
				for(int i=0; i < str.length(); i++){
					if(!str.toString().contains("?"))
						break;
					char current = str.charAt(i);
					if(current == 'C'){
						if(continuousThreeQMs(i))
							str.replace(i, i+4, "CHEF");
					}
					else if(current == 'H'){
						if(oneQMBefore(i) && twoQMsAfter(i))
							str.replace(i-1, i+3, "CHEF");
					}
					else if(current == 'E'){
						if(twoQMsBefore(i) && oneQMAfter(i))
							str.replace(i-2, i+2, "CHEF");
					}
					else if(current == 'F'){
						if(threeQMsBefore(i)){
							str.replace(i-3, i+1, "CHEF");
						}
					}
				}
				for(int i=0; i < str.length(); i++){
					if(!str.toString().contains("?"))
						break;
					char current = str.charAt(i);
					if(current == '?'){
						if(continuousFourQMs(i))
							str.replace(i, i+4, "CHEF");
					}
				}
				if(str.toString().contains("?")){
					while(str.toString().contains("?")){
						int index = str.indexOf("?");
						str.setCharAt(index, 'A');
					}
				}
				System.out.println(str);
			}
		}
	}