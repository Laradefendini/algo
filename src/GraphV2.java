
import java.util.*;

public class GraphV2 {

    private List<Edge> edges;
    private List<Vertex> vertices;
    private Vertex vertex;
    private Edge edge;
    //protected Map<Vertex, List<Vertex>> adjacencyList;
    private int nbRed = 0;

    private int remainingWeight5 = 0;
    private int remainingWeight4 = 0;
    private int remainingWeight3 = 0;
    private int remainingWeight2 = 0;
    private int remainingWeight1 = 0;
    private int remainingWeight0 = 0;


    public GraphV2() {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        //adjacencyList = new HashMap<>();
    }

    public GraphV2(int nbVertex, double p, double q) {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        //adjacencyList = new HashMap<>();

        for (int i = 0; i < nbVertex; i++) {
            boolean redVertex = new Random().nextDouble() <= p;
            Color colorVertex = Color.BLUE;
            if (redVertex)
                colorVertex = Color.RED;
            vertex = new Vertex(i, colorVertex);
            //this.vertices.add(vertex);
            addVertex(vertex);
        }

        for (Vertex v : vertices) {
            for (int i = 1; i < nbVertex; i++) {
                boolean blueEdge = new Random().nextDouble() <= q;
                Color colorEdge = Color.RED;
                if (blueEdge)
                    colorEdge = Color.BLUE;
                this.edge = new Edge(v, vertices.get(i), colorEdge);
                //this.edges.add(edge);
                addEdge(edge);
            }
        }
    }

    public GraphV2(int nbVertex, int nbRondROuge, int nbFlecheBleu) {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
        //adjacencyList = new HashMap<>();

        for (int i = 0; i < nbVertex; i++) {
            if(i<nbRondROuge)
                vertex = new Vertex(i, Color.RED);
            else
                vertex = new Vertex(i, Color.BLUE);
            //this.vertices.add(vertex);
            addVertex(vertex);
        }

        for (Vertex v : vertices) {
            for (int i = 1; i < nbVertex; i++) {
                if(i<nbFlecheBleu)
                    edge = new Edge(v, vertices.get(i), Color.BLUE);
                else
                    edge = new Edge(v, vertices.get(i), Color.RED);

                //this.edges.add(edge);
                addEdge(edge);
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
        //adjacencyList.put(v, new LinkedList<>());
        if (v.getColor() == Color.RED) nbRed++;
    }

    public void addVertex(int id, Color color) {
        addVertex(new Vertex(id, color));
    }

    public void addEdge(Edge edge) {
        //if (vertices.size() - edges.size() > 1 && !hasTwoAdjacents(edge.getOrigin()) && !hasTwoAdjacents(edge.getDestination())) {

        edges.add(edge);

        // On ajoute chacune des deux vertex dans la liste des voisins de l'autre
        //adjacencyList.get(edge.getOrigin()).add(edge.getDestination());
        //adjacencyList.get(edge.getDestination()).add(edge.getOrigin());

        //} else {
        //System.out.println("You can't add this edge because there would be too much edges.");
        //}
    }

    //private boolean hasTwoAdjacents(Vertex vertex) {
//        return adjacencyList.get(vertex).size() == 2;
//    }

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

//            for (Vertex vertex : adjacencyList.get(v)) {
//                adjacencyList.get(vertex).remove(v);
//            }
            for(Edge edge : edges){
                if(edge.getDestination().equals(v)){
                    edges.remove(edge);
                    decreaseWeight(edge.getOrigin());
                    attributeWeight(edge.getOrigin());
                }
                if( edge.getOrigin().equals(v)){
                    edges.remove(edge);
                    decreaseWeight(edge.getDestination());
                    attributeWeight(edge.getDestination());
                }

            }

            vertices.remove(v);

            // ADAPTATIONS

//            for (Vertex vertex : adjacencyList.get(v)) {
//                decreaseWeight(vertex);
//                attributeWeight(vertex);
//            }

            decreaseWeight(v);
            //adjacencyList.remove(v);

            if (v.getColor() == Color.RED) nbRed--;

            System.out.println("Vertex removed : " + v.getId() + " Weight =" + v.getWeight());

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


    //// ---- CALCUL POIDS ---- ////

    public void attributeAllWeights() {
        Iterator<Vertex> i = vertices.iterator();
        while (i.hasNext()) {

            Vertex vertex = i.next();
            attributeWeight(vertex);

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

    public void decreaseWeight(Vertex vertex) {
        switch (vertex.getWeight()) {
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


    //// ---- METHODES UTILITAIRES ---- ////


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

}

