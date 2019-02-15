import java.util.*;

class Partition {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			sc.nextLine();
			while(test_cases-- != 0){
				 int x = sc.nextInt();
				 int n = sc.nextInt();
				 char[] ans = new char[n];
				 sc.nextLine();
				 int sum = (n*(n+1)/2);
				 int updated_sum = sum - x;
				 if(updated_sum % 2 == 1 || n == 2)
				 	System.out.println("impossible");
				 else{
				 	int required_sum = updated_sum/2;
				 	// if(n != x){
				 	// 	ans[n-1] = '1';
					 // 	int left_sum = required_sum-n;
					 // 	int i=n;
					 // 	// System.out.println(left_sum);
					 // 	while(i-- != 1){
					 // 		if(i != x){
					 // 			if(i <= left_sum){
						//  			ans[i-1] = '1';
						//  			left_sum = left_sum-i;
						//  		}
						//  		else
						//  			ans[i-1] = '0';
					 // 		}
					 // 		// System.out.println(left_sum);
					 // 	}
					 // 	// System.out.println(left_sum);
					 // 	if(left_sum != 0){
					 // 		ans[n-1] = '0';
					 // 		ans[n-2] = '1';
					 // 		required_sum = updated_sum/2;
						//  	left_sum = required_sum-(n-1);
						//  	i=n-1;
						//  	while(i-- != 1){
						//  		if(i != x){
						//  			if(i <= left_sum){
						// 	 			ans[i-1] = '1';
						// 	 			left_sum = left_sum-i;
						// 	 		}
						// 	 		else
						// 	 			ans[i-1] = '0';
						//  		}
						//  	}
					 // 	}
					 // 	if(left_sum != 0)
					 // 		System.out.println("impossible");
					 // 	else{
					 // 		ans[x-1] = '2';
						 	// for (int j=0; j<n; j++) 
						 	// 	System.out.print(ans[j]);
						 	// System.out.println();
					 // 	}
				 	// }
				 	// else{
				 	// 	ans[n-2] = '1';
					 // 	int left_sum = required_sum-(n-1);
					 // 	int i=n-1;
					 // 	// System.out.println(left_sum);
					 // 	while(i-- != 1){
					 // 		if(i != x){
					 // 			if(i <= left_sum){
						//  			ans[i-1] = '1';
						//  			left_sum = left_sum-i;
						//  		}
						//  		else
						//  			ans[i-1] = '0';
					 // 		}
					 // 		// System.out.println(left_sum);
					 // 	}
					 // 	// System.out.println(left_sum);
					 // 	if(left_sum != 0){
					 // 		ans[n-2] = '0';
					 // 		ans[n-3] = '1';
					 // 		required_sum = updated_sum/2;
						//  	left_sum = required_sum-(n-2);
						//  	i=n-2;
						//  	while(i-- != 1){
						//  		if(i != x){
						//  			if(i <= left_sum){
						// 	 			ans[i-1] = '1';
						// 	 			left_sum = left_sum-i;
						// 	 		}
						// 	 		else
						// 	 			ans[i-1] = '0';
						//  		}
						//  	}
					 // 	}
					 // 	if(left_sum != 0)
					 // 		System.out.println("impossible");
					 // 	else{
					 // 		ans[x-1] = '2';
						//  	for (int j=0; j<n; j++) 
						//  		System.out.print(ans[j]);
						//  	System.out.println();
					 // 	}
				 	// }
				 	for(int i=0; i<n; i++)
				 		ans[i] = '0';
				 	ans[x-1] = '2';
				 	for(int i=n; i>=1; i--){
				 		if(i == x)
				 			continue;
				 		else if(i <= required_sum){
				 			required_sum = required_sum-i;
				 			ans[i-1] = '1';
				 		}
				 		if(required_sum == 0)
				 			break;
				 	}
				 	if(required_sum != 0){
				 		for(int i=n-1; i>=1; i--){
					 		if(i == x)
					 			continue;
					 		else if(i <= required_sum){
					 			required_sum = required_sum-i;
					 			ans[i-1] = '1';
					 		}
					 		if(required_sum == 0)
					 			break;
					 	}
					 	if(required_sum != 0)
				 			System.out.println("impossible");
				 		else{
				 			for (int j=0; j<n; j++) 
						 		System.out.print(ans[j]);
						 	System.out.println();
				 		}
				 	}
				 	else{
				 		for (int j=0; j<n; j++) 
						 	System.out.print(ans[j]);
						 System.out.println();
				 	}
				} 
			}
		}
	}
}