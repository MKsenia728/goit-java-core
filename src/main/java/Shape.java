import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shape implements Drawable, Moveable {
    private final String name;
    private String textColor;
    protected Position position;

    public Shape(String name, Position position) {
        this.name = name;
        this.textColor = "red";
        this.position = position;
    }

    public String printName() {
        return this.name;
    }

    @Override
    public void printPosition() {
    }

    @Override
    public Position move(Position position) {
        return null;
    }
}
