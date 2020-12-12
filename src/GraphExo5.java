
import java.util.*;

public class GraphExo5 {

    private List<Edge> edges;
    private List<Vertex> vertices;
    private Vertex vertex;
    private Edge edge;
    protected Map<Vertex, List<Vertex>> adjacencyList;
    int nbRed = 0;


    public GraphExo5(int nbVertex, double p, double q) {


        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        adjacencyList = new HashMap<>();

        for(int i=0; i<nbVertex; i++){
            boolean redVertex = new Random().nextDouble() <= p;
            Color colorVertex = Color.BLUE;
            if(redVertex)
                colorVertex = Color.RED;
            vertex = new Vertex(i, colorVertex);
            //this.vertices.add(vertex);
            addVertex(vertex);
        }

        for(Vertex v : vertices){
            for(int i=1; i<nbVertex; i++){
                boolean blueEdge = new Random().nextDouble() <= q;
                Color colorEdge = Color.RED;
                if(blueEdge)
                    colorEdge = Color.BLUE;
                this.edge = new Edge(v, vertices.get(i), colorEdge);
                this.edges.add(edge);
                //addEdge(edge);
            }


        }



    }


    //// ---- GETTERS ---- ////

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }


    /// ---- CONSTRUCTION GRAPH ---- ////

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjacencyList.put(v, new LinkedList<>());
        if (v.getColor() == Color.RED) nbRed++;
    }



    private boolean hasTwoAdjacents(Vertex vertex) {
        return adjacencyList.get(vertex).size() == 2;
    }



    /// ---- SUPPRESSION VERTEX ---- ////

    public void removeVertex(Vertex v) {

        if (v.getColor() == Color.RED) { // On ne peut supprimer que les rouges

            Iterator<Edge> i = edges.iterator();
            while (i.hasNext()) {
                Edge e = i.next();
                if (e.getOrigin() == v) {
                    changeDestinationColor(e);
                    i.remove();
                } else if (e.getDestination() == v) {
                    i.remove();
                }
            }

            for (Vertex vertex : adjacencyList.get(v)) {
                adjacencyList.get(vertex).remove(v);
            }

            vertices.remove(v);
            adjacencyList.remove(v);

            if (v.getColor() == Color.RED) nbRed--;

        } else {
            System.out.println("You can't delete a blue vertex.");
        }
    }

    private void changeDestinationColor(Edge e) {
        if (e.changeDestinationColor()) {
            if (e.getDestination().getColor() == Color.BLUE) {
                nbRed--;
            } else {
                nbRed++;
            }
        }
    }


    /// ---- METHODES ---- ////

    private int sequenceRouge() {
        int size = 0;

        while (nbRed > 0) {
            for (Vertex vertex : vertices) {
                if (vertex.getColor() == Color.RED && !hasOutEdge(vertex))
                    removeVertex(vertex);
            }


        }

        return size;
    }

    public boolean hasOutEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex)
                return true;
        }
        return false;
    }
}
