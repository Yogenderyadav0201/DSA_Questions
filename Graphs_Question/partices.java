// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class partices {
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

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>(); //create new arraylist for storing the edage.
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(1, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));


        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));


        graph[6].add(new Edge(6, 5, 1));
    }
    
    public static void BSF(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int j=0; j<graph[curr].size(); j++){
                    Edge e = graph[curr].get(j);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        System.out.print(curr+" ");
        
        // step-1 make curr true in visted array
        vis[curr] = true;
        //step-2 get the nightbors of the curr element in graph
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //step-3 check the nighbors of curr are visited and not
            if(!vis[e.dest]){//if not visited than we call DFS function again
                DFS(graph, e.dest, vis);
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);
        BSF(graph);
        System.out.println();
        System.out.println("#####################");
        DFS(graph, 0, new boolean[V]);
        System.out.println();
    }
}