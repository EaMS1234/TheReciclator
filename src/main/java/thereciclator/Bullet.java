package thereciclator;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullet extends Character {
    public int speed;
    
    public Bullet(Pane container, ImageView sprite, int speed) {
        super(container, sprite);
    
        this.speed = speed;
    }
    
    public void move() {
        this.x += speed;
        container.setLayoutX(x);
        
        // checks if the object is out of the screen
        if (container.getLayoutX() < -512 || container.getLayoutX() > 1792 || container.getLayoutY() < -512 || container.getLayoutY() > 1232) {            
            if (canBeOffScreen == false && container.getParent() != null) {
                deletable = true;
            }
        }
    }
}
