package hw8;

public interface Rotatable {
    default void rotate(int degrees) {
        if (degrees < -360 || degrees > 360) {
            throw new IllegalArgumentException("Rotation angle must be between -360 and 360 degrees.");
        }
        doRotate(degrees);
    }

    void doRotate(int degrees);
}
