
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Circle extends Shape implements Fillable, Rotatable, Scalable {
    private double radius;

    public Circle(Position position, double radius) {
        super("Circle", position);
        this.radius = radius;
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
    public void rotate(int degrees) {
        Rotatable.super.rotate(degrees);
    }

    @Override
    public void doRotate(int degrees) {
        System.out.println("Rotation on: " + degrees + "grad");
    }

    @Override
    public void scale(double coefficient) {
        setRadius(this.radius * coefficient);
        System.out.println("New radius: " + this.radius);
    }

    @Override
    public void printPosition() {
        System.out.println("Position " + this.getName() + ": X - " + this.position.getX() + ", Y: - " + this.position.getY());
    }
}
