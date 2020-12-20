public class Main {
    public static void main(String[] args) {



        Graph graph = new Graph();

        Vertex v1 = new Vertex(1, Color.BLUE);
        Vertex v2 = new Vertex(2, Color.BLUE);
        Vertex v3 = new Vertex(3, Color.RED);
        Vertex v4 = new Vertex(4, Color.RED);
        Vertex v5 = new Vertex(5, Color.RED);
        Vertex v6 = new Vertex(6, Color.RED);
        Vertex v7 = new Vertex(7, Color.BLUE);
        Vertex v8 = new Vertex(8, Color.BLUE);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);

        Edge e1 = new Edge(v2, v1, Color.RED);
        Edge e2 = new Edge(v2, v3, Color.BLUE);
        Edge e3 = new Edge(v1, v4, Color.RED);
        Edge e4 = new Edge(v4, v2, Color.RED);
        Edge e5 = new Edge(v4, v5, Color.BLUE);
        Edge e6 = new Edge(v5, v2, Color.BLUE);
        Edge e7 = new Edge(v5, v3, Color.BLUE);
        Edge e8 = new Edge(v4, v6, Color.BLUE);
        Edge e9 = new Edge(v5, v7, Color.BLUE);
        Edge e10 = new Edge(v5, v8, Color.RED);
        Edge e11 = new Edge(v6, v7, Color.RED);
        Edge e12 = new Edge(v7, v8, Color.BLUE);
        Edge e13 = new Edge(v1, v6, Color.RED);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);
        graph.addEdge(e7);
        graph.addEdge(e8);
        graph.addEdge(e9);
        graph.addEdge(e10);
        graph.addEdge(e11);
        graph.addEdge(e12);
        graph.addEdge(e13);

        Graph graph2 = new Graph();

        Vertex v1b = new Vertex(1, Color.BLUE);
        Vertex v2b = new Vertex(2, Color.BLUE);
        Vertex v3b = new Vertex(3, Color.RED);
        Vertex v4b = new Vertex(4, Color.RED);
        Vertex v5b = new Vertex(5, Color.RED);
        Vertex v6b = new Vertex(6, Color.RED);
        Vertex v7b = new Vertex(7, Color.BLUE);
        Vertex v8b = new Vertex(8, Color.BLUE);

        graph2.addVertex(v1b);
        graph2.addVertex(v2b);
        graph2.addVertex(v3b);
        graph2.addVertex(v4b);
        graph2.addVertex(v5b);
        graph2.addVertex(v6b);
        graph2.addVertex(v7b);
        graph2.addVertex(v8b);

        Edge e1b = new Edge(v2b, v1b, Color.RED);
        Edge e2b = new Edge(v2b, v3b, Color.BLUE);
        Edge e3b = new Edge(v1b, v4b, Color.RED);
        Edge e4b = new Edge(v4b, v2b, Color.RED);
        Edge e5b = new Edge(v4b, v5b, Color.BLUE);
        Edge e6b = new Edge(v5b, v2b, Color.BLUE);
        Edge e7b = new Edge(v5b, v3b, Color.BLUE);
        Edge e8b = new Edge(v4b, v6b, Color.BLUE);
        Edge e9b = new Edge(v5b, v7b, Color.BLUE);
        Edge e10b = new Edge(v5b, v8b, Color.RED);
        Edge e11b = new Edge(v6b, v7b, Color.RED);
        Edge e12b = new Edge(v7b, v8b, Color.BLUE);
        Edge e13b = new Edge(v1b, v6b, Color.RED);

        graph2.addEdge(e1b);
        graph2.addEdge(e2b);
        graph2.addEdge(e3b);
        graph2.addEdge(e4b);
        graph2.addEdge(e5b);
        graph2.addEdge(e6b);
        graph2.addEdge(e7b);
        graph2.addEdge(e8b);
        graph2.addEdge(e9b);
        graph2.addEdge(e10b);
        graph2.addEdge(e11b);
        graph2.addEdge(e12b);
        graph2.addEdge(e13b);

        System.out.println(" RESULTAT 1 SEQUENCE ROUGE V1 : " + graph.sequenceRouge());
        System.out.println(" RESULTAT 1 SEQUENCE ROUGE V2 : " + graph2.sequenceRouge2());

    }
}
