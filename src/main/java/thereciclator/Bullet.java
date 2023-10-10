package thereciclator;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullet extends Character {
    public int speed;
    
    public Bullet(Pane container, ImageView sprite, int speed) {
        super(container, sprite);
    
        this.speed = speed;
    }
}
