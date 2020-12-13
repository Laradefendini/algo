public class Moyenne {

    private double average;

    public Moyenne(int nbVertices, double p , double q) {
        average = averageFor100Graphs(nbVertices, p, q);
    }

    public double getAverage() {
        return average;
    }

    public double averageFor100Graphs(int nbVertices, double p, double q){
        for(int i = 0 ; i<100 ; i++){
            Graph graph = new Graph(nbVertices, p, q);
            average += graph.sequenceRouge2();
        }

        return average/100;

    }
}
