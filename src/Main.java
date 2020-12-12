public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();

        Vertex v1 = new Vertex(1, Color.BLUE);
        Vertex v2 = new Vertex(2, Color.RED);
        Vertex v3 = new Vertex(3, Color.BLUE);
        Vertex v4 = new Vertex(4, Color.BLUE);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        Edge e1 = new Edge(v2, v1, Color.BLUE);
        Edge e2 = new Edge(v2, v3, Color.RED);
        Edge e3 = new Edge(v4, v3, Color.RED);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);

        for(Vertex v : graph.getVertices()){
            System.out.println(v);
        }
/*
        graph.removeVertex(v1);
        for(Vertex v : graph.getVertices()){
            System.out.println(v);
        }*/

        System.out.println("\ndelete v2 :");
        graph.removeVertex(v2);
        for(Vertex v : graph.getVertices()){
            System.out.println(v);
        }
        System.out.println("edges :" + graph.getEdges().size());

        System.out.println("\ndelete v3 :");
        graph.removeVertex(v3);
        for(Vertex v : graph.getVertices()){
            System.out.println(v);
        }
        System.out.println("edges :" + graph.getEdges().size());

    }
}
