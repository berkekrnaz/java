import java.util.*;

public class Graph {
    List<Integer>[] adjList;
int n;
    //Constuctor
    public Graph(int n) {
        adjList = new List[n];
        for (int i = 0; i < n ; i++) {
            adjList[i] = new ArrayList<>();
        }
        this.n = n;
    }
public void addEdge(int src, int dest){
        adjList[src].add(dest);
}

public void removeEdge(int src, int dest) {
        adjList[src].remove(Integer.valueOf(dest));
    }

public void printGraph(){
    for (int i = 0; i <adjList.length; i++) {
        System.out.print((i+"->"));
        for (int item : adjList[i]) {
            System.out.print(item +" ");
        }
        System.out.println();
    }
    System.out.println("------------------------");
}
public void BFS(int start){
        String[] color = new String[n];
        int[] dist = new int[n];
        Integer[] pred = new Integer[n];
    for (int i = 0; i < n; i++) {
        color[i] = "WHITE";
        dist[i] = Integer.MAX_VALUE;
        pred [i] = null;
    }
    color[start] = "GRAY";
    dist[start] = 0;
    pred[start] = null;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    System.out.println("BFS starting from vertex" + start +":");
while(!queue.isEmpty()){
    int u = queue.poll();
        System.out.print(u + "->");
    for (int v : adjList[u]) {
        if(color[v].equals("WHITE")){
            color[v] ="GRAY";
            dist[v] = dist[u] + 1;
            pred [v] = u;
            queue.add(v);
        }
    }
    color [u] = "BLACK";

}
    }
    public void DFS(int start){
String[] color = new String[n];
Integer[] pred = new Integer[n];
        for (int i = 0; i < n; i++) {
            color[i] = "WHITE";
            pred[i] = null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        color[start] = "GRAY";
        System.out.println("DFS starting from vertex" + start +":");
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(color[u].equals("GRAY")){
                System.out.print(u + " ");
                color[u] = "BLACK";
                for (int v:adjList[u]){
                    if (color[v].equals("WHITE")){
                        color[v] = "GRAY";
                        pred[v] = u;
                        stack.push(v);

                    }
                }
            }
        }



    }



    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(3,0);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(4,3);
        graph.addEdge(4,2);
        graph.printGraph();


        graph.printGraph();
        graph.DFS(4);
    }
}