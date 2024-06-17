import java.util.*;
public class TopologicalSortngBFS {
    
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2 ,3));
        graph[3].add(new Edge(3 ,1));

        graph[4].add(new Edge(4 ,0));
        graph[4].add(new Edge(4 ,1));
        
        graph[5].add(new Edge(5 ,0));
        graph[5].add(new Edge(5 ,2));

    }

    public static void calIndeg(ArrayList<Edge>[] graph, int[] indeg){
        for(int i=0; i<graph.length; i++){
            int vertex = i;
            for(int j=0; j<graph[vertex].size(); j++){
                Edge e = graph[vertex].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        //step-1 calculate the indegree of the all nodes
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        //step-2 add element in queue who's indeg is zero.
        Queue<Integer> q=new LinkedList<>();

        for(int i=0 ;i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }


        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            //step-3 curr nighbors decrease the indeg value
            for(int j=0; j<graph[curr].size(); j++){
                Edge e = graph[curr].get(j);
                indeg[e.dest]--;
                //step-4 if destination element also zero indeg we wll add i queue. 
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String arg[]){

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        CreateGraph(graph);

        topSort(graph);
        System.out.println();
    }
}



