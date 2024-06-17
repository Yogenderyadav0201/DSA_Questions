import java.util.ArrayList;

public class UndirGraphUsingDFS {
    
    static class  Edge{
        int src; 
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean cycleDect(ArrayList<Edge>[] graph){
        boolean visit[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                if(DectUtils(graph, visit, i, -1)){ //graph, visited array,  current element,  parent of surrent element that is -1.
                    return true;//cycle is present in graph one of the parts.
                }
                
            }
        }
        
        return false;
    }

    public static boolean DectUtils(ArrayList<Edge>[] graph, boolean visit[], int curr, int par){
         visit[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                if(DectUtils(graph, visit, e.dest, curr)){
                    return true;
                }

            }

            else if(visit[e.dest] && e.dest != par){
                return true;
            }
        }

        return false;
    }

    public static void main(String arg[]){
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);
        System.out.println(cycleDect(graph));
    }
}
