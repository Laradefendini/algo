
import java.util.*;

public class Graph {

    private List<Edge> edges;
    private List<Vertex> vertices;
    protected Map<Vertex, List<Vertex>> adjacencyList;
    int nbRed = 0;

    public Graph() {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        adjacencyList = new HashMap<>();
    }


    //// ---- GETTERS ---- ////

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public int getNbRed() {
        return nbRed;
    }

    /// ---- CONSTRUCTION GRAPH ---- ////

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjacencyList.put(v, new LinkedList<>());
        if (v.getColor() == Color.RED) nbRed++;
    }

    public void addVertex(int id, Color color) {
        addVertex(new Vertex(id, color));
    }

    public void addEdge(Edge edge) {
        if (vertices.size() - edges.size() > 1 && !hasTwoAdjacents(edge.getOrigin()) && !hasTwoAdjacents(edge.getDestination())) {

            edges.add(edge);

            // On ajoute chacune des deux vertex dans la liste des voisins de l'autre
            adjacencyList.get(edge.getOrigin()).add(edge.getDestination());
            adjacencyList.get(edge.getDestination()).add(edge.getOrigin());

        } else {
            System.out.println("You can't add this edge because there would be too much edges.");
        }
    }

    private boolean hasTwoAdjacents(Vertex vertex) {
        return adjacencyList.get(vertex).size() == 2;
    }

    public void addEdge(Vertex inVertex, Vertex outVertex, Color color) {
        addEdge(new Edge(inVertex, outVertex, color));
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

            Iterator<Vertex> i = vertices.iterator();
            while (i.hasNext()) {
                Vertex vertex = i.next();
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
