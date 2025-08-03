import lombok.Setter;

@Setter
public class Line extends Shape implements Moveable, Rotatable, Scalable {
    private double length;

    public Line(Position position, double length) {
        super("Line", position);
        this.length = length;
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
        setLength(this.length * coefficient);
        System.out.println("New length: " + this.length);
    }

    @Override
    public void printPosition() {
        System.out.println("Position " + this.getName() + ": X - " + this.position.getX() + ", Y: - " + this.position.getY());
    }
}
