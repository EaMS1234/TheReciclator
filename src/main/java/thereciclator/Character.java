package thereciclator;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Class that represents a moving character
public class Character {
    // Character Coordinates
    public double x = 0;
    public double y = 0;
    
    // Character elements
    private Pane container;
    private ImageView sprite;
    
    public Character(Pane container, ImageView sprite) {
        this.container = container;
        this.sprite = sprite;
    }
    
    // Moves the character around
    private void move(Vector2 vector) {
        this.x += vector.x;
        this.y += vector.y;
    }
}
