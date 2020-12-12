public class Main2 {
    public static void main(String[] args) {

        GraphExo5 graph = new GraphExo5(20, 0.1, 0.9);


        for(Vertex v : graph.getVertices()){
            System.out.println(v);
        }

       // System.out.println("edges :" + graph.getEdges().size());


//        for (Edge e : graph.getEdges()) {
//            System.out.println(e);
//        }
    }
}
