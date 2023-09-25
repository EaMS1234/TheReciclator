package thereciclator;

import static java.lang.Math.sqrt;

// Class that represents a 2D vector
public class Vector2 {
    public double x = 0;
    public double y = 0;
    
    // Turns the vector into an unit vector
    public void normalize() {
        x = x / sqrt((x * x) + (y * y));
        y = y / sqrt((x * x) + (y * y));
    }
}