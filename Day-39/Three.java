import java.util.*;

class Sequence implements Comparable<Sequence>{
	int beg;
	int end;
	int length;
	Sequence(){
		this.beg = 0;
		this.end = 0;
		this.length = 0;
	}

	void update(int beg, int end, int length){
		this.beg = beg;
		this.end = end;
		this.length = length;
	}

	@Override
    public int compareTo(Sequence sq){
        return (this.length - sq.length);
    }
}

class Three{ 

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			ArrayList<Character> vowels = new ArrayList<Character>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');
			while(test_cases-- != 0){
				String str = sc.nextLine();
				ArrayList<Sequence> arrlist = new ArrayList<Sequence>();
				int i=0;
				while(i < str.length()){
					Sequence sq = new Sequence();
					int beg = i;
					int length = 0;
					while(i < str.length() && vowels.contains(str.charAt(i))){
						i++;
						length++;
					}
					int end = (i-1);
					if(length == 0)
						i++;
					else{
						sq.update(beg, end, length);
						arrlist.add(sq);
					}
				}
				if(arrlist.size() == 0)
					System.out.println("0");
				else if(arrlist.size() == 1)
					System.out.println(arrlist.get(0).length);
				else if(arrlist.size() == 2){
					Sequence max = arrlist.get(arrlist.size()-1);
					Sequence second = arrlist.get(arrlist.size()-2);
					System.out.println(max.length+second.length);
				}
				else{
					int start_index = arrlist.get(0).beg;
					Sequence start_sq = arrlist.get(0);
					int end_index = arrlist.get(arrlist.size()-1).end;
					Sequence end_sq = arrlist.get(arrlist.size()-1);
					Collections.sort(arrlist);
					int start = 0;
					int end = 0;
					int middle = 0;
					if(start_index == 0){
						start = start_sq.length;
						arrlist.remove(start_sq);
					}
					if(end_index == str.length()-1){
						end = end_sq.length;
						arrlist.remove(end_sq);
					}
					Collections.sort(arrlist);
					middle = arrlist.get(arrlist.size()-1).length;
					int ans = start + end + middle;
					System.out.println(ans);
				}
			}
		}
	}
}