package hw8;

import lombok.Setter;

@Setter
public class Point extends Shape implements Moveable {

    public Point(Position position) {
        super("hw8.Point", position);
    }

    @Override
    public Position move(Position position) {
        System.out.println("New position: " + position);
        return position;
    }

    @Override
    public void printPosition() {
        System.out.println("hw8.Position " + this.getName() + ": X - " + this.position.getX() + ", Y: - " + this.position.getY());
    }
}
