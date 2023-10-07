package thereciclator;

import static java.lang.Math.sin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enemy extends Character {

    public String type;
    private Vector2 velocity = new Vector2();
    
    public Enemy(Pane container, ImageView sprite, String type) {
        super(container, sprite);
        
        this.type = type;
    }
    
    // private int frame = 0;
    
    public void pattern() {
        // Which movement pattern will the enemy follow
        switch(this.type) {
            case "line":
                velocity.y = this.x * 0.0005;
                velocity.x = -1;
                break;
                
            case "inverseLine":
                velocity.y = this.x * -0.0005;
                velocity.x = -1;
                break;
            
            case "arc":
                velocity.y = ((this.x / 640) - 1) * ((this.x / 640) - 1);
                velocity.x = -1;
                break;
            
            case "inverseArc":
                velocity.y = ((this.x / 640) - 1) * ((this.x / 640) - 1) * -1;
                velocity.x = -1;
                break;
            
            case "sine":
                velocity.y = sin(this.x * 0.1);
                velocity.x = -1;
                break;
                
            default:
                break;
        }
        
        velocity.normalize();
        velocity.multiply(5);
        this.move(velocity);
        
        // frame++;
    }
}
