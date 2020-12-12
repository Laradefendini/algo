

public class Vertex {

    private int id;
    private Color color;
    private boolean activated;

    public Vertex(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public boolean setColor(Color color){
        if (this.color == color){
            return false;
        } else {
            this.color = color;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Vertex " + id + " , " + color;
    }
}
