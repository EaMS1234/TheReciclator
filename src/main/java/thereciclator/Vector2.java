package thereciclator;

import static java.lang.Math.sqrt;

// Class that represents a 2D vector
public class Vector2 {
    public double x = 0;
    public double y = 0;
    
    // Turns the vector into an unit vector
    public void normalize() {
        if (x == 0 && y == 0) {
            x = 0;
            y = 0;
        } else {
            x = x / sqrt((x * x) + (y * y));
            y = y / sqrt((x * x) + (y * y));
        }
    }
    
    // Multiplies the vector by n
    public void multiply(int n) {
        x = x * n;
        y = y * n;
    }
    
    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
