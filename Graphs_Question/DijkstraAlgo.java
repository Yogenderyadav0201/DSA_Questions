import java.util.ArrayList;
import java.util.PriorityQueue;


public class DijkstraAlgo {
    
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0 ,1, 2));
        graph[0].add(new Edge(0 ,2, 4));

        graph[1].add(new Edge(1 ,3, 7));
        graph[1].add(new Edge(1 ,2, 1));

        graph[2].add(new Edge(2 ,4, 3));

        graph[3].add(new Edge(3 ,5, 1));
        graph[4].add(new Edge(4 ,3, 2));
        graph[4].add(new Edge(4 ,5, 5));

    }

    static class pair implements Comparable<pair>{
        int n; //node
        int path;

        public pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2){
            return this.path - p2.path; //path based sorting.
        }
    }

    public static void Dijkstra(ArrayList<Edge>[] graph, int source){
        // step-1 create a distance array that contain distance b/w source to i index.
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){ //make dist. infinity from source to i index elements.
            if(i != source){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //step-2 create a priority queue
        PriorityQueue<pair> pq=new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        pq.add(new pair(source, 0));

        //DFS loop
        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){ // upadte the distance of scr to v;
                        dist[v] = dist[u] + wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }

        //step-3 print the all dist src to v.
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String arg[]){
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        CreateGraph(graph);

        int scr = 0;
        Dijkstra(graph, scr);
    }
}
