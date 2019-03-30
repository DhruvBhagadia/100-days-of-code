import java.util.*;

class Age {
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){
				int test_cases = sc.nextInt();
				sc.nextLine();
				while(test_cases-- != 0){
					int n = sc.nextInt();
					sc.nextLine();
					int[] a = new int[n];
					int total = 0;
					for(int i=0; i<n; i++){
						a[i] = sc.nextInt();
						total += a[i];
					}
					sc.nextLine();
					int[] start = new int[3];
					int[] end = new int[3];
					for(int i=0; i<3; i++)
						start[i] = sc.nextInt();
					sc.nextLine();
					for(int i=0; i<3; i++)
						end[i] = sc.nextInt();
					sc.nextLine();
					if((start[0] == end[0]) && (start[1] == end[1]))
						System.out.println(end[2]-start[2]+1);
					else{
						int initial = 0;
						int fina = 0;
						int intermediate = 0;
						int i=0;
						int temp_sum=0;
						if(start[0] == end[0]){
							// System.out.println("here");
							int sum = 0;
							int counter = start[1]+1;
							// System.out.println("c: " + counter);
							while(counter < end[1]){
								sum += a[counter-1];
								counter++;
							}
							// System.out.println(sum);
							sum += end[2];
							// System.out.println(sum);
							sum += (a[start[1]-1]-start[2])+1;
							System.out.println(sum);
						}
						else{
							while((i+1)<start[1]){
							// System.out.println(a[i]);
								temp_sum += a[i];
								i++;
							}
							temp_sum += (start[2]-1);
							initial = (total-temp_sum);
							if(start[0]%4 == 0)
								initial++;
							// System.out.println("in: " + initial);
							temp_sum = 0;
							i = 0;
							while((i+1)<end[1]){
							// System.out.println(a[i]);
								temp_sum += a[i];
								i++;
							}
							temp_sum += end[2];
							fina = temp_sum;
							// System.out.println("fin:l: " + fina);
							int diff = (end[0]-start[0]);
							if(diff > 1){
								int counter = (start[0]+1);
								int l = 0;
								int nl = 0;
								while(counter < end[0]){
									if(counter%4 == 0)
										l++;
									else
										nl++;
									counter++;
								}
								intermediate += (l*(total+1)) + (nl*total);
							}
							// System.out.println("intermediate: " + intermediate);
							System.out.println(intermediate+initial+fina);
						}
					}
				}
			}
		}
		catch(Exception e){

		}
	}
}