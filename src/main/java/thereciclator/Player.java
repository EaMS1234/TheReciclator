package thereciclator;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

// Class that represents a player
public class Player extends Character {
    // Character base movement speed
    public int speed = 1;
    
    public Player(Pane container, ImageView sprite, int speed) {
        super(container, sprite);
        this.speed = speed;
    }
    
    Vector2 velocity = new Vector2();
    
    public void input(KeyCode key) {
        switch (key) {
            case LEFT:
                velocity.x = -1;
                velocity.y = 0;
                break;
            
            case RIGHT:
                velocity.x = 1;
                velocity.y = 0;
                break;
            
            case UP:
                velocity.x = 0;
                velocity.y = -1;
                break;
                
            case DOWN:
                velocity.x = 0;
                velocity.y = 1;
                break;
        
            default:
                velocity.x = 0;
                velocity.y = 0;
                break;
        }
        
        // Moves the player around
        velocity.normalize();
        velocity.multiply(speed);
        move(velocity);
    }
}
