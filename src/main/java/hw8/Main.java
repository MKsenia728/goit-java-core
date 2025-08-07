package hw8;

public class Main {
    public static void main(String[] args) {
        GetInfo.getName(new Circle(new Position(10, 15.2), 15));
        GetInfo.getName(new Cube(new Position3D(12, 5.222, 30), 22));
        GetInfo.getName(new Line(new Position(10, 5), 30));
        GetInfo.getName(new Quad(new Position(0, 0), 25));
        GetInfo.getName(new Point(new Position(22, 34)));
    }
}
