import java.util.ArrayList;

public class AllPathsSRCTraget {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph){ // Exponintional time complexty. 
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2 ,3));
        graph[3].add(new Edge(3 ,1));

        graph[4].add(new Edge(4 ,0));
        graph[4].add(new Edge(4 ,1));
        
        graph[5].add(new Edge(5 ,0));
        graph[5].add(new Edge(5 ,2));

    }

    public static void ShortesPath(ArrayList<Edge>[] graph, int src, int dest, String path){
        // this is base case.
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        // if src and dest is not equal than we try to find the dist using the nighbors of src elements
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            ShortesPath(graph, e.dest, dest, path+src);
        }
    }


    public static void main(String arg[]){

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        CreateGraph(graph);
        ShortesPath(graph, 5, 1, "");
    
    }
}
