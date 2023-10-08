package thereciclator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LifeCounter {
    private ImageView sprite1;
    private ImageView sprite2;
    private ImageView sprite3;
    
    public LifeCounter(ImageView sprite1, ImageView sprite2, ImageView sprite3) {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
    }
    
    public void updateLife(int hp) {
        Image empty = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao1.png"));
        Image half = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao2.png"));
        Image full = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao3.png"));
        
        switch (hp) {
            case 0:
                sprite1.setImage(empty);
                sprite2.setImage(empty);
                sprite3.setImage(empty);
                break;
            
            case 1:
                sprite1.setImage(half);
                sprite2.setImage(empty);
                sprite3.setImage(empty);
                break;
            
            case 2:
                sprite1.setImage(full);
                sprite2.setImage(empty);
                sprite3.setImage(empty);
                break;
                
            case 3:
                sprite1.setImage(full);
                sprite2.setImage(half);
                sprite3.setImage(empty);
                break;
                
            case 4:
                sprite1.setImage(full);
                sprite2.setImage(full);
                sprite3.setImage(empty);
                break;
                
            case 5:
                sprite1.setImage(full);
                sprite2.setImage(full);
                sprite3.setImage(half);
                break;
                
            case 6:
                sprite1.setImage(full);
                sprite2.setImage(full);
                sprite3.setImage(full);
                break;
        }
    }
}
