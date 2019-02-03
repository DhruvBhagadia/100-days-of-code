import java.util.*;

class CipherLogic{
	public static void main(String args[]){
		//Scanner sc = new Scanner(System.in);
		String input = "HELLOMYNAMEISDHRUV";
		char[][] matrix = new char[3][input.length()/3];
		int i=0;
		int counter = 0;
		for(int j=0; j<input.length()/3; j++){
			for(int k=0; k<3; k++){
				if(j%2 == 0)
					matrix[i++][j] = input.charAt(counter++);
				else
					matrix[--i][j] = input.charAt(counter++);
			}
		}
		for(int l=0; l<3; l++)
			System.out.println(Arrays.toString(matrix[l]));
	}
}