public class Edge {

    private Vertex origin, destination;
    private Color color;

    public Edge(Vertex origin, Vertex destination, Color color) {
        this.destination = destination;
        this.origin = origin;
        this.color = color;
    }

    public boolean changeDestinationColor() {
        return destination.setColor(this.color);
    }

    public Vertex getOrigin() {
        return origin;
    }

    public Vertex getDestination() {
        return destination;
    }
}
