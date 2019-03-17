import java.util.*;

class Edge{
	int u, v;
	Edge(int u, int v){
		this.u = u;
		this.v = v;
	}
}

class Forest{
	static int[] visited;
	static int[][] adj;
	static int n;

	public static int dfs(int source){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		int count=0;
		// visited[source] = 1;
		while(!stack.isEmpty()){
			int current = (Integer) stack.peek();
			if(visited[current] == 0){
				// System.out.println(current);
				visited[current] = 1;
				count++;
			}
			int i=0;
			for(; i<(n+1); i++){
				if(adj[current][i] == 1 && visited[i] == 0){
					stack.push(i);
					// visited[i] = 1;
					break;
				}
			}
			if(i==(n+1))
				stack.pop();
		}
		Arrays.fill(visited, 0);
		return count;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		adj = new int[n+1][n+1];
		visited = new int[n+1];
		int ans = 0;
		sc.nextLine();
		ArrayList<Edge> arrlist = new ArrayList<Edge>();
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			sc.nextLine();
			Edge e = new Edge(u, v);
			arrlist.add(e);
			adj[u][v] = 1;
			adj[v][u] = 1;
		}
		// for(int i=0; i<m; i++)
			// System.out.println()
		for(Edge e:arrlist){
			int u = e.u;
			int v = e.v;
			adj[u][v] = 0;
			int first = dfs(u);
			int second = dfs(v);
			// System.out.println(first + " " + second);
			if(first%2 == 0 && second%2 == 0)
				ans++;
			else
				adj[u][v] = 1;
		}
		System.out.println(ans);
	}
}
