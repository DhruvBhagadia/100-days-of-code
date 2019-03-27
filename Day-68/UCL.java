import java.util.*;

class Entity implements Comparable<Entity>{
	String name;
	int points;
	int goal_diff;
	Entity(String name){
		this.name = name;
		this.points = 0;
		this.goal_diff = 0;
	}

	void tie(){
		this.points++;
	}

	void won(){
		this.points += 3;
	}

	void addGoadDiff(int val){
		this.goal_diff += val;
	}

	@Override
	public int compareTo(Entity e){
		return (this.points < e.points) ? 1: -1;
	}

	public static final Comparator<Entity> goalDifference = new Comparator<Entity>(){

        @Override
        public int compare(Entity e1, Entity e2) {
            return (e1.goal_diff > e2.goal_diff ? -1: 1);
        }
      
    };
}

class UCL{
	static ArrayList<String> names;
	static ArrayList<Integer> points;
	static ArrayList<Integer> goal_diff;
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int i=0; 
				ArrayList<Entity> arrlist = new ArrayList<Entity>();
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				int index = 0;
				while(i++ < 12){
					String inp = sc.nextLine();
					String[] inps = inp.split(" ");
					String t1 = inps[0];
					String t2 = inps[4];
					int s1 = Integer.parseInt(inps[1]);
					int s2 = Integer.parseInt(inps[3]);
					if(!map.containsKey(t1)){
						Entity e = new Entity(t1);
						arrlist.add(e);
						map.put(t1, index++);
					}
					if(!map.containsKey(t2)){
						Entity e = new Entity(t2);
						arrlist.add(e);
						map.put(t2, index++);
					}
					int index1 = map.get(t1);
					int index2 = map.get(t2);
					if(s1 == s2){
						arrlist.get(index1).tie();
						arrlist.get(index2).tie();
					}
					else if(s1 > s2)
						arrlist.get(index1).won();
					else
						arrlist.get(index2).won();
					arrlist.get(index1).addGoadDiff(s1-s2);
					arrlist.get(index2).addGoadDiff(s2-s1);
				}
				Collections.sort(arrlist);
				if(arrlist.get(0).points == arrlist.get(1).points){
					i = 0;
					while(i < 3 && arrlist.get(i).points == arrlist.get(i+1).points)
						i++;	
					List<Entity> sub = arrlist.subList(0, i+1);
					Collections.sort(sub, Entity.goalDifference);
					System.out.println(sub.get(0).name + " " + sub.get(1).name);
				}
				else{
					System.out.print(arrlist.get(0).name + " ");
					if(arrlist.get(1).points == arrlist.get(2).points){
						i = 1;
						while(i < 3 && arrlist.get(i).points == arrlist.get(i+1).points)
							i++;
						List<Entity> sub = arrlist.subList(1, i+1);
						Collections.sort(sub, Entity.goalDifference);
						System.out.print(sub.get(0).name);
					}
					else 
						System.out.print(arrlist.get(1).name + " ");
					System.out.println();
				}
			}
		}
	}
}