import java.util.*;

// class Entity{
// 	String name;
// 	int points;
// 	int goal_diff;
// 	Entity(String name){
// 		this.name = name;
// 		this.points = 0;
// 		this.goal_diff = 0;
// 	}
// }

class First{
	static ArrayList<String> names;
	static ArrayList<Integer> points;
	static ArrayList<Integer> goal_diff;
	public static void main (String args[]){
		//System.out.println(Arrays.toString());
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				int i=0; 
				while(i++ <= 12){
					System.out.println("i " + i);
					String inp = sc.nextLine();
					String[] inps = inp.split(" ");
					names  = new ArrayList<String>();
					points = new ArrayList<Integer>();
					goal_diff = new ArrayList<Integer>();

					// ArrayList<Entity> arrlist = new ArrayList<Entity>();
					// HashMap<Entity, String> map = new HashMap<Entity, String>();
					if(!names.contains(inps[0])){
						names.add(inps[0]);
						points.add(0);
						goal_diff.add(0);
						// Entity entity = new Entity(inps[0]);
						// arrlist.add(entity);
						// map.put(entity, inps[0]);
					}
					if(!names.contains(inps[4])){
						names.add(inps[4]);
						points.add(0);
						goal_diff.add(0);
					}
					int t1 = Integer.parseInt(inps[1]); 
					int t2 = Integer.parseInt(inps[3]);
					if(t1 != t2){
						if(t1 > t2){
							int index = names.indexOf(inps[0]);
							points.set(index, points.get(index)+3);
							goal_diff.set(index, goal_diff.get(index)+(t1-t2));
							index = names.indexOf(inps[4]);
							goal_diff.set(index, goal_diff.get(index)+(t2-t1));
						}
						else{
							int index = names.indexOf(inps[4]);
							points.set(index, points.get(index)+3);
							goal_diff.set(index, goal_diff.get(index)+(t2-t1));
							index = names.indexOf(inps[0]);
							goal_diff.set(index, goal_diff.get(index)+(t1-t2));
						}
					}
					else{
						//tie
						int index = names.indexOf(inps[0]);
						points.set(index, points.get(index)+1);
						index = names.indexOf(inps[4]);
						points.set(index, points.get(index)+1);;
					}
				}
				System.out.println("--");
					for(int ii=0; ii<names.size(); ii++)
						System.out.println(names.get(ii) + " " + points.get(ii) + " " + goal_diff.get(ii));
				names.clear();
				points.clear();
				goal_diff.clear();
			}
		}
	}
}