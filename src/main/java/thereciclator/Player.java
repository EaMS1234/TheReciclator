package thereciclator;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Class that represents a player
public class Player extends Character {
    public Player(Pane container, ImageView sprite) {
        super(container, sprite);
    }
    
    public void input() {
        Vector2 velocity = new Vector2();
       
        // TODO: REPLACE THIS SECTION WITH AN ACTUAL KEY PRESS HANDLER
        velocity.x = 1;
        velocity.y = 1;
        
        velocity.normalize();
        move(velocity);
    }
}
