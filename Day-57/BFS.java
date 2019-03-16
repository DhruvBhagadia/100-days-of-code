import java.util.*;

class BFS{
	static int[] visited;
	static int[][] adj;

	public static void bfs(int source){
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = 1;
		while(!q.isEmpty()){
			int current = q.remove();
			System.out.println(current);
			for(int i=0; i<4; i++){
				if(adj[current][i] == 1 && visited[i] == 0){
					q.add(i);
					visited[i] = 1;
				}
			}
		}
	}

	public static void main(String args[]){
		visited = new int[4];
		adj = new int[4][4];
		// for(int i=0; i<7; i++)
		// 	for(int j=0; j<7; j++)
		// 		System.out.println(adj[i][j]);
		adj[2][0] = 1;
		adj[0][2] = 1;
		adj[0][1] = 1;
		adj[1][2] = 1;
		adj[2][3] = 1;
		adj[3][3] = 1;
		bfs(2);
	}
}