public class Moyenne {

    private double average;

    public Moyenne(int nbVertices, double p, double q, boolean version2) {
        if (version2)
            average = averageFor100GraphsV2(nbVertices, p, q);
        else
            average = averageFor100Graphs(nbVertices, p, q);
    }

    public double getAverage() {
        return average;
    }

    public double averageFor100Graphs(int nbVertices, double p, double q) {
        for (int i = 0; i < 100; i++) {
            Graph graph = new Graph(nbVertices, p, q);
            average += graph.sequenceRouge();
        }
        return average / 100;
    }

    public double averageFor100GraphsV2(int nbVertices, double p, double q) {
        for (int i = 0; i < 100; i++) {
            Graph graph = new Graph(nbVertices, p, q);
            average += graph.sequenceRouge2();
        }
        return average / 100;
    }

}
