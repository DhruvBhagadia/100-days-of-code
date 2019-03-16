import java.util.*;

class DFS{
	static int[] visited;
	static int[][] adj;

	public static void dfs(int source){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		// visited[source] = 1;
		while(!stack.isEmpty()){
			int current = (Integer) stack.peek();
			if(visited[current] == 0){
				System.out.println(current);
				visited[current] = 1;
			}
			int i=0;
			for(; i<6; i++){
				if(adj[current][i] == 1 && visited[i] == 0){
					stack.push(i);
					// visited[i] = 1;
					break;
				}
			}
			if(i==6)
				stack.pop();
		}
	}

	public static void main(String args[]){
		visited = new int[6];
		adj = new int[6][6];
		adj[0][1] = 1;
		adj[0][2] = 1;
		adj[1][4] = 1;
		adj[1][3] = 1;
		adj[2][4] = 1;
		adj[3][4] = 1;
		adj[3][5] = 1;
		adj[5][4] = 1;
		dfs(0);
	}
}