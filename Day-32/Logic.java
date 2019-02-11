import java.util.*;

class Logic{
	static int n = 8;
	static ArrayList<Integer> key;
	static HashMap<Integer, Integer> map;

	public static int[] getFirstNEvenNumbers(){
		int index = 0;
		int[] even = new int[n];
		for(int i=2; i<=(2*n); i += 2)
			even[index++] = i;
		return even;
	}

	public static int[] getFirstNOddNumbers(){
		int index = 0;
		int[] odd = new int[n];
		for(int i=1; i<(2*n); i += 2)
			odd[index++] = i;
		return odd;
	}

	public static int[] getFirstNPrimeNumbers(){
		int index = 0;
		int[] primearr = new int[n];
		int num = 2;
		int count = 0;
		while(count != n) {
		    boolean prime = true;
		    for (int i = 2; i <= Math.sqrt(num); i++) { 
		        if (num % i == 0) {
		            prime = false;
		            break;
		        }

		    }
		    if (prime) {
		        count++;
		        primearr[index++] = num;
		    }
		    num++; 
		}
		return primearr;
	}

	public static ArrayList<Integer> generateKey(){
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int[] odd = getFirstNOddNumbers();
		int[] even = getFirstNEvenNumbers();
		int[] primearr = getFirstNPrimeNumbers();
		for(int i=0; i<n; i++){
			arrlist.add(Math.abs(odd[i]*even[i]-primearr[i]));
		}
		//System.out.println(Arrays.toString(arrlist.toArray()));
		Collections.shuffle(arrlist);
		//System.out.println(Arrays.toString(arrlist.toArray()));
		for(int i=0; i<arrlist.size(); i++)
			arrlist.set(i, arrlist.get(i)%26);
		for(int i=0; i<arrlist.size(); i++){
			int current = arrlist.get(i);
			arrlist.set(i, 27);
			if(arrlist.contains(current))
				arrlist.set(i, current+1);
			else
				arrlist.set(i, current);
		}
		System.out.println("Key: " + Arrays.toString(arrlist.toArray()));
		return arrlist;
	}

	public static String decrypt(StringBuilder cipher_text){
		ArrayList<Integer> decrypted_in_decimal = new ArrayList<Integer>();
		StringBuilder decrypted = new StringBuilder();
		ArrayList<Integer> dup = (ArrayList<Integer>) key.clone();

		int iterations = cipher_text.length()/key.size();
		//System.out.println(iterations);
		int start = 0;
		int end = key.size();

		while(iterations-- != 0){
			StringBuilder intermediate_block = new StringBuilder(cipher_text.substring(start, end));
			StringBuilder decrypted_block = new StringBuilder(cipher_text.substring(start, end));
			//System.out.println("dup:" + Arrays.toString(dup.toArray()));
			for(int i=start, j=0; i<end; i++, j++){
				//System.out.print(cipher_text.charAt(i) + "''");
				decrypted_in_decimal.add((int) cipher_text.charAt(i) - 65);
				//System.out.print(decrypted_in_decimal.get(j) + "''");
				int temp = decrypted_in_decimal.get(j) - dup.get(j);
				//System.out.print(temp + " | ");
				if(temp < 0)
					temp = 26+temp;
				decrypted_in_decimal.set(j, temp);
				intermediate_block.setCharAt(j, (char) (decrypted_in_decimal.get(j)+65));
			}
			// System.out.println(Arrays.toString(decrypted_in_decimal.toArray()));
			// System.out.println(intermediate_block);
			// System.out.println("map: " + map);
			Collections.sort(key);
			for(int i=0; i<n; i++){
				int current = key.get(i);
				int index = map.get(current);
				decrypted_block.setCharAt(i, intermediate_block.charAt(index));
			}
			key = dup;
			dup = (ArrayList<Integer>) key.clone();
			start += key.size();
			end += key.size();
			decrypted_in_decimal.clear();
			decrypted.append(decrypted_block);
		}

		
		
		return decrypted.toString();
	}

	public static String encrypt(StringBuilder to_encrypt){
		StringBuilder encrypted = new StringBuilder();
		ArrayList<Integer> encrypted_in_decimal = new ArrayList<Integer>();
		ArrayList<Integer> dup = (ArrayList<Integer>) key.clone();
		map = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++)
			map.put(key.get(i), i);
		//System.out.println("map: " + map);
		
		int iterations = to_encrypt.length()/key.size();
		int start = 0;
		int end = key.size();
		while(iterations-- != 0){
		//	System.out.println("start: " + start);
		//	System.out.println("end: " + end);
			StringBuilder block = new StringBuilder(to_encrypt.substring(start, end));
			StringBuilder encrypted_block = new StringBuilder(to_encrypt.substring(start, end));
			StringBuilder transposed = new StringBuilder(to_encrypt.substring(start, end));
			start += key.size();
			end += key.size();
			Collections.sort(key);
			for(int i=0; i<n; i++){
				int current = key.get(i);
				int index = map.get(current);
				transposed.setCharAt(index, block.charAt(i));
			}
			//System.out.println("t: " + transposed);
			key = dup;
			dup = (ArrayList<Integer>) key.clone();
			for(int i=0; i<n; i++){
				encrypted_in_decimal.add((int) transposed.charAt(i) - 65);
				encrypted_in_decimal.set(i, (encrypted_in_decimal.get(i)+dup.get(i))%26);
				encrypted_block.setCharAt(i, (char) (encrypted_in_decimal.get(i)+65));
			}
			//System.out.println(Arrays.toString(encrypted_in_decimal.toArray()));
			encrypted_in_decimal.clear();
			//System.out.println(encrypted_block);
			encrypted.append(encrypted_block);
		}

		//System.out.println("encrypted_in_decimal: " + Arrays.toString(encrypted_in_decimal.toArray()));
		return encrypted.toString();
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();

		inp = inp.replaceAll("\\s+", "");
		StringBuilder to_encrypt = new StringBuilder(inp);
		System.out.println(to_encrypt.length());
		key = generateKey();
		int filler_terms_to_be_added = 0;																																																																																																																																																																																																																																																																																																																																																																																																																																																								

		if(to_encrypt.length()%n != 0){
			filler_terms_to_be_added = (key.size() - (to_encrypt.length()%n));
		}
		while(filler_terms_to_be_added-- != 0)
			to_encrypt.append("X");
		System.out.println(to_encrypt);

		String cipher_text = encrypt(to_encrypt);
		System.out.println("Encrypted: " + cipher_text);
		
		String original_text_extracted = decrypt(new StringBuilder(cipher_text)); 
		System.out.println(original_text_extracted);
		//for(int i=0; i)
	}
}