package hw8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position3D extends Position {
    private double z;

    public Position3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
}

