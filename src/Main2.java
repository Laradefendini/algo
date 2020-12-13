public class Main2 {
    public static void main(String[] args) {

        GraphV2 graph = new GraphV2(6, 3, 2);


//        System.out.println(graph.getEdges().size());
//        System.out.println(graph.getVertices().size());
//        for(Vertex v : graph.getVertices()){
//            System.out.println(v);
//        }

        System.out.println("Taille de la séquence rouge :" + graph.sequenceRouge());



       // System.out.println("edges :" + graph.getEdges().size());


//        for (Edge e : graph.getEdges()) {
//            System.out.println(e);
//        }
    }
}
