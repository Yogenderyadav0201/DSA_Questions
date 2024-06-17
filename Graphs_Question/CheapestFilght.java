import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.GrayFilter;
public class CheapestFilght {
    

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

    public static void CreateGraph(int fights[][], ArrayList<Edge> graph[]){
        //create empty list on each node
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //create a edge on fights array.
        for(int i=0; i<fights.length; i++){
            int src = fights[i][0];
            int dest = fights[i][1];
            int wt = fights[i][2];

            Edge e = new Edge(src, dest, wt);
            //add this edge in graph
            graph[src].add(e);

        }
    }

    static class info{
        int v;
        int cost;
        int stops;

        public info(int v, int c, int stops){
            this.v = v;
            this.cost = c;
            this.stops = stops;
        }


    }

    public static int CheapestFlight(int n, int src, int dest, int k, int flights[][]){
        ArrayList<Edge> graph[] = new ArrayList[n];
        CreateGraph(flights, graph);

        // we are using dijkstra algorithm.
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){ //make dist. infinity from source to i index elements.
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<info> q = new LinkedList<>();
        q.add(new info(src, 0,0));
        
        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr.stops > k ){ //if number of stops are gratter than k value 
                break;
            }

            for(int i=0; i<graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && curr.stops <= k){
                    dist[v] = wt + dist[u];
                    q.add(new info(v, dist[v], curr.stops+1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }

    public static void main(String arg[]){
        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int scr = 0; int dest = 3; int k = 1;

        System.out.println(CheapestFlight(n, scr, dest, k, flights ));

    }
}
