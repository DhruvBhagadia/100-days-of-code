import java.util.*;

class Edge{
	int u, v;
	Edge(int u, int v){
		this.u = u;
		this.v = v;
	}
}

class Shortest{
	static int[] visited;
	static int[][] adj;
	static int[] dist;
	static int n;
	static ArrayList<Edge> arrlist;
	
	public static void bfs(int source){
		Queue<Integer> q = new LinkedList<>();
		int dis = 0;
		dist[source] = 0;
		q.add(source);
		visited[source] = 1;
		while(!q.isEmpty()){
			int current = q.remove();
			dis = dist[current]+6;
			for(int i=0; i<(n+1); i++){
				if(adj[current][i] == 1 && visited[i] == 0){
					q.add(i);
					visited[i] = 1;
					dist[i] = dis;
				}
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
			int test_cases = sc.nextInt();
			while(test_cases-- != 0){
				n = sc.nextInt();
				int m = sc.nextInt();
				sc.nextLine();
				adj = new int[n+1][n+1];
				visited = new int[n+1];
				dist = new int[n+1];
				arrlist = new ArrayList<Edge>();
				while(m-- != 0){
					int u = sc.nextInt();
					int	v = sc.nextInt();
					sc.nextLine();
					Edge e = new Edge(u, v);
					arrlist.add(e);
					adj[u][v] = 1;
					adj[v][u] = 1;
				}
				int start = sc.nextInt();
				bfs(start);
				for(int i=1; i<(n+1); i++){
					if(dist[i] == 0 && i != start){
						dist[i] = -1;
					}
					if(i != start)
						System.out.print(dist[i] + " ");
				}
				System.out.println();
			}
		}
	}
}
