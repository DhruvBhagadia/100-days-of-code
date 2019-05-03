import java.util.*;
import java.lang.*;
import java.io.*;

class Shop {
	static int[][] dist;
	static char[][] arr;
	static int sx, sy, dx, dy, r, c;

	public static void starter(){
		for (int i=0; i<r; i++) {
			for(int j=0; j<c; j++){
				if (arr[i][j] == 'S') {
					sx = i;
					sy = j;
				}
				else if(arr[i][j] == 'D'){
					dx = i;
					dy = j;
				}
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[sx][sy] = 0;
	}

	public static Boolean inRange(int tx, int ty){
		if((tx >= 0 && tx < r) && (ty >= 0 && ty < c))
			return true;
		else
			return false;
	}

	public static void bfs(){
		starter();
		Queue<Integer> q = new LinkedList<>();
		q.add(sx);
		q.add(sy);
		while(!q.isEmpty()){
			int x = q.remove();
			int y = q.remove();
			int[] a = {0, -1, 0, 1};
			int[] b = {-1, 0, 1, 0};
			for (int i=0; i<4; i++) {
				int tx = x+a[i];
				int ty = y+b[i];
				if(inRange(tx, ty)){
					if(arr[tx][ty] != 'D'){
						if(arr[tx][ty] != 'X' && (dist[tx][ty] > dist[x][y]+Character.getNumericValue(arr[tx][ty]))){
							dist[tx][ty] = dist[x][y]+Character.getNumericValue(arr[tx][ty]);
							q.add(tx);
							q.add(ty);
						}
					}
					else{
						if(dist[tx][ty] > dist[x][y]){
							dist[tx][ty] = dist[x][y];
							q.add(tx);
							q.add(ty);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			while(true){
				c = sc.nextInt();
				r = sc.nextInt();
				if((c == 0) && (r == 0))
					break;
				arr = new char[r][c];
				dist = new int[r][c];
				sc.nextLine();
				for(int i=0; i<r; i++){
					String line = sc.nextLine();
					for(int j=0; j<line.length(); j++)
						arr[i][j] = line.charAt(j);
				}
				bfs();
				System.out.println(dist[dx][dy]);
				sc.nextLine();
			}
		}
	}
}