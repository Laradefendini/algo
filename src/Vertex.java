

public class Vertex {

    private int id;
    private Color color;
    private boolean activated;
    private int weight;

    public Vertex(int id, Color color) {
        this.id = id;
        this.color = color;
        this.weight = -1;
    }

    public int getId() {
        return id;
    }

    public boolean isRed(){ return color == Color.RED;}

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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Vertex " + id + " , " + color;
    }
}
