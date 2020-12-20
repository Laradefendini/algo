
import java.util.*;

public class Graph {

    private List<Edge> edges;
    private List<Vertex> vertices;
    protected Map<Vertex, List<Vertex>> adjacencyList;
    private int nbRed = 0;

    private int remainingWeight9 = 0;
    private int remainingWeight8 = 0;
    private int remainingWeight7 = 0;
    private int remainingWeight6 = 0;
    private int remainingWeight5 = 0;
    private int remainingWeight4 = 0;
    private int remainingWeight3 = 0;
    private int remainingWeight2 = 0;
    private int remainingWeight1 = 0;
    private int remainingWeight0 = 0;


    //// ---- CONSTRUCTORS ---- ////


    public Graph() {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        adjacencyList = new HashMap<>();
    }

    /**
     * Constructor for QUESTION 5
     * @param nbVertices the number of vertices in the graph. In the case of question 5, it will always be 100.
     * @param p probability for a vertex to be red
     * @param q probability for an edge to be blue
     */
    public Graph(int nbVertices, double p, double q) {


        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        adjacencyList = new HashMap<>();

        for (int i = 0; i < nbVertices; i++) {
            boolean redVertex = new Random().nextDouble() <= p;
            Color colorVertex = Color.BLUE;
            if (redVertex)
                colorVertex = Color.RED;
            //this.vertices.add(vertex);
            addVertex(new Vertex(i, colorVertex));
        }

        for (Vertex v : vertices) {
            for (int i = 0; i < nbVertices; i++) {
                if (!v.equals(vertices.get(i))) {
                    boolean blueEdge = new Random().nextDouble() <= q;
                    Color colorEdge = Color.RED;
                    if (blueEdge)
                        colorEdge = Color.BLUE;

                    //this.edges.add(new Edge(v, vertices.get(i), colorEdge));
                    addEdge(new Edge(v, vertices.get(i), colorEdge));
                }
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

        edges.add(edge);

        // We add the destination vertex in the adjacency list of the origin vertex
        adjacencyList.get(edge.getOrigin()).add(edge.getDestination());

    }


    public void addEdge(Vertex inVertex, Vertex outVertex, Color color) {
        addEdge(new Edge(inVertex, outVertex, color));
    }


    /// ---- SUPPRESSION VERTEX ---- ////

    /**
     * Useful method for first algorithm in QUESTION 4.
     * It removes a vertex and makes all the necessary adaptations.
     * @param v the vertex we want to remove
     */
    private void removeVertex(Vertex v) {

        if (v.getColor() == Color.RED) { // On ne peut supprimer que les rouges

            Iterator<Edge> i = edges.iterator();
            while (i.hasNext()) {
                Edge e = i.next();
                if (e.getOrigin() == v) {
                    changeDestinationColor(e);
                    i.remove();
                } else if (e.getDestination() == v) {
                    Vertex origin = e.getOrigin();
                    i.remove();
                    adjacencyList.get(origin).remove(v);

                    // adaptation
                    decreaseWeight(origin);
                    attributeWeight(origin);

                }
            }

            vertices.remove(v);

            // ADAPTATIONS

            for (Vertex vertex : adjacencyList.get(v)) {
                decreaseWeight(vertex);
                attributeWeight(vertex);
            }

            decreaseWeight(v);
            adjacencyList.remove(v);

            if (v.getColor() == Color.RED) nbRed--;

            //System.out.println("Vertex removed : " + v.getId());

        } else {
            System.out.println("You can't delete a blue vertex.");
        }

    }

    /**
     * Useful method for second algorithm in QUESTION 4.
     * @param v the vertex we want to remove
     */
    private void removeVertex2(Vertex v) {

        if (v.getColor() == Color.RED) { // On ne peut supprimer que les rouges

            Iterator<Edge> i = edges.iterator();
            while (i.hasNext()) {
                Edge e = i.next();
                if (e.getOrigin() == v) {
                    changeDestinationColor(e);
                    i.remove();
                } else if (e.getDestination() == v) {
                    Vertex origin = e.getOrigin();
                    i.remove();
                    adjacencyList.get(origin).remove(v);

                    // adaptation
                    decreaseWeight(origin);
                    attributeWeight2(origin);

                }
            }

            vertices.remove(v);

            // ADAPTATIONS

            for (Vertex vertex : adjacencyList.get(v)) {
                decreaseWeight(vertex);
                attributeWeight2(vertex);
            }

            decreaseWeight(v);
            adjacencyList.remove(v);

            if (v.getColor() == Color.RED) nbRed--;

            //System.out.println("Vertex removed : " + v.getId());

        } else {
            System.out.println("You can't delete a blue vertex.");
        }

    }




    //// ---- CALCUL POIDS ---- ////

    /**
     * Useful method for first algorithm in QUESTION 4.
     * It attributes all the weights to the vertices at the beginning of the "SequenceRouge1" program
     */
    public void attributeAllWeights() {
        Iterator<Vertex> i = vertices.iterator();
        while (i.hasNext()) {

            Vertex vertex = i.next();
            attributeWeight(vertex);

        }
    }

    /**
     * Useful method for second algorithm in QUESTION 4.
     * It attributes all the weights to the vertices at the beginning of the "SequenceRouge1" program
     */
    public void attributeAllWeights2() {
        Iterator<Vertex> i = vertices.iterator();
        while (i.hasNext()) {

            Vertex vertex = i.next();
            attributeWeight2(vertex);

        }
    }

    public void attributeWeight(Vertex vertex) {

        if (vertex.isRed() && !hasOutEdge(vertex)) {
            vertex.setWeight(5);
            remainingWeight5++;
        } else if (vertex.isRed() && !hasBlueOutEdge(vertex)) {
            vertex.setWeight(4);
            remainingWeight4++;
        } else if (vertex.isRed() && hasBlueInEdge(vertex)) {
            vertex.setWeight(3);
            remainingWeight3++;
        } else if (vertex.isRed() && hasBlueOutEdge(vertex) && hasRedOutEdge(vertex)) {
            vertex.setWeight(2);
            remainingWeight2++;
        } else if (vertex.isRed()) {
            vertex.setWeight(1);
            remainingWeight1++;
        } else if (!vertex.isRed()) {
            vertex.setWeight(0);
            remainingWeight0++;
        }
    }

    public void attributeWeight2(Vertex vertex) {
        if (vertex.isRed()) {
            if (!hasOutEdge(vertex)) {
                vertex.setWeight(9);
                remainingWeight9++;
            } else {
                if (hasBtoB(vertex) && !hasBtoR(vertex) && hasBlueInEdge(vertex) && !hasRtoR(vertex)) {
                    vertex.setWeight(8);
                    remainingWeight8++;
                } else if (hasBtoB(vertex) && !hasBtoR(vertex) && hasBlueInEdge(vertex)) {
                    vertex.setWeight(7);
                    remainingWeight7++;
                } else if (!hasBtoR(vertex) && hasBlueInEdge(vertex) && !hasRtoR(vertex)) {
                    vertex.setWeight(6);
                    remainingWeight6++;
                } else if (!hasBtoR(vertex) && hasBlueInEdge(vertex)) {
                    vertex.setWeight(5);
                    remainingWeight5++;
                } else if (hasOnlyBlueInEdge(vertex) && hasOnlyRedOutEdge(vertex)) {
                    vertex.setWeight(4);
                    remainingWeight4++;
                } else if (hasOnlyRedOutEdge(vertex)) {
                    vertex.setWeight(3);
                    remainingWeight3++;
                } else if (hasRedOutEdge(vertex)) {
                    vertex.setWeight(2);
                    remainingWeight2++;
                } else {
                    vertex.setWeight(1);
                    remainingWeight1++;
                }
            }
        } else {
            vertex.setWeight(0);
            remainingWeight0++;
        }
    }


    public void decreaseWeight(Vertex vertex) {
        switch (vertex.getWeight()) {
            case 9:
                remainingWeight9--;
                break;
            case 8:
                remainingWeight8--;
                break;
            case 7:
                remainingWeight7--;
                break;
            case 6:
                remainingWeight6--;
                break;
            case 5:
                remainingWeight5--;
                break;
            case 4:
                remainingWeight4--;
                break;
            case 3:
                remainingWeight3--;
                break;
            case 2:
                remainingWeight2--;
                break;
            case 1:
                remainingWeight1--;
                break;
            case 0:
                remainingWeight0--;
                break;
        }
    }


    //// ---- SEQUENCE ROUGE ---- ////

    public int sequenceRouge2() {
        int initialSize = vertices.size();

        attributeAllWeights2();

        while (nbRed > 0) {

            Iterator<Vertex> i = vertices.iterator();
            while (i.hasNext()) {
                Vertex vertex = i.next();

                if (remainingWeight9 != 0) {
                    if (vertex.getWeight() == 9) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight8 != 0) {
                    if (vertex.getWeight() == 8) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight7 != 0) {
                    if (vertex.getWeight() == 7) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight6 != 0) {
                    if (vertex.getWeight() == 6) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight5 != 0) {
                    if (vertex.getWeight() == 5) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight4 != 0) {
                    if (vertex.getWeight() == 4) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight3 != 0) {
                    if (vertex.getWeight() == 3) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight2 != 0) {
                    if (vertex.getWeight() == 2) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight1 != 0) {
                    if (vertex.getWeight() == 1) {
                        removeVertex2(vertex);
                        break;
                    }
                } else if (remainingWeight0 == vertices.size()) {
                    System.out.println("ok");
                }
            }
        }
        return initialSize - vertices.size();
    }

    public int sequenceRouge() {
        int initialSize = vertices.size();

        attributeAllWeights();

        while (nbRed > 0) {

            Iterator<Vertex> i = vertices.iterator();
            while (i.hasNext()) {
                Vertex vertex = i.next();

                if (remainingWeight5 != 0) {
                    if (vertex.getWeight() == 5) {
                        removeVertex(vertex);
                        break;
                    }
                } else if (remainingWeight4 != 0) {
                    if (vertex.getWeight() == 4) {
                        removeVertex(vertex);
                        break;
                    }
                } else if (remainingWeight3 != 0) {
                    if (vertex.getWeight() == 3) {
                        removeVertex(vertex);
                        break;
                    }
                } else if (remainingWeight2 != 0) {
                    if (vertex.getWeight() == 2) {
                        removeVertex(vertex);
                        break;
                    }
                } else if (remainingWeight1 != 0) {
                    if (vertex.getWeight() == 1) {
                        removeVertex(vertex);
                        break;
                    }
                } else if (remainingWeight0 == vertices.size()) {
                    System.out.println("ok");
                }
            }
        }
        return initialSize - vertices.size();
    }


    //// ---- USEFUL TOOL METHODS ---- ////

    /**
     * To change the color of the destination vertex of the edge e
     * @param e the edge we want to change the destination color
     */
    private void changeDestinationColor(Edge e) {
        if (e.changeDestinationColor()) {
            if (e.getDestination().getColor() == Color.BLUE) {
                nbRed--;
            } else {
                nbRed++;
            }
        }
    }


    public boolean hasOutEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex)
                return true;
        }
        return false;
    }

    public boolean hasInEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getDestination() == vertex)
                return true;
        }
        return false;
    }

    public boolean hasBlueOutEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && !edge.isRed())
                return true;
        }
        return false;
    }

    public boolean hasBtoB(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && !edge.isRed() && !edge.getDestination().isRed())
                return true;
        }
        return false;
    }

    public boolean hasBtoR(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && !edge.isRed() && edge.getDestination().isRed())
                return true;
        }
        return false;
    }

    public boolean hasRtoR(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && edge.isRed() && edge.getDestination().isRed())
                return true;
        }
        return false;
    }


    public boolean hasRedOutEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && edge.isRed())
                return true;
        }
        return false;
    }

    public boolean hasBlueInEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getDestination() == vertex && !edge.isRed())
                return true;
        }
        return false;
    }

    public boolean hasOnlyBlueInEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getDestination() == vertex && edge.isRed())
                return false;
        }
        return true;
    }

    public boolean hasOnlyRedOutEdge(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getOrigin() == vertex && !edge.isRed())
                return false;
        }
        if (hasRedOutEdge(vertex)) {
            return true;
        }
        return false;
    }


}
