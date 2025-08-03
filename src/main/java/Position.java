import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
