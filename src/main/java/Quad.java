import lombok.Setter;

@Setter
public class Quad extends Shape implements Moveable, Fillable, Rotatable, Scalable{
    private Position position;
    private double side;

    public Quad(Position position, double side) {
        super("Quad", position);
        this.position = position;
        this.side = side;
    }

    @Override
    public void changeFill(String color) {
        System.out.println("Change fill to " + color);
    }

    @Override
    public Position move(Position position) {
        System.out.println("New position: " + position);
        return position;
    }

    @Override
    public void doRotate(int degrees) {
        System.out.println("Rotation on: " + degrees + "grad");
    }

    @Override
    public void scale(double coefficient) {
        setSide(this.side * coefficient);
        System.out.println("New side: " + this.side);
    }

    @Override
    public void printPosition() {
        System.out.println("Position " + this.getName() + ": X - " + this.position.getX() + ", Y: - " + this.position.getY());
    }
}
