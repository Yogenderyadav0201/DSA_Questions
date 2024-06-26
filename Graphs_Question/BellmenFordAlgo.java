import java.util.ArrayList;

public class BellmenFordAlgo {
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

        graph[1].add(new Edge(1 ,2, -4));

        graph[2].add(new Edge(2 ,3, 2));

        graph[3].add(new Edge(3 ,4, 4));

        graph[4].add(new Edge(4 ,1, -1));
   

    }

    public static void BellmenFordAlgoFunction(ArrayList<Edge>[] graph, int src, int V){ //O(V+E)
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<V-1; i++){ 
            //find the edges of the graph
            for(int j=0; j<graph.length; j++){ //first find the all verties
                for(int k=0; k<graph[j].size(); k++){ //send find the ages of the that verties.
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;  
                    //this called relexation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // update the distance of scr to v;
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        //print the distance
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+ " ");
        }

    }

    public static void main(String arg[]){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        CreateGraph(graph);

       int src = 0;
       BellmenFordAlgoFunction(graph, src, V);
       System.out.println();
    }
}
