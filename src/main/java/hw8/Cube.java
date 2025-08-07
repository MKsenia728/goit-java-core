package hw8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cube extends Shape implements Rotatable, Fillable, Scalable {
    private double side;

    public Cube(Position3D position, double side) {
        super("hw8.Cube", position);
        this.side = side;
    }

    @Override
    public void changeFill(String color) {
        System.out.println("Change fill to " + color);
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
        Position3D pos3D = (Position3D) position;
        System.out.println("hw8.Position " + this.getName() + ": X - " + pos3D.getX() + ", Y: - " + pos3D.getY() + ", Z - " + pos3D.getZ());
        ;
    }
}
