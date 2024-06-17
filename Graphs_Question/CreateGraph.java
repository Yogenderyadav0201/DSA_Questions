import java.util.*;
public class CreateGraph{

    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.dest= d;
            this.src = s;
            this.wt = w;
        }
    }
    public static void main(String arg[]){

        int V=5;
        //Create the graph.
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];  //this is null graph so we want to create the in empty graph.

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>(); //create new arraylist for storing the edage.
        }

        //0  ->   vertex.
        graph[0].add(new Edge(0, 1, 5));

        //1   ->  vertex.
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2   ->  vertex.
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //3  -> vertex.
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        //4  -> vertex.
        graph[4].add(new Edge(4, 2, 2));

        //2's nightbors
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
           
        }

    }
}